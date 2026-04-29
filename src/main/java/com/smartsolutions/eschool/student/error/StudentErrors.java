package com.smartsolutions.eschool.student.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum StudentErrors implements BaseErrorCode {

    STUDENT_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 1, "Student not found"),
    DUPLICATE_STUDENT_CODE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 2, "Student code already exists"),
    INVALID_STUDENT_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 3, "Invalid student data provided"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 4, "Access denied for this organization");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    StudentErrors(AppModule module, ErrorCategory category, int number, String message) {
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
