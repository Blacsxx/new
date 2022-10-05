package com.tedu.store.controller;

import com.tedu.store.controller.ex.*;
import com.tedu.store.service.ex.*;
import com.tedu.store.util.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


public abstract class BaseController {

    public static final Integer SUCCESS = 200;

    @ExceptionHandler({ServiceException.class, RequestException.class})
    @ResponseBody
    public ResponseResult<Void> handleException(Exception e) {
        Integer state = null;
        if (e instanceof DuplicateKeyException) {
            //400-违反了Unique约束的异常
            state = 400;
        } else if (e instanceof PasswordNotMatchException) {
            //401-密码错误异常
            state = 401;
        } else if (e instanceof UserNotFoundException) {
            //402-用户数据不存在异常
            state = 402;
        } else if (e instanceof AccessDeniedException) {
            //403地址访问拒绝异常
            state = 403;
        } else if (e instanceof AddressNotFoundException) {
            //404收货地址不存在
            state = 404;
        } else if (e instanceof GoodsNotFoundException) {
            //405 商品信息不存在异常
            state = 405;
        }else if (e instanceof GoodsCategoryNotFoundException) {
            //406 商品信息不存在异常
            state = 406;
        }else if (e instanceof CartNotFoundException) {
            //407 购物车商品信息不存在异常
            state = 407;
        } else if (e instanceof InsertException) {
            //500-插入书籍异常
            state = 500;
        } else if (e instanceof UpdateException) {
            //501-更新异常
            state = 501;
        } else if (e instanceof DeleteException) {
            //502-删除异常
            state = 502;
        } else if (e instanceof FileEmptyException) {
            //600-上传文件为空的异常
            state = 600;
        } else if (e instanceof FileSizeOutOfLimitException) {
            //601-上传文件超出限制的异常
            state = 601;
        } else if (e instanceof FileTypeNotSupportException) {
            //600-上传文件类型不支持的异常
            state = 602;
        } else if (e instanceof FileUploadException) {
            //600-上传文件异常
            state = 603;
        }
        return new ResponseResult<>(state, e);
    }

    public Integer getIdBySession(HttpSession session) {
        Integer id = Integer.valueOf(session.getAttribute("id").toString());
        return id == null ? 0 : id;
    }
}
