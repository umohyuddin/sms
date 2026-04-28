package com.smartsolutions.eschool.school.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum ChargeTypeErrors implements BaseErrorCode {

    CHARGE_TYPE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 201, "Charge Type not found"),
    DUPLICATE_CHARGE_TYPE_CODE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 202, "Charge Type code already exists"),
    DUPLICATE_CHARGE_TYPE_NAME(AppModule.SCHOOL, ErrorCategory.BUSINESS, 203, "Charge Type name already exists"),
    INVALID_CHARGE_TYPE_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 204, "Invalid charge type data");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    ChargeTypeErrors(AppModule module, ErrorCategory category, int number, String message) {
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
