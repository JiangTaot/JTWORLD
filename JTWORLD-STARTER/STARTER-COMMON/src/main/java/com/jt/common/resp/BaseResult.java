package com.jt.common.resp;

import com.jt.common.enums.ResultCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResult<T> {
    /**
     * 状态码
     */
    private String code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    protected BaseResult() {
    }

    protected BaseResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功
     *
     * @param data 数据
     */
    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
    }

    /**
     * 成功
     *
     * @param data 数据
     * @param msg  信息
     */
    public static <T> BaseResult<T> success(T data, String msg) {
        return new BaseResult<T>(ResultCode.SUCCESS.getCode(), msg, data);
    }

    /**
     * 失败
     * @param resultCode 错误码
     */
    public static <T> BaseResult<T> failed(ResultCode resultCode) {
        return new BaseResult<T>(resultCode.getCode(), resultCode.getMsg(), null);
    }

    /**
     * 失败
     * @param resultCode 错误码
     * @param msg 错误信息
     */
    public static <T> BaseResult<T> failed(ResultCode resultCode, String msg) {
        return new BaseResult<T>(resultCode.getCode(), msg, null);
    }

    /**
     * 失败
     * @param msg 错误信息
     */
    public static <T> BaseResult<T> failed(String msg) {
        return new BaseResult<T>(ResultCode.FAILED.getCode(), msg, null);
    }

    /**
     * 失败
     */
    public static <T> BaseResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败
     */
    public static <T> BaseResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败
     * @param msg 错误信息
     */
    public static <T> BaseResult<T> validateFailed(String msg) {
        return new BaseResult<T>(ResultCode.VALIDATE_FAILED.getCode(), msg, null);
    }

    /**
     * 未登录
     */
    public static <T> BaseResult<T> unauthorized(T data) {
        return new BaseResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMsg(), data);
    }

    /**
     * 未授权
     */
    public static <T> BaseResult<T> forbidden(T data) {
        return new BaseResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMsg(), data);
    }
}
