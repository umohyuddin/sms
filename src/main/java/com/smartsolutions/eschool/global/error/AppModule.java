package com.smartsolutions.eschool.global.error;

public enum AppModule {

    AUTH("AUTH"),
    USER("USR"),
    ORDER("ORD"),
    PAYMENT("PAY"),
    PRODUCT("PRD"),
    SCHOOL("SCH"),
    LOOKUP("LKP"),
    EMPLOYEE("EMP"),
    COMMON("COM");

    private final String code;

    AppModule(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}
