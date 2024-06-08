package com.anicaaz.securitydemo.model;

/**
 *
 * 构建器模式
 * 使用final作用在类上， 阻止其他类继承自此类， 并且确保其不可变性，进而确保其线程安全
 *
 * @author anicaa
 * @date 06/29/2024
 */
public final class ResultBuilder {

    private Result result;

    public ResultBuilder() {
        this.result = new Result();
    }

    public static ResultBuilder aResult() {
        return new ResultBuilder();
    }

    public ResultBuilder setCode(String code) {
        this.result.setCode(code);
        return this;
    }

    public ResultBuilder setMessage(String message) {
        this.result.setMsg(message);
        return this;
    }

    public <T> ResultBuilder setData(T data) {
        this.result.setData(data);
        return this;
    }

    public Result build() {
        return this.result;
    }
}
