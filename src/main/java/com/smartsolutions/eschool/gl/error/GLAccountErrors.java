package com.smartsolutions.eschool.gl.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum GLAccountErrors implements BaseErrorCode {

    ACCOUNT_NOT_FOUND(AppModule.FINANCE, ErrorCategory.BUSINESS, 1, "GL Account not found"),
    DUPLICATE_ACCOUNT_CODE(AppModule.FINANCE, ErrorCategory.BUSINESS, 2, "Account code already exists"),
    INVALID_ACCOUNT_DATA(AppModule.FINANCE, ErrorCategory.VALIDATION, 3, "Invalid account data"),
    PARENT_ACCOUNT_NOT_FOUND(AppModule.FINANCE, ErrorCategory.BUSINESS, 4, "Parent account not found"),
    ORGANIZATION_ACCESS_DENIED(AppModule.FINANCE, ErrorCategory.SECURITY, 5, "Access denied for this organization");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    GLAccountErrors(AppModule module, ErrorCategory category, int number, String message) {
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
