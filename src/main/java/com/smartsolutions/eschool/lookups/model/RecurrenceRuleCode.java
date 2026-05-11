package com.smartsolutions.eschool.lookups.model;

/**
 * Global system fee recurrence rules.
 * These correspond to the backend scheduler/billing cycle logic.
 */
public enum RecurrenceRuleCode {
    ONE_TIME,    // Once at admission/registration
    MONTHLY,     // Every month
    QUARTERLY,   // Every three months
    HALF_YEARLY, // Twice per year
    ANNUAL,      // Once per year
    PER_TERM,    // Per academic term/semester
    ON_DEMAND    // Charged when service is used
}
