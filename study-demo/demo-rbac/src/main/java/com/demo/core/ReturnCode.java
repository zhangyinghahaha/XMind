package com.demo.core;

/**
 * @author ying.zhang01
 */

public enum ReturnCode {
    /**操作成功**/
    RC100(100,"操作成功"),
    /**操作失败**/
    RC999(999,"操作失败"),
    // 无访问权限
    RC401(401,"匿名用户访问无权限资源时的异常"),
    // 服务异常
    RC500(500,"系统异常，请稍后重试"),
    INVALID_TOKEN(2001,"访问令牌不合法"),
    ACCESS_DENIED(2003,"没有权限访问该资源"),
    INVALID_ARGUMENTS(1001,"非法参数");

    private final int code;
    private final String message;

    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
