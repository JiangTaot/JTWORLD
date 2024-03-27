package com.jt.common.handler;

import cn.hutool.core.util.StrUtil;
import com.jt.common.exception.ResultException;
import com.jt.common.resp.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLSyntaxErrorException;

/**
 * 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ResultException.class)
    public BaseResult<Object> handleException(ResultException e) {
        log.error("系统异常：{0}", e);
        if (e.getResultCode() != null) {
            return BaseResult.failed(e.getResultCode());
        }
        return BaseResult.failed(e.getMessage());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    public BaseResult<Object> handleValidException(MethodArgumentNotValidException e) {
        log.error("系统参数校验异常：{0}", e);
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return BaseResult.validateFailed(message);
    }

    @ExceptionHandler(value = SQLSyntaxErrorException.class)
    public BaseResult<Object> handleSQLSyntaxErrorException(SQLSyntaxErrorException e) {
        log.error("SQL异常：{0}", e);
        String message = e.getMessage();
        if (StrUtil.isNotEmpty(message) && message.contains("denied")) {
            message = "演示环境暂无修改权限，如需修改数据可本地搭建后台服务！";
        }
        return BaseResult.failed(message);
    }
}
