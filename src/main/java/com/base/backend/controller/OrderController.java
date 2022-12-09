package com.base.backend.controller;

import com.base.backend.common.R;
import com.base.backend.pojo.vo.SendOrderVo;
import com.base.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}

