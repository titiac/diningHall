package com.base.backend.service;


import com.base.backend.common.R;
import com.base.backend.pojo.vo.OrderDishVo;
import com.base.backend.pojo.vo.SendOrderVo;

import java.util.List;

public interface OrderService {
    R sendOrder(SendOrderVo sendOrderVo);


    R settlement(Integer id);
}
