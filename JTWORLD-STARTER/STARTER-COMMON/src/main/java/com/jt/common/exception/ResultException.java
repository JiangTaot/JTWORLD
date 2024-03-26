package com.jt.common.exception;

import com.jt.common.error.ResultCode;
import lombok.Getter;

@Getter
public class ResultException extends RuntimeException{
    private ResultCode resultCode;

    public ResultException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
    }

    public ResultException(String msg){
        super(msg);
    }

    public ResultException(Throwable cause){
        super(cause);
    }

    public ResultException(String msg,Throwable cause){
        super(msg,cause);
    }
}
