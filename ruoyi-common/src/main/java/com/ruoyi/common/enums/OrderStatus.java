package com.ruoyi.common.enums;

/**
 * 用户状态
 *
 * @author ruoyi
 */
public enum OrderStatus {
    HZ_ORDER_GOING(0, "正在进行订单"),
    HZ_ORDER_FINISH(1, "完成订单"),
    HZ_ORDER_EXCEPTION(-1, "异常订单");

    private final Integer code;
    private final String info;

    OrderStatus(Integer code, String info) {
        this.code = code;
        this.info = info;
    }


    public Integer getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
