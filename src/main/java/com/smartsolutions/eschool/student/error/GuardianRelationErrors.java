package com.smartsolutions.eschool.student.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum GuardianRelationErrors implements BaseErrorCode {

    GUARDIAN_RELATION_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 1, "Guardian relation not found"),
    DUPLICATE_GUARDIAN_RELATION_CODE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 2, "Guardian relation code already exists"),
    DUPLICATE_GUARDIAN_RELATION_NAME(AppModule.SCHOOL, ErrorCategory.BUSINESS, 3, "Guardian relation name already exists"),
    INVALID_GUARDIAN_RELATION_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 4, "Invalid guardian relation data"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 5, "Access denied for this organization");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    GuardianRelationErrors(AppModule module, ErrorCategory category, int number, String message) {
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
