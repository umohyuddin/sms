package com.smartsolutions.eschool.lookups.model;

/**
 * Global system charge types.
 * These correspond to the hardcoded backend logic for fee calculations.
 */
public enum ChargeTypeCode {
    FIXED,       // Standard set amount (e.g. tuition)
    PERCENTAGE   // Calculated as % of another fee or total
}
