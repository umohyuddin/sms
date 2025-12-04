package com.smartsolutions.eschool.student.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "fee_catalog")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FeeCatalogEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ---------- FIELDS ----------
    @Column(name = "code", nullable = false, length = 50, unique = true)
    private String code;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "charge_type", nullable = false, length = 50)
    private String chargeType;
    // You can convert to ENUM later: FIXED, PERCENTAGE, PER_CREDIT, etc.

    @Column(name = "recurrence_rule", length = 50)
    private String recurrenceRule;
    // Example: MONTHLY, YEARLY, ONE_TIME etc.

    @Column(name = "active", nullable = false)
    private boolean active = true;


    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    // ---------- RELATIONS ----------

    // One catalog can have multiple components
    @OneToMany(mappedBy = "feeCatalog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FeeComponentEntity> components;

}
