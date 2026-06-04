package com.smartsolutions.eschool.student.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum GuardianErrors implements BaseErrorCode {

    GUARDIAN_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 1, "Guardian not found"),
    DUPLICATE_GUARDIAN_CNIC(AppModule.SCHOOL, ErrorCategory.BUSINESS, 2, "Guardian CNIC already exists"),
    INVALID_GUARDIAN_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 3, "Invalid guardian data"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 4, "Access denied for this organization");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    GuardianErrors(AppModule module, ErrorCategory category, int number, String message) {
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
