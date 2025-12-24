package com.smartsolutions.eschool.employee.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

public class PayrollPeriodEntity  extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private PayrollStatus status = PayrollStatus.PENDING;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "deleted")
    private Boolean deleted = false;


    // Enum for status
    public enum PayrollStatus {
        PENDING,
        COMPLETED,
        CANCELLED
    }
}
