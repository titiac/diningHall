package com.base.backend.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: diningHall
 * @description: 管理员配送所需参数
 * @author: zhw
 * @created: 2022/12/11 10:56
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminDeliveryVo {
    private Integer orderId;
    private Integer status;         /* 只发送2和3 */
}

