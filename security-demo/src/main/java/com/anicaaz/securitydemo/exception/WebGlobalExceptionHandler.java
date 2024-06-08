package com.anicaaz.securitydemo.exception;

import com.anicaaz.securitydemo.model.Result;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕获器
 *
 * @author anicaa
 * @date 06/09/2024
 */
@RestControllerAdvice
public class WebGlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler
    public Result exceptionHandler(HttpServletResponse httpServletResponse, Exception e) {
        //logger.info("服务器异常", e);
        httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new Result("服务器异常", e.getMessage(), null);
    }
}
