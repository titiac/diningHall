package com.base.backend.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: diningHall
 * @description: 点餐菜品
 * @author: zhw
 * @created: 2022/12/09 20:58
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDishVo {
    private Integer dishId;
    private Integer num;
}