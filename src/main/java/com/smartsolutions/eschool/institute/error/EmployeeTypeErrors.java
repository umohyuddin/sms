package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum EmployeeTypeErrors implements BaseErrorCode {

    EMPLOYEE_TYPE_NOT_FOUND(AppModule.EMPLOYEE, ErrorCategory.BUSINESS, 1, "Employee Type not found"),
    DUPLICATE_EMPLOYEE_TYPE_NAME(AppModule.EMPLOYEE, ErrorCategory.BUSINESS, 2, "Employee Type name already exists"),
    INVALID_EMPLOYEE_TYPE_DATA(AppModule.EMPLOYEE, ErrorCategory.VALIDATION, 3, "Invalid Employee Type data");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    EmployeeTypeErrors(AppModule module, ErrorCategory category, int number, String message) {
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
