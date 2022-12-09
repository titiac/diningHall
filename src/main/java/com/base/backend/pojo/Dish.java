package com.base.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @program: diningHall
 * @description: 菜肴类, 抽象类
 * @author: zhw
 * @created: 2022/12/09 13:51
 */

public abstract class Dish {
    @TableId(type = IdType.AUTO)
    private Integer id;         /* 主键id */
    private Integer type;        /* 类别 */
    private String ingredient;  /* 原材料 */
    private String name;        /* 菜品名称 */
    private String photo;       /* 菜品图片 */
    private Double price;       /* 菜品金额 */

    public Dish(Integer id, Integer type, String ingredient, String name, String photo, Double price) {
        this.id = id;
        this.type = type;
        this.ingredient = ingredient;
        this.name = name;
        this.photo = photo;
        this.price = price;
    }

    public Dish() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

