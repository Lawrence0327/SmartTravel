package com.hrbeu.zzw.enums;

/**
 * Created by lawrence on 2017/4/16.
 */
public enum ResponseStatus {
    // success
    OK(1, "success"),

    // failed

    EXISTED(2, "手机号/邮箱已注册"),

    WRONGCODE(3, "验证码不正确"),

    WRONGPSD(4, "用户名或密码错误"),

    ERROR(0, "failed"),

    // unknow

    UNKNOWN(-1,"unknown");

    private int code;

    private String msg;

    ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ResponseStatus typeOf(int code) {
        for(ResponseStatus value : values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        return UNKNOWN;
    }
}
