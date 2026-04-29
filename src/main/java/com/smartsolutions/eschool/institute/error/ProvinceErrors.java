package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum ProvinceErrors implements BaseErrorCode {

    PROVINCE_NOT_FOUND(AppModule.LOOKUP, ErrorCategory.BUSINESS, 7, "Province not found"),
    DUPLICATE_PROVINCE_NAME(AppModule.LOOKUP, ErrorCategory.BUSINESS, 8, "Province name already exists for this country"),
    INVALID_PROVINCE_DATA(AppModule.LOOKUP, ErrorCategory.VALIDATION, 9, "Invalid province data");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    ProvinceErrors(AppModule module, ErrorCategory category, int number, String message) {
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
