package com.base.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.base.backend.pojo.FzuOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<FzuOrder> {
}
