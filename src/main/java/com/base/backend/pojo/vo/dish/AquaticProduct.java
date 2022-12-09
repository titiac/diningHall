package com.base.backend.pojo.vo.dish;

import com.base.backend.pojo.Dish;

/**
 * @program: diningHall
 * @description: 水产品类
 * @author: zhw
 * @created: 2022/12/09 16:25
 */
public class AquaticProduct extends Dish {
    
    public AquaticProduct(Integer id, Integer type, String ingredient, String name, String photo, Double price) {
        super(id, type, ingredient, name, photo, price);
    }
}

