package com.jt.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode implements StatusCode {
    SUCCESS("0000", "成功"),
    FAILED("0001", "失败"),
    VALIDATE_FAILED("0002", "参数检验失败"),
    UNAUTHORIZED("0003", "暂未登录或token已经过期"),
    FORBIDDEN("0004", "没有相关权限"),
    RESPONSE_PACK_ERROR("0005", "response返回包装失败");

    private final String code;
    private final String msg;

}
