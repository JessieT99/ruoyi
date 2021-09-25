package com.ruoyi.project.vo;

import lombok.Data;

/**
 * 用户表 hz_base_user
 * 
 * @author ruoyi
 * @date 2021-09-21
 */
@Data
public class HzBankOrderGIveVo
{
	private String type;
	private String status;
	private String openId;
	private String qrCode;
	private String bankId;

	@Override
	public String toString() {
		return "HzBankOrderGIveVo{" +
				"type='" + type + '\'' +
				", status='" + status + '\'' +
				", openId='" + openId + '\'' +
				", qrCode='" + qrCode + '\'' +
				", bankId='" + bankId + '\'' +
				'}';
	}
}
