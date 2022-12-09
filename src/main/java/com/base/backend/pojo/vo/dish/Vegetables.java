package com.base.backend.pojo.vo.dish;

import com.base.backend.pojo.Dish;

/**
 * @program: diningHall
 * @description: 蔬菜类
 * @author: zhw
 * @created: 2022/12/09 16:25
 */
public class Vegetables extends Dish {
    public Vegetables(Integer id, Integer type, String ingredient, String name, String photo, Double price) {
        super(id, type, ingredient, name, photo, price);
    }
}

