package com.tedu.store.service.ex;

/**
 * 商品数据不存在异常
 */
public class GoodsCategoryNotFoundException extends ServiceException{
    public GoodsCategoryNotFoundException() {
        super();
    }

    public GoodsCategoryNotFoundException(String message) {
        super(message);
    }

    public GoodsCategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodsCategoryNotFoundException(Throwable cause) {
        super(cause);
    }

    protected GoodsCategoryNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
