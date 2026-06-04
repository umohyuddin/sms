package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum InstituteFacilityErrors implements BaseErrorCode {

    FACILITY_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 1, "Institute facility not found"),
    FACILITY_TYPE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 2, "Facility type not found"),
    INSTITUTE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 3, "Institute not found"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 4, "Access denied for this organization"),
    INVALID_SELECTION(AppModule.SCHOOL, ErrorCategory.VALIDATION, 5, "At least one facility selection is required");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    InstituteFacilityErrors(AppModule module, ErrorCategory category, int number, String message) {
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
