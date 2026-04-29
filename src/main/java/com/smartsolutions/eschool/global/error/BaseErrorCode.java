package com.smartsolutions.eschool.global.error;

public interface BaseErrorCode {

    AppModule module();
    ErrorCategory category();
    int number();
    String message();

    default String code() {
        return module().code()
                + "-"
                + category().code()
                + "-"
                + String.format("%03d", number());
    }
}