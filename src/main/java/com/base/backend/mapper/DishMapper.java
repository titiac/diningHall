package com.base.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.base.backend.pojo.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
