package com.base.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String orderNo;            /* 订单号 */
    private Integer dinerId;            /* 食客id */
    private Integer staffId;            /* 服务职员id */
    private Integer seatId;             /* 座位号 */
    private Integer status;             /* 服务状态 0 未结算, 1 表示开始配餐, 2 表示结算未配餐, 3 结束配餐*/
    private Double total;               /* 总价 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS", timezone = "Asia/Shanghai")
    private Date createTime;            /* 订单创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS", timezone = "Asia/Shanghai")
    private Date startTime;             /* 订单开始配送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS", timezone = "Asia/Shanghai")
    private Date finishTime;            /* 订单完成配送时间 */

    public FzuOrder(Integer id, String orderNo, Integer dinerId, Integer staffId, Integer seatId, 
                    Integer status, Double total, Date createTime, Date startTime, Date finishTime) {
        this.id = id;
        this.orderNo = orderNo;
        this.dinerId = dinerId;
        this.staffId = staffId;
        this.seatId = seatId;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
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