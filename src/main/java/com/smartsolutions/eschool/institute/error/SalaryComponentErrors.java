package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum SalaryComponentErrors implements BaseErrorCode {

    SALARY_COMPONENT_NOT_FOUND(AppModule.EMPLOYEE, ErrorCategory.BUSINESS, 4, "Salary component not found"),
    DUPLICATE_SALARY_COMPONENT_NAME(AppModule.EMPLOYEE, ErrorCategory.BUSINESS, 5, "Salary component name already exists"),
    INVALID_SALARY_COMPONENT_DATA(AppModule.EMPLOYEE, ErrorCategory.VALIDATION, 6, "Invalid salary component data");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    SalaryComponentErrors(AppModule module, ErrorCategory category, int number, String message) {
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
