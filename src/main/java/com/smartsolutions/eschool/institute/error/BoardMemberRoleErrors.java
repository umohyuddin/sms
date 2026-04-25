package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum BoardMemberRoleErrors implements BaseErrorCode {

    ROLE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 1, "Board member role not found"),
    DUPLICATE_ROLE_CODE(AppModule.SCHOOL, ErrorCategory.BUSINESS, 2, "Board member role code already exists"),
    INVALID_ROLE_DATA(AppModule.SCHOOL, ErrorCategory.VALIDATION, 3, "Invalid board member role data"),
    INSTITUTE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 4, "Institute not found"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 5, "Access denied for this organization");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    BoardMemberRoleErrors(AppModule module, ErrorCategory category, int number, String message) {
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
