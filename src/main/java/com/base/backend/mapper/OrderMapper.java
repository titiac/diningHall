package com.base.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.base.backend.pojo.FzuOrder;
import com.base.backend.pojo.vo.CustomerGetAllOrderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper extends BaseMapper<FzuOrder> {
    
    Integer getAverageDeliveryTime(Integer staffId);
    
    List<Map<String, Object>> getPeriodNumber(Date date);
     
    List<CustomerGetAllOrderVo> getCustomerAllOrder(Integer id);
}
