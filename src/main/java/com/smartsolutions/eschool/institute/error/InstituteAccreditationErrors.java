package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum InstituteAccreditationErrors implements BaseErrorCode {

    ACCREDITATION_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 1, "Institute accreditation not found"),
    DUPLICATE_LICENSE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 2,
            "An accreditation with this license number already exists for the institute"),
    INVALID_AUTHORITY(AppModule.SCHOOL, ErrorCategory.VALIDATION, 3, "Authority name is required"),
    INVALID_LICENSE(AppModule.SCHOOL, ErrorCategory.VALIDATION, 4, "License number is required"),
    INSTITUTE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 5, "Institute not found"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 6, "Access denied for this organization");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    InstituteAccreditationErrors(AppModule module, ErrorCategory category, int number, String message) {
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
