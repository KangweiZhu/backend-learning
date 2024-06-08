package com.anicaaz.securitydemo.model;

/**
 * 自定义返回结果
 *
 * @author anicaa
 * @date 06/09/2024
 */
public class Result {
    private String code;
    private String msg;
    private Object data;

    private static final String FAIL_CODE = "fail";
    private static final String SUCCESS_CODE = "success";

    public Result() {

    }

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
