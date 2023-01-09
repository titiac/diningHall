package com.base.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.base.backend.common.R;
import com.base.backend.mapper.DishMapper;
import com.base.backend.mapper.OrderDetailMapper;
import com.base.backend.mapper.OrderMapper;
import com.base.backend.mapper.UserMapper;
import com.base.backend.pojo.Dish;
import com.base.backend.pojo.FzuOrder;
import com.base.backend.pojo.OrderDetail;
import com.base.backend.pojo.User;
import com.base.backend.pojo.vo.AdminDeliveryVo;
import com.base.backend.pojo.vo.OrderDishVo;
import com.base.backend.pojo.vo.SendOrderVo;
import com.base.backend.service.OrderService;
import com.base.backend.service.impl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: diningHall
 * @description: 与订单相关的
 * @author: zhw
 * @created: 2022/12/09 21:10
 */
@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderMapper orderMapper;
    
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private DishMapper dishMapper;
    
    @Override
    public R sendOrder(SendOrderVo sendOrderVo) {
        User user = getUser();
        Integer dinerId = user.getId();

        QueryWrapper<FzuOrder> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("diner_id", dinerId)
                .and(i -> i.ne("status", 3))
                .and(i -> i.ne("status", 0));
        
        List<FzuOrder> fzuOrderList = orderMapper.selectList(wrapper1);
        if(!fzuOrderList.isEmpty()) {
            return R.error().message("您有订单还未完成请勿重复提交");
        }

        Double total = sendOrderVo.getTotal();
        
        Date createTime = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmssSSS");
        Random r = new Random();
        String orderNo = "OO" + sdf.format(new Date()) + r.nextInt(9);
        
        Integer seat_id = sendOrderVo.getSeatId();
        Integer status = -1;
        if(user.getBalance() >= total) {
            status = 2;
            user.setBalance(user.getBalance() - total);
            userMapper.updateById(user);
        } else {
            return R.error().message("余额不足请及时缴费");
        }
        FzuOrder fzuOrder = new FzuOrder(null, orderNo, dinerId, null, seat_id, status, total, createTime, null, null);
        
        orderMapper.insert(fzuOrder);
        QueryWrapper<FzuOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no", orderNo);
        FzuOrder olderOrder = orderMapper.selectOne(wrapper);

        List<OrderDishVo> orderDishVos = sendOrderVo.getOrderDishVos();
        
        for(OrderDishVo orderDishVo : orderDishVos){
            Integer dishId = orderDishVo.getId();
            Integer num = orderDishVo.getCount();
            if(num <= 0) continue;
            orderDetailMapper.insert(new OrderDetail(null, olderOrder.getId(), dishId, num));
        }
        
        return R.ok().message("点餐成功！");
    }

    @Override
    public R settlement(Integer id) {
        User user = getUser();
        QueryWrapper<FzuOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        FzuOrder fzuOrder = orderMapper.selectOne(wrapper);
        
        if(fzuOrder == null) {
            return R.error().message("没有找到该订单！");
        }
        
        if(!Objects.equals(fzuOrder.getDinerId(), user.getId())) {
            return R.error().message("该订单不属于您！");
        }
        
        if(fzuOrder.getStatus() != 0) {
            return R.error().message("您的订单已缴费请勿重新缴费!");
        }
        
        if(user.getBalance() < fzuOrder.getTotal()) {
            return R.error().message("您的余额不足，请及时缴费！");
        }
        
        fzuOrder.setStatus(2);
        orderMapper.updateById(fzuOrder);
        
        Double balance = user.getBalance();
        balance = balance - fzuOrder.getTotal();
        user.setBalance(balance);
        userMapper.updateById(user);
        
        return R.ok().message("支付成功！");
    }

    @Override
    public R customerGetOrder() {
        User user = getUser();

        QueryWrapper<FzuOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("diner_id", user.getId())
                .and(i -> i.eq("status", 2))
                .orderByAsc("create_time");
        List<FzuOrder> fzuOrders = orderMapper.selectList(wrapper);
        if(fzuOrders.isEmpty()) {
            return R.ok().message("您没有正在配送的订单");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("order", fzuOrders.get(0));

        QueryWrapper<FzuOrder> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("status", 2)
                .orderByAsc("create_time");
        
        List<FzuOrder> fzuOrderList = orderMapper.selectList(wrapper1);
        
        
        int count = 0;
        for(FzuOrder fzuOrder : fzuOrderList) {
            System.out.println(fzuOrder.getId());
            if (Objects.equals(fzuOrder.getId(), fzuOrders.get(0).getId())) {
                map.put("queue", count);
                break;
            }
            count ++;
        }
        System.out.println(map);
        return R.ok().data(map);
    }

    @Override
    public R getOrderDetail(Integer id) {
        QueryWrapper<OrderDetail> wrapper = new QueryWrapper<>();
        
        wrapper.eq("order_id", id);
        
        List<OrderDetail> orderDetails = orderDetailMapper.selectList(wrapper);
        
        List<Map<String,Object>> dishes = new ArrayList<>();
        
        for(OrderDetail orderDetail : orderDetails) {
            Map<String, Object> map = new HashMap<>();
            Dish dish = dishMapper.selectById(orderDetail.getDishId());
            map.put("dish", dish);
            map.put("num", orderDetail.getNum());
            dishes.add(map);
        }
        
        return R.ok().data("dishes", dishes);
    }

    @Override
    public R adminGetOrder() {
        User user = getUser();

        if(user.getType() != 0) {
            return R.error().message("非法操作");
        }
        
        QueryWrapper<FzuOrder> wrapper = new QueryWrapper<>();
        wrapper.ne("status", 0)
                .orderByAsc("status")
                .orderByAsc("create_time");
        
        
        List<FzuOrder> fzuOrders = orderMapper.selectList(wrapper);
        
        return R.ok().data("orders", fzuOrders);
    }

    @Override
    public R adminStartDelivery(AdminDeliveryVo adminDeliveryVo) {
        User user = getUser();
        
        if(user.getType() != 0) {
            return R.error().message("非法操作");
        }
        
        Integer orderId = adminDeliveryVo.getOrderId();
        Integer status = adminDeliveryVo.getStatus();
        
        if(orderId == null || status == null) {
            return R.error().message("参数缺失！");
        }
        
        if(status != 1 && status != 3) {
            return R.error().message("参数错误");
        }
        
        QueryWrapper<FzuOrder> wrapper = new QueryWrapper<>();
        FzuOrder fzuOrder = orderMapper.selectById(orderId);
        
        if(fzuOrder == null) {
            return R.error().message("未找到订单！");
        }
        fzuOrder.setStatus(status);
        fzuOrder.setStaffId(user.getId());
        if(status == 1) {
            fzuOrder.setStartTime(new Date());
        } else {
            Double balance = user.getBalance();
            balance = balance + fzuOrder.getTotal();
            user.setBalance(balance);
            userMapper.updateById(user);
            fzuOrder.setFinishTime(new Date());
        }
        orderMapper.updateById(fzuOrder);
        Map<String, Object> map = new HashMap<>();
        map.put("dinerId", fzuOrder.getDinerId());
        map.put("seatId", fzuOrder.getSeatId());
        map.put("orderNo", fzuOrder.getOrderNo());
        if(status == 3) {
            return R.ok().data(map);
        } 
        
        return R.ok();
    }

    @Override
    public R adminGetPeriodNum() {
        User user = getUser();

        if(user.getType() != 0) {
            return R.error().message("非法操作");
        }
        
        List<Map<String, Object>> periodNumberList = orderMapper.getPeriodNumber(new Date());
        List<Map<String, Object>> returnList = new ArrayList<>();
        Integer[] cmp = new Integer[3];
        for(int i = 0; i < 3; i ++) cmp[i] = 0;
        
        System.out.println(periodNumberList);
        for(Map<String, Object> map : periodNumberList) {
            if(map.get("time_period").equals("00~08")) {
                cmp[0] = Integer.parseInt(String.valueOf(map.get("number")));
            } else if(map.get("time_period").equals("08~16")) {
                cmp[1] = Integer.parseInt(String.valueOf(map.get("number")));
            } else if(map.get("time_period").equals("16~00")) {
                cmp[2] = Integer.parseInt(String.valueOf(map.get("number")));
            }
        }
        
        if(cmp[0] == 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("time_period", "00~08");
            map.put("number", 0);
            returnList.add(map);
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("time_period", "00~08");
            map.put("number", cmp[0]);
            returnList.add(map);
        }
        
        if(cmp[1] == 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("time_period", "08~16");
            map.put("number", 0);
            returnList.add(map);
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("time_period", "08~16");
            map.put("number", cmp[1]);
            returnList.add(map);
        }

        if(cmp[2] == 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("time_period", "16~00");
            map.put("number", 0);
            returnList.add(map);
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("time_period", "16~00");
            map.put("number", cmp[2]);
            returnList.add(map);
        }
        

        return R.ok().data("periodNumberList", returnList);
    }

    @Override
    public R getOrderStatus(Integer orderId) {
        if(orderId == null) {
            return R.error().message("参数为空");
        }
        
        FzuOrder fzuOrder = orderMapper.selectById(orderId);
        
        if(fzuOrder == null) {
            return R.error().message("未找到订单");
        }
        
        Integer status = fzuOrder.getStatus();
        
        if(status == 0) {
            return R.ok().message("未结算");
        }
        
        if(status == 1) {
            return R.ok().message("正在配送");
        }
        
        if(status == 2) {
            return R.ok().message("未配送");
        }
        
        if(status == 3) {
            return R.ok().message("配送完成");
        }
        
        return null;
    }

    public User getUser() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        User user = loginUser.getUser();
        return user;
    }
}