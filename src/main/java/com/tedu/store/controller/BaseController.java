package com.tedu.store.controller;

import com.tedu.store.service.ex.*;
import com.tedu.store.util.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


public abstract class BaseController {

    public static final Integer SUCCESS = 200;

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseResult<Void> handleException(Exception e) {
        if (e instanceof DuplicateKeyException) {
            //400-违反了Unique约束的异常
            return new ResponseResult<>(400, e);
        } else if (e instanceof InsertException) {
            //500-插入书籍异常
            return new ResponseResult<>(500, e);
        } else if (e instanceof PasswordNotMatchException) {
            //401-密码错误异常
            return new ResponseResult<>(401, e);
        } else if (e instanceof UserNotFoundException) {
            //402-用户数据不存在异常
            return new ResponseResult<>(402, e);
        } else if (e instanceof UpdateException) {
            //501-更新异常
            return new ResponseResult<>(501, e);
        }
        return null;
    }
}
