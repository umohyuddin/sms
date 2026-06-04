package com.smartsolutions.eschool.global.error;

public enum CommonErrors implements BaseErrorCode {

    RESOURCE_NOT_FOUND(AppModule.COMMON, ErrorCategory.BUSINESS, 404, "Requested resource not found"),
    INTERNAL_SERVER_ERROR(AppModule.COMMON, ErrorCategory.INTERNAL, 500, "An unexpected server error occurred"),
    DATABASE_ERROR(AppModule.COMMON, ErrorCategory.DATABASE, 501, "A database error occurred"),
    ACCESS_DENIED(AppModule.COMMON, ErrorCategory.SECURITY, 403, "Access denied");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    CommonErrors(AppModule module, ErrorCategory category, int number, String message) {
        this.module = module;
        this.category = category;
        this.number = number;
        this.message = message;
    }

    @Override
    public AppModule module() {
        return module;
    }

    @Override
    public ErrorCategory category() {
        return category;
    }

    @Override
    public int number() {
        return number;
    }

    @Override
    public String message() {
        return message;
    }
}
