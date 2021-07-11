package com.ruoyi.project.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * mqtt接收记录表 hz_mqtt_receive_log
 * 
 * @author ruoyi
 * @date 2021-07-08
 */
public class HzMqttReceiveLog extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 主题 */
	private String topic;
	/** qos */
	private String qos;
	/** 内容 */
	private String content;
	/** 客户端id */
	private String clientId;
	/** 标志位 */
	private Integer enable;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setTopic(String topic) 
	{
		this.topic = topic;
	}

	public String getTopic() 
	{
		return topic;
	}
	public void setQos(String qos) 
	{
		this.qos = qos;
	}

	public String getQos() 
	{
		return qos;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setClientId(String clientId) 
	{
		this.clientId = clientId;
	}

	public String getClientId() 
	{
		return clientId;
	}
	public void setEnable(Integer enable) 
	{
		this.enable = enable;
	}

	public Integer getEnable() 
	{
		return enable;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("topic", getTopic())
            .append("qos", getQos())
            .append("content", getContent())
            .append("clientId", getClientId())
            .append("enable", getEnable())
            .append("createTime", getCreateTime())
            .toString();
    }
}
