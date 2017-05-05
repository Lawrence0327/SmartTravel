package com.hrbeu.zzw.model;

import com.hrbeu.zzw.enums.ResponseStatus;

import java.io.Serializable;

/**
 * Created by lawrence on 2017/4/16.
 */
public class AjaxResponse<T> implements Serializable {

    // 代码
    private Integer code;
    //提示信息
    private String msg;
    //数据
    private T data;

    public AjaxResponse(ResponseStatus responseStatus, T data) {
        this.code = responseStatus.getCode();
        this.data = data;
        this.msg = responseStatus.getMsg();
    }

    public AjaxResponse(ResponseStatus responseStatus) {
        this.code = responseStatus.getCode();
        this.data = null;
        this.msg = responseStatus.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
