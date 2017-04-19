package com.mei_husky.sampleneterrorutil.model.util;

/**
 * 网络返回基类
 * Created by fcn-mq on 2017/4/19.
 */

public class MyResponse<T> {

    public int code;    //非status code，而是服务器根据自己的规范返回的code

    public String msg;

    public T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isOk() {
        return code == 0;
    }
}
