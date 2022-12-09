package com.base.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * @program: diningHall
 * @description: 订单类
 * @author: zhw
 * @created: 2022/12/09 14:21
 */

public class FzuOrder {
    @TableId(type = IdType.AUTO)
    private Integer id;                 /* 主键， 自增 */
    private Integer orderId;            /* 订单号 */
    private Integer dinerId;            /* 食客id */
    private Integer staffId;            /* 服务职员id */
    private Integer status;             /* 服务状态 0 表示未配餐, 1 表示开始配餐, 2 结束配餐*/
    private Double total;               /* 总价 */
    private Date createTime;            /* 订单创建时间 */
    private Date startTime;             /* 订单开始配送时间 */
    private Date finishTime;            /* 订单完成配送时间 */

    public FzuOrder(Integer id, Integer orderId, Integer dinerId, Integer staffId,
                    Integer status, Double total, Date createTime, Date startTime, Date finishTime) {
        this.id = id;
        this.orderId = orderId;
        this.dinerId = dinerId;
        this.staffId = staffId;
        this.status = status;
        this.total = total;
        this.createTime = createTime;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public FzuOrder() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getDinerId() {
        return dinerId;
    }

    public void setDinerId(Integer dinerId) {
        this.dinerId = dinerId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
}