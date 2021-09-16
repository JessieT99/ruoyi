package com.ruoyi.project.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 充电宝表 hz_power_bank
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
public class HzPowerBank extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 唯一编码 */
	private String codeUnique;
	/** 充电宝状态 */
	private Integer bankStatus;
	/** 电量 */
	private Integer bankElectricity;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setCodeUnique(String codeUnique) 
	{
		this.codeUnique = codeUnique;
	}

	public String getCodeUnique() 
	{
		return codeUnique;
	}
	public void setBankStatus(Integer bankStatus) 
	{
		this.bankStatus = bankStatus;
	}

	public Integer getBankStatus() 
	{
		return bankStatus;
	}
	public void setBankElectricity(Integer bankElectricity) 
	{
		this.bankElectricity = bankElectricity;
	}

	public Integer getBankElectricity() 
	{
		return bankElectricity;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("codeUnique", getCodeUnique())
            .append("bankStatus", getBankStatus())
            .append("bankElectricity", getBankElectricity())
            .toString();
    }
}
