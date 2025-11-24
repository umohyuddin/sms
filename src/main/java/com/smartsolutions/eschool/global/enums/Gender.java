package com.smartsolutions.eschool.global.enums;

public enum Gender {
    MALE(1L),
    FEMALE(2L),
    OTHER(3L);

    private final Long id;

    Gender(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

