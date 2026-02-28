package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum CampusErrors implements BaseErrorCode {

    CAMPUS_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 1, "Campus not found"),
    DUPLICATE_CAMPUS_CODE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 2, "Campus code already exists"),
    INVALID_CAMPUS_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 3, "Invalid campus data"),
    INSTITUTE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 4, "Institute not found"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 5, "Access denied for this organization");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    CampusErrors(AppModule module, ErrorCategory category, int number, String message) {
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
