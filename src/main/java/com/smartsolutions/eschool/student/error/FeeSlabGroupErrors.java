package com.smartsolutions.eschool.student.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum FeeSlabGroupErrors implements BaseErrorCode {
    FEE_SLAB_GROUP_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 221, "Fee Slab Group not found"),
    INVALID_FEE_SLAB_GROUP_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 222, "Invalid fee slab group data");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    FeeSlabGroupErrors(AppModule module, ErrorCategory category, int number, String message) {
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
