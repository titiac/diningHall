package com.base.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @program: diningHall
 * @description: 订单详情
 * @author: zhw
 * @created: 2022/12/09 20:09
 */


public class OrderDetail {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer orderId;
    private Integer dishId;
    private Integer num;
    
    public OrderDetail() {
    }

    public OrderDetail(Integer id, Integer orderId, Integer dishId, Integer num) {
        this.id = id;
        this.orderId = orderId;
        this.dishId = dishId;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}