package com.jt.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode implements StatusCode {
    SUCCESS("0000", "成功"),
    FAILED("0001", "失败");

    private final String code;
    private final String msg;

}
