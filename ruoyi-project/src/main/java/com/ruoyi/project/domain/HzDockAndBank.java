package com.ruoyi.project.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 充电坞与充电宝关联表 hz_dock_and_bank
 * 
 * @author ruoyi
 * @date 2021-09-17
 */
public class HzDockAndBank extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 充电坞id */
	private Long dockId;
	/** 充电宝id */
	private Long bankId;
	/** 状态，是否失效 */
	private Integer state;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
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
	public void setState(Integer state) 
	{
		this.state = state;
	}

	public Integer getState() 
	{
		return state;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dockId", getDockId())
            .append("bankId", getBankId())
            .append("state", getState())
            .toString();
    }
}
