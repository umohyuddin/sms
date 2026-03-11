package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum ActionErrors implements BaseErrorCode {

    ACTION_NOT_FOUND(AppModule.USER, ErrorCategory.BUSINESS, 1, "Action not found"),
    DUPLICATE_ACTION_CODE(AppModule.USER, ErrorCategory.BUSINESS, 2, "Action code already exists"),
    INVALID_ACTION_DATA(AppModule.USER, ErrorCategory.VALIDATION, 3, "Invalid action data");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    ActionErrors(AppModule module, ErrorCategory category, int number, String message) {
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
