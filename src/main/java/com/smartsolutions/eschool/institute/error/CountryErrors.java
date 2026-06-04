package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum CountryErrors implements BaseErrorCode {

    COUNTRY_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 1, "Country not found"),
    DUPLICATE_COUNTRY_CODE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 2, "Country code already exists"),
    INVALID_COUNTRY_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 3, "Invalid country data");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    CountryErrors(AppModule module, ErrorCategory category, int number, String message) {
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
