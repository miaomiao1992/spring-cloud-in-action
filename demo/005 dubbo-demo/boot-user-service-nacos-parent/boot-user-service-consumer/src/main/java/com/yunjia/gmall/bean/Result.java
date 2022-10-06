package com.yunjia.gmall.bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 * 响应体，主要用来做接口统一返回格式
 */
@Data
public class Result {
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public Result() {
    }

    public Result(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Result(Object data) {
        this.status = 0;
        this.msg = "OK";
        this.data = data;
    }

    public static Result ok() {
        return new Result(null);
    }

    public static Result ok(Object data) {
        return new Result(data);
    }

    public static Result build(Integer status, String msg) {
        return new Result(status, msg, null);
    }

    public static Result build(Integer status, String msg, Object data) {
        return new Result(status, msg, data);
    }
}
