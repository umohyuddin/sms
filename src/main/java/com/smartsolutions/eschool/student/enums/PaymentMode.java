package com.smartsolutions.eschool.student.enums;

import lombok.Getter;

@Getter
public enum PaymentMode {
    CASH("Cash"),
    BANK_TRANSFER("Bank Transfer"),
    CHEQUE("Cheque"),
    ONLINE("Online");

    private final String description;

    PaymentMode(String description) {
        this.description = description;
    }
}
