package com.smartsolutions.eschool.academic.entity.master;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "grade_scales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GradeScaleEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "min_percentage", nullable = false, precision = 5, scale = 2)
    private BigDecimal minPercentage;

    @Column(name = "max_percentage", nullable = false, precision = 5, scale = 2)
    private BigDecimal maxPercentage;

    @Column(name = "grade", nullable = false, length = 5)
    private String grade;

    @Column(name = "remarks", length = 50)
    private String remarks;

    @Column(name = "points", precision = 3, scale = 2)
    private BigDecimal points;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;
}
