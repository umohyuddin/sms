package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum LanguageErrors implements BaseErrorCode {

    LANGUAGE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 1, "Language not found"),
    DUPLICATE_LANGUAGE_CODE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 2, "Language ISO code already exists"),
    INVALID_LANGUAGE_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 3, "Invalid language data");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    LanguageErrors(AppModule module, ErrorCategory category, int number, String message) {
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
