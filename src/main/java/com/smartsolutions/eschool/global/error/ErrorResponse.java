package com.smartsolutions.eschool.global.error;

import java.time.LocalDateTime;

public class ErrorResponse {

    private final String code;
    private final String message;
    private final String path;
    private final LocalDateTime timestamp;

    public ErrorResponse(BaseErrorCode error, String path) {
        this.code = error.code();
        this.message = error.message();
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(BaseErrorCode error, String message, String path) {
        this.code = error.code();
        this.message = message;
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}