package com.base.backend.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: diningHall
 * @description: 请求识别
 * @author: zhw
 * @created: 2022/12/09 21:57
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SendOrderVo {
    private List<OrderDishVo> orderDishVos;
    private Integer seatId;
    private Double total;
}