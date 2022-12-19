package com.base.backend.controller;

import com.base.backend.common.R;
import com.base.backend.pojo.vo.AdminDeliveryVo;
import com.base.backend.pojo.vo.SendOrderVo;
import com.base.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: diningHall
 * @description: 订单相关
 * @author: zhw
 * @created: 2022/12/09 21:35
 */
@RestController
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    /**
     * @Author: zhw
     * @Description: 发起订单请求
     * @DateTime: 2022/12/9 21:46
     */
    @PostMapping("/send/order")
    public R sendOrder(@RequestBody SendOrderVo sendOrderVo){
        return orderService.sendOrder(sendOrderVo);
    }
    
    /**
     * @Author: zhw
     * @Description:  结算订单
     * @DateTime: 2022/12/10 18:50
     */
    @GetMapping("/settlement/order")
    public R settlement(@RequestParam Integer id) {
        return orderService.settlement(id);
    }
    
    /**
     * @Author: zhw
     * @Description: 客户获取自己的订单
     * @DateTime: 2022/12/10 18:51
     */
    @GetMapping("/customer/get/order")
    public R customerGetOrder(){
        return orderService.customerGetOrder();
    }
    
    /**
     * @Author: zhw
     * @Description: 管理员获取已结算的订单
     * @DateTime: 2022/12/10 18:58
     */
    @GetMapping("/admin/get/order")
    public R adminGetOrder(){
        return orderService.adminGetOrder();
    }
    
    
    /**
     * @Author: zhw
     * @Description: 获取订单详情
     * @DateTime: 2022/12/10 23:23
     */
    @GetMapping("/get/order/detail")
    public R getOrderDetail(@RequestParam Integer orderId){
        return orderService.getOrderDetail(orderId);
    }
    
    /**
     * @Author: zhw
     * @Description: 管理员配餐
     * @DateTime: 2022/12/10 23:59
     */
    @PostMapping("/admin/delivery")
    public R adminStartDelivery(@RequestBody AdminDeliveryVo adminDeliveryVo){
        return orderService.adminStartDelivery(adminDeliveryVo);
    }
    
    @GetMapping("/admin/getPeriodNum")
    public R adminGetPeriodNum(){
        return orderService.adminGetPeriodNum();
    }
    
    /**
     * @Author: zhw
     * @Description: 查询订单状态
     * @DateTime: 2022/12/19 10:24
     */
    @GetMapping("/get/order/status")
    public R getOrderStatus(@RequestParam Integer orderId){
        return orderService.getOrderStatus(orderId);
    }
}