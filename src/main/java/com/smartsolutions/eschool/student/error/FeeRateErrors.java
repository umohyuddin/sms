package com.smartsolutions.eschool.student.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum FeeRateErrors implements BaseErrorCode {
    FEE_RATE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 401, "Fee rate not found"),
    OVERLAPPING_FEE_RATE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 402, "Overlapping FeeRate exists for this Campus, Standard, and Academic Year"),
    INVALID_FEE_RATE_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 403, "Invalid fee rate data"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 404, "Access denied for this organization"),
    CAMPUS_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 405, "Campus not found"),
    STANDARD_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 406, "Standard not found"),
    ACADEMIC_YEAR_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 407, "Academic year not found"),
    CHARGE_TYPE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 408, "Charge type not found"),
    FEE_COMPONENT_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 409, "Fee component not found"),
    SLAB_GROUP_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 410, "Slab group not found");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    FeeRateErrors(AppModule module, ErrorCategory category, int number, String message) {
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
