package com.base.backend.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: diningHall
 * @description: 添加菜品所需参数
 * @author: zhw
 * @created: 2022/12/09 16:04
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddDishVo {
    private Integer type;
    private String ingredient;
    private String name;
    private Double price;
}

