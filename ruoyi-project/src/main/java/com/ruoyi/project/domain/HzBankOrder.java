package com.ruoyi.project.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 充电宝订单表 hz_bank_order
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
public class HzBankOrder extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 订单开始时间 */
	private Date startTime;
	/** 订单结束时间 */
	private Date endTime;
	/** 用户 */
	private String orderUser;
	/** 充电坞id */
	private Long dockId;
	/** 充电宝id */
	private Long bankId;
	/** 订单编号 */
	private String orderCode;
	/** 订单耗时 */
	private Integer orderTime;
	/** 订单费用 */
	private BigDecimal orderCost;
	/** 订单状态 */
	private Integer orderStatus;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setStartTime(Date startTime) 
	{
		this.startTime = startTime;
	}

	public Date getStartTime() 
	{
		return startTime;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}
	public void setOrderUser(String orderUser) 
	{
		this.orderUser = orderUser;
	}

	public String getOrderUser() 
	{
		return orderUser;
	}
	public void setDockId(Long dockId) 
	{
		this.dockId = dockId;
	}

	public Long getDockId() 
	{
		return dockId;
	}
	public void setBankId(Long bankId) 
	{
		this.bankId = bankId;
	}

	public Long getBankId() 
	{
		return bankId;
	}
	public void setOrderCode(String orderCode) 
	{
		this.orderCode = orderCode;
	}

	public String getOrderCode() 
	{
		return orderCode;
	}
	public void setOrderTime(Integer orderTime) 
	{
		this.orderTime = orderTime;
	}

	public Integer getOrderTime() 
	{
		return orderTime;
	}
	public void setOrderCost(BigDecimal orderCost) 
	{
		this.orderCost = orderCost;
	}

	public BigDecimal getOrderCost() 
	{
		return orderCost;
	}
	public void setOrderStatus(Integer orderStatus) 
	{
		this.orderStatus = orderStatus;
	}

	public Integer getOrderStatus() 
	{
		return orderStatus;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("orderUser", getOrderUser())
            .append("dockId", getDockId())
            .append("bankId", getBankId())
            .append("orderCode", getOrderCode())
            .append("orderTime", getOrderTime())
            .append("orderCost", getOrderCost())
            .append("orderStatus", getOrderStatus())
            .toString();
    }
}
