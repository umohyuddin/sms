package com.smartsolutions.eschool.util;

public class EnumValidatorUtil {

    private EnumValidatorUtil() {
    }

    /**
     * Validates and returns an enum constant by comparing name (case-insensitive).
     * Throws IllegalArgumentException if not found.
     */
    public static <E extends Enum<E>> E getEnumByName(Class<E> enumClass, String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Value cannot be null or empty for enum: " + enumClass.getSimpleName());
        }

        for (E constant : enumClass.getEnumConstants()) {
            if (constant.name().equalsIgnoreCase(value)) {
                return constant;
            }
        }

        throw new IllegalArgumentException(
                "Invalid value '" + value + "' for enum " + enumClass.getSimpleName());
    }
}
