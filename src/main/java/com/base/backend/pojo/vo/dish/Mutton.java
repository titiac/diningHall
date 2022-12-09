package com.base.backend.pojo.vo.dish;

import com.base.backend.pojo.Dish;

/**
 * @program: diningHall
 * @description: 羊肉类
 * @author: zhw
 * @created: 2022/12/09 16:23
 */
public class Mutton extends Dish {
    public Mutton(Integer id, Integer type, String ingredient, String name, String photo, Double price) {
        super(id, type, ingredient, name, photo, price);
    }
}

