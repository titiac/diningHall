package com.base.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.base.backend.common.R;
import com.base.backend.mapper.OrderDetailMapper;
import com.base.backend.mapper.OrderMapper;
import com.base.backend.pojo.FzuOrder;
import com.base.backend.pojo.OrderDetail;
import com.base.backend.pojo.User;
import com.base.backend.pojo.vo.OrderDishVo;
import com.base.backend.pojo.vo.SendOrderVo;
import com.base.backend.service.OrderService;
import com.base.backend.service.impl.utils.UserDetailsImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
    
    @Override
    public R sendOrder(SendOrderVo sendOrderVo) {
        User user = getUser();
        Integer dinerId = user.getId();
        Double total = sendOrderVo.getTotal();
        
        Date createTime = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmssSSS");
        Random r = new Random();
        String order_id = "FDD" + sdf.format(new Date()) + r.nextInt(9);
        
        Integer seat_id = sendOrderVo.getSeatId();
        FzuOrder fzuOrder = new FzuOrder(null, order_id, dinerId, null, seat_id, 0, total, createTime, null, null);
        
        orderMapper.insert(fzuOrder);
        QueryWrapper<FzuOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("order_id", order_id);
        FzuOrder olderOrder = orderMapper.selectOne(wrapper);

        List<OrderDishVo> orderDishVos = sendOrderVo.getOrderDishVos();
        
        for(OrderDishVo orderDishVo : orderDishVos){
            Integer dishId = orderDishVo.getDishId();
            Integer num = orderDishVo.getNum();
            orderDetailMapper.insert(new OrderDetail(null, olderOrder.getId(), dishId, num));
        }
        
        return R.ok().message("点餐成功！");
    }
    
    public User getUser() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        User user = loginUser.getUser();
        return user;
    }
}

