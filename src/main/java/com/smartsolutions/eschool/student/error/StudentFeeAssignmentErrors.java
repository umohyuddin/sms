package com.smartsolutions.eschool.student.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum StudentFeeAssignmentErrors implements BaseErrorCode {

    ASSIGNMENT_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 1, "Student fee assignment not found"),
    FEE_SUMMARY_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 2, "Student fee summary not found"),
    NO_FEE_RATES_AVAILABLE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 3, "No fee rates available for the given criteria"),
    ACADEMIC_YEAR_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 4, "Academic year not found"),
    CURRENT_ACADEMIC_YEAR_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 5, "Current academic year not found"),
    INVALID_ASSIGNMENT_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 6, "Invalid fee assignment data"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 7, "Access denied for this organization");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    StudentFeeAssignmentErrors(AppModule module, ErrorCategory category, int number, String message) {
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
