package com.tedu.store.util;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
    private Integer status;
    private String message;
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(Integer status) {
        setStatus(status);
    }
    public ResponseResult(Integer status,Exception e) {
        this(status,e.getMessage());
    }

    public ResponseResult(Integer status, String message) {
        this(status);
        setMessage(message);
    }

    public ResponseResult(Integer status, T data) {
        this(status);
        setData(data);
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
