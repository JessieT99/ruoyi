package com.ruoyi.project.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告订单表 order_advertising
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
public class OrderAdvertising extends BaseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 订单编号 */
	private String orderCode;
	/** 订单创建时间 */
	private Date orderTime;
	/** 发布开始时间 */
	private Date startTime;
	/** 发布结束时间 */
	private Date endTime;
	/** 广告内容 */
	private String advertisingContent;
	/** 广告图片 */
	private String advertisingImg;
	/** 发布地区 */
	private String publishArea;
	/** 充电id集合 */
	private String dockIds;
	/** 用户openId */
	private String openId;
	/** 用户id */
	private Long userId;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setOrderCode(String orderCode) 
	{
		this.orderCode = orderCode;
	}

	public String getOrderCode() 
	{
		return orderCode;
	}
	public void setOrderTime(Date orderTime) 
	{
		this.orderTime = orderTime;
	}

	public Date getOrderTime() 
	{
		return orderTime;
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
	public void setAdvertisingContent(String advertisingContent) 
	{
		this.advertisingContent = advertisingContent;
	}

	public String getAdvertisingContent() 
	{
		return advertisingContent;
	}
	public void setAdvertisingImg(String advertisingImg) 
	{
		this.advertisingImg = advertisingImg;
	}

	public String getAdvertisingImg() 
	{
		return advertisingImg;
	}
	public void setPublishArea(String publishArea) 
	{
		this.publishArea = publishArea;
	}

	public String getPublishArea() 
	{
		return publishArea;
	}
	public void setDockIds(String dockIds) 
	{
		this.dockIds = dockIds;
	}

	public String getDockIds() 
	{
		return dockIds;
	}
	public void setOpenId(String openId) 
	{
		this.openId = openId;
	}

	public String getOpenId() 
	{
		return openId;
	}
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderCode", getOrderCode())
            .append("orderTime", getOrderTime())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("advertisingContent", getAdvertisingContent())
            .append("advertisingImg", getAdvertisingImg())
            .append("publishArea", getPublishArea())
            .append("dockIds", getDockIds())
            .append("openId", getOpenId())
            .append("userId", getUserId())
            .toString();
    }
}
