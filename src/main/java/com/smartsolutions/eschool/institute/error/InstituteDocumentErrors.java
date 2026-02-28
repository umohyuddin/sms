package com.smartsolutions.eschool.institute.error;

import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;

/**
 * Error codes for InstituteDocument component.
 */
public enum InstituteDocumentErrors implements BaseErrorCode {

    INSTITUTE_DOCUMENT_NOT_FOUND(ErrorCategory.BUSINESS, 1, "Institute document not found"),
    INSTITUTE_NOT_FOUND(ErrorCategory.BUSINESS, 2, "Institute not found"),
    INVALID_DOCUMENT_DATA(ErrorCategory.VALIDATION, 3, "Invalid document data");

    private final ErrorCategory category;
    private final int number;
    private final String message;

    InstituteDocumentErrors(ErrorCategory category, int number, String message) {
        this.category = category;
        this.number = number;
        this.message = message;
    }

    @Override
    public AppModule module() {
        return AppModule.SCHOOL;
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
