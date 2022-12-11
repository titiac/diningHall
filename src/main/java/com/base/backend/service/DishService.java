package com.base.backend.service;

import com.base.backend.common.R;
import com.base.backend.pojo.vo.AddDishVo;
import com.base.backend.pojo.vo.ModifyDishVo;

public interface DishService {
    R addDish(AddDishVo addDishVo);

    R modify(ModifyDishVo dish);

    R getDish();

    R getPopularDish();
}
