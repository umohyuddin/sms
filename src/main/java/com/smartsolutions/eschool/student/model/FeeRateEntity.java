package com.smartsolutions.eschool.student.model;

import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "fee_rates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeeRateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign key to campus
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus_id", nullable = false)
    private CampusEntity campus;

    // Foreign key to standard
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "standard_id", nullable = false)
    private StandardEntity standard;

    // Foreign key to fee component (nullable)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fee_component_id")
    private FeeComponentEntity feeComponent;

    @Column(name = "code", length = 50, nullable = false)
    private String code;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "charge_type", length = 50)
    private String chargeType;

    @Column(name = "recurrence_rule", length = 100)
    private String recurrenceRule;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    @Column(name = "academic_year", length = 20)
    private String academicYear;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "amount", precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "effective_from")
    private LocalDate effectiveFrom;

    @Column(name = "effective_to")
    private LocalDate effectiveTo;
}
