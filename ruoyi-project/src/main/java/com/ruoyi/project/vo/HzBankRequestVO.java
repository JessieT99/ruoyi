package com.ruoyi.project.vo;

import com.ruoyi.project.domain.HzBankOrder;
import lombok.Data;

/**
 * 用户表 hz_base_user
 * 
 * @author ruoyi
 * @date 2021-09-21
 */
@Data
public class HzBankRequestVO
{
	private String type;
	private String service;
	private String status;
	private String openId;
	private String qrCode;
	private String bankId;
	private Long orderId;

	@Override
	public String toString() {
		return "HzBankRequestVO{" +
				"type='" + type + '\'' +
				", service='" + service + '\'' +
				", status='" + status + '\'' +
				", openId='" + openId + '\'' +
				", qrCode='" + qrCode + '\'' +
				", bankId='" + bankId + '\'' +
				", orderId=" + orderId +
				'}';
	}
}
