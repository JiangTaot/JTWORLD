package com.jt.admin.handler;

import com.jt.common.exception.ResultException;
import com.jt.common.resp.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.AccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class AdminGlobalExceptionHandler{

    @ExceptionHandler(AccessDeniedException.class)
    public BaseResult<Object> handleAccessDeniedException(AccessDeniedException e) {
        log.error("权限异常：{0}", e);
        if (e.getMessage() != null) {
            return BaseResult.failed(e.getMessage());
        }
        return BaseResult.failed(e.getMessage());
    }

}
