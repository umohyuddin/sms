package com.smartsolutions.eschool.academic.entity.mapping;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.academic.entity.master.ExamTermEntity;
import com.smartsolutions.eschool.academic.entity.master.SubjectEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "exam_weightage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamWeightageEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "standard_id")
    private StandardEntity standard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_term_id")
    private ExamTermEntity examTerm;

    @Column(name = "weight_percentage", nullable = false, precision = 5, scale = 2)
    private BigDecimal weightPercentage;

    @Builder.Default
    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @Builder.Default
    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;
}
