package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum TaxTypeErrors implements BaseErrorCode {

    TAX_TYPE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 1, "Tax type not found"),
    DUPLICATE_TAX_TYPE_CODE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 2, "Tax type code already exists"),
    INVALID_TAX_TYPE_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 3, "Invalid tax type data"),
    COUNTRY_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 4, "Country not found");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    TaxTypeErrors(AppModule module, ErrorCategory category, int number, String message) {
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
