package com.smartsolutions.eschool.lookups.model;

/**
 * Global system charge types.
 * These correspond to the hardcoded backend logic for fee calculations.
 */
public enum ChargeTypeCode {
    FIXED,       // Standard set amount (e.g. tuition)
    PERCENTAGE,  // Calculated as % of another fee or total
    SLAB,        // Amount depends on distance/zone (slabs)
    PER_UNIT,    // Fee per unit/item (e.g. books)
    CONDITIONAL  // Applies only if a condition is met
}
