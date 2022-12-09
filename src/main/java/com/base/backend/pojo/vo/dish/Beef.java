package com.base.backend.pojo.vo.dish;

import com.base.backend.pojo.Dish;

/**
 * @program: diningHall
 * @description: 牛肉类
 * @author: zhw
 * @created: 2022/12/09 16:21
 */
public class Beef extends Dish {
    public Beef(Integer id, Integer type, String ingredient, String name, String photo, Double price) {
        super(id, type, ingredient, name, photo, price);
    }
}

