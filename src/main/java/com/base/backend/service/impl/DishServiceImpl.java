package com.base.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.base.backend.common.R;
import com.base.backend.factory.FoodFactory;
import com.base.backend.mapper.DishMapper;
import com.base.backend.pojo.Dish;
import com.base.backend.pojo.vo.AddDishVo;
import com.base.backend.pojo.vo.ModifyDishVo;
import com.base.backend.service.DishService;
import com.base.backend.utils.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: diningHall
 * @description: 与菜肴有关的增删改查
 * @author: zhw
 * @created: 2022/12/09 15:27
 */
@Service
public class DishServiceImpl implements DishService {
    
    @Autowired
    private DishMapper dishMapper;
    
    @Override
    public R addDish(AddDishVo addDishVo) {
        Integer userType = UserType.getUserType();

        if(userType != 0) {
            return R.error().message("您没有此权限进行此操作");
        }

        Integer type = addDishVo.getType();
        String ingredient = addDishVo.getIngredient();
        String name = addDishVo.getName();
        Double price = addDishVo.getPrice();
        
        if(type == null || ingredient == null || name == null || price == null || ingredient.length() == 0 || name.length() == 0) {
            return R.error().message("有参数为空");
        }
        
        Dish dish = FoodFactory.addDish(addDishVo);
        dishMapper.insert(dish);
        
        return R.ok();
    }

    @Override
    public R modify(ModifyDishVo dish) {
        Integer userType = UserType.getUserType();

        if(userType != 0) {
            return R.error().message("您没有此权限进行此操作");
        }
        
        Integer id = dish.getId();
        Integer type = dish.getType();
        String ingredient = dish.getIngredient();
        String name = dish.getName();
        Double price = dish.getPrice();

        if(id== null || type == null || ingredient == null || name == null || price == null || ingredient.length() == 0 || name.length() == 0) {
            return R.error().message("有参数为空");
        }
        
        Dish dish1 = FoodFactory.addDish(new AddDishVo(type, ingredient, name, price));
        dish1.setId(id);
        
        dishMapper.updateById(dish1);
        
        return R.ok();
    }

    @Override
    public R getDish() {
        QueryWrapper<Dish> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("type");
        List<Dish> dishes = dishMapper.selectList(wrapper);
        return R.ok().data("dishes", dishes);
    }

    @Override
    public R getPopularDish() {
        Integer userType = UserType.getUserType();

        if(userType != 0) {
            return R.error().message("您没有此权限进行此操作");
        }
        
        List<Map<String, Object>> list = dishMapper.getPopularDish(new Date());
        return R.ok().data("PopularDishes", list);
    }

}