package com.smartsolutions.eschool.global.error;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

    private final BaseErrorCode error;
    private final HttpStatus status;

    public ApiException(BaseErrorCode error) {
        super(error.message());
        this.error = error;
        this.status = HttpStatus.BAD_REQUEST;
    }

    public ApiException(BaseErrorCode error, HttpStatus status) {
        super(error.message());
        this.error = error;
        this.status = status;
    }

    public ApiException(BaseErrorCode error, String message, HttpStatus status) {
        super(message);
        this.error = error;
        this.status = status;
    }

    public BaseErrorCode getError() {
        return error;
    }

    public HttpStatus getStatus() {
        return status;
    }
}