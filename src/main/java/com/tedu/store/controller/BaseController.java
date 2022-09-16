package com.tedu.store.controller;

import com.tedu.store.service.ex.DuplicateKeyException;
import com.tedu.store.service.ex.InsertException;
import com.tedu.store.service.ex.ServiceException;
import com.tedu.store.util.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


public abstract class BaseController {

    public static final Integer SUCCESS = 200;

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseResult<Void> handleException(Exception e) {
        if (e instanceof DuplicateKeyException) {
            return new ResponseResult<>(400, e);
        } else if (e instanceof InsertException) {
            return new ResponseResult<>(500, e);
        }
        return null;
    }
}
