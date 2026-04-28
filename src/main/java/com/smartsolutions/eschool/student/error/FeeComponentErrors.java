package com.smartsolutions.eschool.student.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum FeeComponentErrors  implements BaseErrorCode {
    FEE_COMPONENT_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 201, "Fee component not found"),
    DUPLICATE_FEE_COMPONENT_CODE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 202, "Fee component code already exists"),
    INVALID_FEE_COMPONENT_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 203, "Invalid fee component data"),
    FEE_CATALOG_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 204, "Associated fee catalog not found"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 205, "Access denied for this organization");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    FeeComponentErrors(AppModule module, ErrorCategory category, int number, String message) {
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
