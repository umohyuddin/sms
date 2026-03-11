package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum CityErrors implements BaseErrorCode {

    CITY_NOT_FOUND(AppModule.LOOKUP, ErrorCategory.BUSINESS, 10, "City not found"),
    DUPLICATE_CITY_NAME(AppModule.LOOKUP, ErrorCategory.BUSINESS, 11, "City name already exists for this province"),
    INVALID_CITY_DATA(AppModule.LOOKUP, ErrorCategory.VALIDATION, 12, "Invalid city data");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    CityErrors(AppModule module, ErrorCategory category, int number, String message) {
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
