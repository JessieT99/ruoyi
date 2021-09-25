package com.ruoyi.common.enums;

/**
 * 用户状态
 *
 * @author ruoyi
 */
public enum MqttStatus {
    HZ_BANK_ERROR("0", "error"),
    HZ_BANK_SUCCESS("1", "success");

    private final String code;
    private final String info;

    MqttStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }


    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
