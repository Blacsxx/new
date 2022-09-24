package com.tedu.store.controller.ex;

public class FileSizeOutOfLimitException extends FileUploadException{
    public FileSizeOutOfLimitException() {
    }

    public FileSizeOutOfLimitException(String message) {
        super(message);
    }

    public FileSizeOutOfLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSizeOutOfLimitException(Throwable cause) {
        super(cause);
    }

    public FileSizeOutOfLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
