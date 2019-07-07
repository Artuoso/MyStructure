package com.uni.common.model;

/**
 * @Description 返回前端的响应结果类
 *
 * @author Created by zc on 2019/06/20
 */
public class ResponseResult<T> {

    /** 响应码 */
    private String code;
    /** 响应信息 */
    private String message;
    /** 响应数据 */
    private T data;

    /** 响应码：成功 */
    public static final String CODE_SUCCESS = "0";
    /** 响应码：失败 */
    public static final String CODE_ERROR = "1";

    public ResponseResult() {}

    public ResponseResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
