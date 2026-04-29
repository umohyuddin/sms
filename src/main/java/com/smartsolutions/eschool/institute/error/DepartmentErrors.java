package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum DepartmentErrors implements BaseErrorCode {

    DEPARTMENT_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 201, "Department not found"),
    DUPLICATE_DEPARTMENT_CODE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 202, "Department code already exists in this campus"),
    DUPLICATE_DEPARTMENT_NAME(AppModule.SCHOOL, ErrorCategory.BUSINESS, 203, "Department name already exists in this campus"),
    INVALID_DEPARTMENT_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 204, "Invalid department data"),
    CAMPUS_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 205, "Campus not found"),
    DEPARTMENT_TYPE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 206, "Department type not found"),
    PARENT_DEPARTMENT_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 207, "Parent department not found"),
    HEAD_EMPLOYEE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 208, "Head employee not found"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 209, "Access denied for this organization");

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
