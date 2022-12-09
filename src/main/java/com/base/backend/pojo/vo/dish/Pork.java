package com.base.backend.pojo.vo.dish;

import com.base.backend.pojo.Dish;

/**
 * @program: diningHall
 * @description: 猪肉类
 * @author: zhw
 * @created: 2022/12/09 16:20
 */
public class Pork extends Dish {
    public Pork(Integer id, Integer type, String ingredient, String name, String photo, Double price) {
        super(id, type, ingredient, name, photo, price);
    }
}

