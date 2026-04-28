package com.smartsolutions.eschool.school.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.global.enums.AcademicYearStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "academic_years",
        uniqueConstraints = {@UniqueConstraint(name = "uk_academic_year_code", columnNames = {"code"}), @UniqueConstraint(name = "uk_academic_year_date_range", columnNames = {"start_date", "end_date"})},
        indexes = {@Index(name = "idx_academic_year_status", columnList = "status"), @Index(name = "idx_academic_year_is_current", columnList = "is_current")}
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcademicYearEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name; // e.g., "2024-2025"

    @Column(nullable = false, length = 20)
    private String code;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "is_current", nullable = false)
    private Boolean isCurrent = false;

    @Column(name = "total_Months", nullable = false)
    private long totalMonths;

    /** Lifecycle control */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private AcademicYearStatus status;


    /** Reason for locking or archiving */
    @Column(name = "remarks", length = 255)
    private String remarks;

    /** Prevent accidental modification */
    @Column(name = "is_locked", nullable = false)
    private Boolean isLocked = false;

    @Column(name = "locked_at")
    private LocalDateTime lockedAt;

    @Column(name = "locked_by")
    private Long lockedBy;
}


