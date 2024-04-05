package com.jt.secure.handler;

import com.jt.common.handler.GlobalExceptionHandler;
import com.jt.common.resp.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class SecurityExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(value = AuthenticationException.class)
    public BaseResult<Object> handleAuthenticationException(AuthenticationException e) {
        log.error("身份验证异常：{0}", e);
        return BaseResult.failed(e.getMessage());
    }
}
