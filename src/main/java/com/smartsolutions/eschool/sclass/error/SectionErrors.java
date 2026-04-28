package com.smartsolutions.eschool.sclass.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum SectionErrors implements BaseErrorCode {

    SECTION_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 1, "Section not found"),
    DUPLICATE_SECTION_CODE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 2,
            "Section code already exists for this Standard"),
    INVALID_SECTION_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 3, "Invalid section data"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 4, "Access denied for this organization");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    SectionErrors(AppModule module, ErrorCategory category, int number, String message) {
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
