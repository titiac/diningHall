package com.base.backend.controller;

import com.base.backend.common.R;
import com.base.backend.pojo.vo.AddDishVo;
import com.base.backend.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: diningHall
 * @description: 菜品相关接口
 * @author: zhw
 * @created: 2022/12/09 15:54
 */
@RestController
@RequestMapping("/dish")
public class DishController {
    
    @Autowired
    private DishService dishService;
    
    @PostMapping("/add")
    public R addDish(@RequestBody AddDishVo addDishVo) {
        return dishService.addDish(addDishVo);
    }
}

