package com.smartsolutions.eschool.global.enums;

public enum Cities {
    LAHORE(1L, Province.PUNJAB),
    MULTAN(2L, Province.PUNJAB),
    KARACHI(3L, Province.SINDH),
    HYDERABAD(4L, Province.SINDH),
    QUETTA(5L, Province.BALOCHISTAN),
    PESHAWAR(6L, Province.KPK),
    ISLAMABAD_CITY(7L, Province.ISLAMABAD);

    private final Long id;
    private final Province province;

    Cities(Long id, Province province) {
        this.id = id;
        this.province = province;
    }

    public Long getId() {
        return id;
    }

    public Province getProvince() {
        return province;
    }
}
