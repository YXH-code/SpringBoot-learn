package com.yu66.result;

/**
 * @description: 返回状态码
 * @author: 俞先浩
 * @create: 2021-02-23 11:22
 **/
public class Result {
    //响应码
    private int code;

    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
