package com.smartsolutions.eschool.employee.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum EmployeeErrors implements BaseErrorCode {

    EMPLOYEE_NOT_FOUND(AppModule.EMPLOYEE, ErrorCategory.BUSINESS, 1, "Employee not found"),
    DUPLICATE_EMPLOYEE_CODE(AppModule.EMPLOYEE, ErrorCategory.BUSINESS, 2, "Employee code already exists"),
    INVALID_EMPLOYEE_DATA(AppModule.EMPLOYEE, ErrorCategory.VALIDATION, 3, "Invalid employee data"),
    ORGANIZATION_ACCESS_DENIED(AppModule.EMPLOYEE, ErrorCategory.SECURITY, 4, "Access denied for this organization");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    EmployeeErrors(AppModule module, ErrorCategory category, int number, String message) {
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
