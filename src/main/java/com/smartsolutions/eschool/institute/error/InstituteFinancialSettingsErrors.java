package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;
import lombok.Getter;

@Getter
public enum InstituteFinancialSettingsErrors implements BaseErrorCode {

    INSTITUTE_FINANCIAL_SETTINGS_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 1,
            "Institute financial settings not found"),
    INSTITUTE_FINANCIAL_SETTINGS_ALREADY_EXISTS(AppModule.SCHOOL, ErrorCategory.BUSINESS, 2,
            "Financial settings already exist for this institute and academic year"),
    INSTITUTE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 3, "Institute not found"),
    ACADEMIC_YEAR_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 4, "Academic year not found"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 5,
            "You do not have access to this organization's financial settings"),
    DATABASE_ERROR(AppModule.SCHOOL, ErrorCategory.DATABASE, 6,
            "A database error occurred while processing financial settings"),
    REFUND_TYPE_REQUIRED(AppModule.SCHOOL, ErrorCategory.VALIDATION, 7,
            "Refund type is required when refunds are allowed"),
    INVALID_REFUND_VALUE(AppModule.SCHOOL, ErrorCategory.VALIDATION, 8, "Invalid refund percentage or amount provided");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    InstituteFinancialSettingsErrors(AppModule module, ErrorCategory category, int number, String message) {
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
