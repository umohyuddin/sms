package com.smartsolutions.eschool.global.error;

public enum ErrorCategory {

    VALIDATION("VAL"),
    BUSINESS("BUS"),
    SECURITY("SEC"),
    DATABASE("DB"),
    INTERNAL("INT");

    private final String code;

    ErrorCategory(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}