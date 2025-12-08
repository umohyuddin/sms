package com.smartsolutions.eschool.student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.domain.Auditable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "fee_rates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeeRateEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "code", length = 50, nullable = false, unique = true)
//    private String code;
//
//    @Column(name = "name", length = 100, nullable = false)
//    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "currency", length = 3) // optional
    private String currency;

    @Column(name = "effective_from", nullable = false)
    private LocalDate effectiveFrom;

    @Column(name = "effective_to")
    private LocalDate effectiveTo;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;


    @OneToMany(mappedBy = "feeRate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<StudentFeeAssignmentEntity> feeAssignments;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_year_id", nullable = false)
    private AcademicYearEntity academicYear;

}
