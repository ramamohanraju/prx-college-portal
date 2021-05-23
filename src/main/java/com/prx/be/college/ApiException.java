package com.prx.be.college;

public class ApiException extends RuntimeException {
    public ApiException(String msg) {
        super(msg);
    }

    public ApiException(RuntimeException exception) {
        super(exception);
    }

    public ApiException(String msg, RuntimeException exception) {
        super(msg, exception);
    }
}
