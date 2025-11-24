package com.smartsolutions.eschool.global.enums;

public enum Province {
    PUNJAB(1L),
    SINDH(2L),
    BALOCHISTAN(3L),
    KPK(4L),
    ISLAMABAD(5L);

    private final Long id;

    Province(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
