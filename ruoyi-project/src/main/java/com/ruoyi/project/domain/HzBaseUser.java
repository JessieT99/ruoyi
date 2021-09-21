package com.ruoyi.project.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户表 hz_base_user
 * 
 * @author ruoyi
 * @date 2021-09-21
 */
public class HzBaseUser extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/**  */
	private String openId;
	/** 头像 */
	private String headPhoto;
	/** 昵称 */
	private String niclName;
	/** 国家 */
	private String country;
	/** 省 */
	private String province;
	/** 市 */
	private String city;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setOpenId(String openId) 
	{
		this.openId = openId;
	}

	public String getOpenId() 
	{
		return openId;
	}
	public void setHeadPhoto(String headPhoto) 
	{
		this.headPhoto = headPhoto;
	}

	public String getHeadPhoto() 
	{
		return headPhoto;
	}
	public void setNiclName(String niclName) 
	{
		this.niclName = niclName;
	}

	public String getNiclName() 
	{
		return niclName;
	}
	public void setCountry(String country) 
	{
		this.country = country;
	}

	public String getCountry() 
	{
		return country;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("openId", getOpenId())
            .append("headPhoto", getHeadPhoto())
            .append("niclName", getNiclName())
            .append("country", getCountry())
            .append("province", getProvince())
            .append("city", getCity())
            .append("remark", getRemark())
            .toString();
    }
}
