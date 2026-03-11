package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum FeeRecurrenceRuleErrors implements BaseErrorCode {

    FEE_RECURRENCE_RULE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 1, "Fee recurrence rule not found"),
    DUPLICATE_FEE_RECURRENCE_RULE_CODE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 2,
            "Fee recurrence rule code already exists"),
    INVALID_FEE_RECURRENCE_RULE_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 3,
            "Invalid fee recurrence rule data"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 4,
            "Access denied for this organization");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    FeeRecurrenceRuleErrors(AppModule module, ErrorCategory category, int number, String message) {
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
