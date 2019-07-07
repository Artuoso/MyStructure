package com.uni.common.exception;

/**
* @Description 自定义异常
*
* @author Created by zc on 2019/6/24
*/
public class DefinedException extends Exception{

    /**
     * 异常码
     */
    private String code;

    public DefinedException() {}

    /**
     * 构造函数
     * @param message（异常信息）
     */
    public DefinedException(String message) {
        super(message);
    }

    /**
     * 构造函数
     * @param code（异常码）
     * @param message（异常信息）
     */
    public DefinedException(String code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 获取异常码
     */
    public String getCode() {
        return code;
    }

}
