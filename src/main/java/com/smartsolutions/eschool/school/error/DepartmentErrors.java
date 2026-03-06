package com.smartsolutions.eschool.school.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum DepartmentErrors implements BaseErrorCode {

    DEPARTMENT_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 1, "Department not found"),
    DUPLICATE_DEPARTMENT_CODE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 2, "Department code already exists"),
    DUPLICATE_DEPARTMENT_NAME(AppModule.SCHOOL, ErrorCategory.BUSINESS, 3, "Department name already exists"),
    INVALID_DEPARTMENT_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 4, "Invalid department data"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 5, "Access denied for this organization");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    DepartmentErrors(AppModule module, ErrorCategory category, int number, String message) {
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
