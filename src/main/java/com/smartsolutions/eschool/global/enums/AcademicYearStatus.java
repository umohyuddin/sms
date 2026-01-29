package com.smartsolutions.eschool.global.enums;

public enum AcademicYearStatus {
    DRAFT,      // Newly created, not yet active
    ACTIVE,     // Currently running academic year
    LOCKED,     // Locked for editing (cannot modify)
    ARCHIVED,    // Completed/past academic year
    DELETED, CLOSED//
}

/*
DRAFT – for newly created academic years that are not yet started or finalized.
ACTIVE – the academic year currently in session.
LOCKED – the academic year is locked for changes (e.g., fees, attendance finalized).
ARCHIVED – past academic years, completed and stored for history.
*/