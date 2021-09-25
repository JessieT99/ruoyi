package com.ruoyi.common.enums;

/**
 * 用户状态
 *
 * @author ruoyi
 */
public enum MqttType {
    HZ_BANK_INFO("0", "发送充电宝信息"),
    HZ_BANK_LEND("1", "借出充电宝"),
    HZ_BANK_GIVE_BACK("2", "归还充电宝");

    private final String code;
    private final String info;

    MqttType(String code, String info) {
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
