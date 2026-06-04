package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

public enum InstituteSocialLinkErrors implements BaseErrorCode {

    LINK_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 1, "Institute social link not found"),
    INVALID_PLATFORM(AppModule.SCHOOL, ErrorCategory.VALIDATION, 2, "Invalid social media platform"),
    INVALID_URL(AppModule.SCHOOL, ErrorCategory.VALIDATION, 3, "Invalid URL format"),
    DUPLICATE_LINK(AppModule.SCHOOL, ErrorCategory.BUSINESS, 4, "Social link already exists"),
    DATABASE_ERROR(AppModule.SCHOOL, ErrorCategory.DATABASE, 5, "Database error occurred while processing social link"),
    INSTITUTE_NOT_FOUND(AppModule.SCHOOL, ErrorCategory.BUSINESS, 6, "Institute not found"),
    ORGANIZATION_ACCESS_DENIED(AppModule.SCHOOL, ErrorCategory.SECURITY, 7, "Access denied for this organization");

    private final AppModule module;
    private final ErrorCategory category;
    private final int number;
    private final String message;

    InstituteSocialLinkErrors(AppModule module, ErrorCategory category, int number, String message) {
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