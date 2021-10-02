package com.ruoyi.common.enums;

/**
 * 用户状态
 *
 * @author ruoyi
 */
public enum ServiceType {
    HZ_SERVICE_SERVER("0", "服务端"),
    HZ_SERVICE_CLIENT("1", "客户端");

    private final String code;
    private final String info;

    ServiceType(String code, String info) {
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
