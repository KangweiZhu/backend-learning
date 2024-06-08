package com.anicaaz.securitydemo.exception;

import org.springframework.http.HttpStatus;

/**
 * 自定义 异常类
 *
 * @author anicaa
 * @date 06/09/2024
 */
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = -7972131521045668011L;
    private HttpStatus httpStatus;

    /**
     * 默认构造， Bad_Request
     */
    public BaseException() {
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    /**
     * 传入 HttpStatus 状态吗
     * @param httpStatus
     */
    public BaseException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    /**
     * 传入 错误信息 以及 HttpStatus 状态码
     * @param message
     * @param httpStatus
     */
    public BaseException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    /**
     * 获取 HttpStatus 状态码
     * @return HttpStatus 状态码
     */
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    /**
     * 设置 Http 状态码
     * @param httpStatus Http 状态码
     */
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
