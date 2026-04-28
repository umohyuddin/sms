package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum DepartmentTypeErrors implements BaseErrorCode {

    DEPARTMENT_TYPE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 101, "Department type not found"),
    DUPLICATE_DEPARTMENT_TYPE_CODE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 102, "Department type code already exists"),
    INVALID_DEPARTMENT_TYPE_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 103, "Invalid department type data"),
    INSTITUTE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 104, "Institute not found"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 105, "Access denied for this organization");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    DepartmentTypeErrors(AppModule module, ErrorCategory category, int number, String message) {
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
