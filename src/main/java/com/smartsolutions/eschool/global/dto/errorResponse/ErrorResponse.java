package com.smartsolutions.eschool.global.dto.errorResponse;

import java.time.LocalDateTime;

public class ErrorResponse {

    private String code;
    private String message;
    private String path;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ErrorResponse(String code, String message, String path) {
        this.code = code;
        this.message = message;
        this.path = path;
    }

    public String getCode() { return code; }
    public String getMessage() { return message; }
    public String getPath() { return path; }
    public LocalDateTime getTimestamp() { return timestamp; }
}