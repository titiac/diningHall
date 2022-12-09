package com.base.backend.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: diningHall
 * @description: 修改菜品所需参数
 * @author: zhw
 * @created: 2022/12/09 19:17
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModifyDishVo {
    private Integer id;         /* 主键id */
    private Integer type;        /* 类别 */
    private String ingredient;  /* 原材料 */
    private String name;        /* 菜品名称 */
    private Double price;       /* 菜品金额 */
}