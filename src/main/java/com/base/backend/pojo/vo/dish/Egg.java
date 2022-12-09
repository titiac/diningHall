package com.base.backend.pojo.vo.dish;

import com.base.backend.pojo.Dish;

/**
 * @program: diningHall
 * @description: 鸡蛋类
 * @author: zhw
 * @created: 2022/12/09 16:26
 */
public class Egg extends Dish {
    public Egg(Integer id, Integer type, String ingredient, String name, String photo, Double price) {
        super(id, type, ingredient, name, photo, price);
    }
}

