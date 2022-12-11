package com.base.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.base.backend.pojo.Dish;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {

    List<Map<String, Object>> getPopularDish(Date date);
}
