package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum ModuleErrors implements BaseErrorCode {

    MODULE_NOT_FOUND(AppModule.USER, ErrorCategory.BUSINESS, 1, "Module not found"),
    DUPLICATE_MODULE_CODE(AppModule.USER, ErrorCategory.BUSINESS, 2, "Module code already exists"),
    INVALID_MODULE_DATA(AppModule.USER, ErrorCategory.VALIDATION, 3, "Invalid module data");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    ModuleErrors(AppModule module, ErrorCategory category, int number, String message) {
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
