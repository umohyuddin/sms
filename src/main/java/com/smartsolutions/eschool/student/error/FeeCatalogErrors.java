package com.smartsolutions.eschool.student.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum FeeCatalogErrors implements BaseErrorCode {

    FEE_CATALOG_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 101, "Fee catalog not found"),
    DUPLICATE_FEE_CATALOG_CODE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 102, "Fee catalog code already exists"),
    INVALID_FEE_CATALOG_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 103, "Invalid fee catalog data"),
    INSTITUTE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 104, "Institute not found"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 105, "Access denied for this organization"),
    CHARGE_TYPE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 106, "Charge type not found"),
    RECURRENCE_RULE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 107, "Recurrence rule not found");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    FeeCatalogErrors(AppModule module, ErrorCategory category, int number, String message) {
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
