package com.base.backend.pojo.vo.dish;

import com.base.backend.pojo.Dish;

/**
 * @program: diningHall
 * @description: 主食类
 * @author: zhw
 * @created: 2022/12/09 16:27
 */
public class Staple extends Dish {
    public Staple(Integer id, Integer type, String ingredient, String name, String photo, Double price) {
        super(id, type, ingredient, name, photo, price);
    }
}

