package com.ruoyi.project.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.math.BigDecimal;

/**
 * 充电坞表 hz_charge_dock
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
public class HzChargeDock extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 创建人 */
	private Integer createUserId;
	/** 唯一编码 */
	private String codeUnique;
	/** 省 */
	private String province;
	/** 市 */
	private String city;
	/** 区 */
	private String area;
	/** 街道具体地址 */
	private String location;
	/** 店铺名称 */
	private String shopName;
	/** 商圈 */
	private String businessDistrict;
	/** 充电槽 */
	private String chargeTankNum;
	/** 经度 */
	private BigDecimal locationLongitude;
	/** 纬度 */
	private BigDecimal locationLatitude;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setCreateUserId(Integer createUserId) 
	{
		this.createUserId = createUserId;
	}

	public Integer getCreateUserId() 
	{
		return createUserId;
	}
	public void setCodeUnique(String codeUnique) 
	{
		this.codeUnique = codeUnique;
	}

	public String getCodeUnique() 
	{
		return codeUnique;
	}
	public void setProvince(String province) 
	{
		this.province = province;
	}

	public String getProvince() 
	{
		return province;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getCity() 
	{
		return city;
	}
	public void setArea(String area) 
	{
		this.area = area;
	}

	public String getArea() 
	{
		return area;
	}
	public void setLocation(String location) 
	{
		this.location = location;
	}

	public String getLocation() 
	{
		return location;
	}
	public void setShopName(String shopName) 
	{
		this.shopName = shopName;
	}

	public String getShopName() 
	{
		return shopName;
	}
	public void setBusinessDistrict(String businessDistrict) 
	{
		this.businessDistrict = businessDistrict;
	}

	public String getBusinessDistrict() 
	{
		return businessDistrict;
	}
	public void setChargeTankNum(String chargeTankNum) 
	{
		this.chargeTankNum = chargeTankNum;
	}

	public String getChargeTankNum() 
	{
		return chargeTankNum;
	}
	public void setLocationLongitude(BigDecimal locationLongitude) 
	{
		this.locationLongitude = locationLongitude;
	}

	public BigDecimal getLocationLongitude() 
	{
		return locationLongitude;
	}
	public void setLocationLatitude(BigDecimal locationLatitude) 
	{
		this.locationLatitude = locationLatitude;
	}

	public BigDecimal getLocationLatitude() 
	{
		return locationLatitude;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createUserId", getCreateUserId())
            .append("codeUnique", getCodeUnique())
            .append("province", getProvince())
            .append("city", getCity())
            .append("area", getArea())
            .append("location", getLocation())
            .append("shopName", getShopName())
            .append("businessDistrict", getBusinessDistrict())
            .append("chargeTankNum", getChargeTankNum())
            .append("locationLongitude", getLocationLongitude())
            .append("locationLatitude", getLocationLatitude())
            .toString();
    }
}
