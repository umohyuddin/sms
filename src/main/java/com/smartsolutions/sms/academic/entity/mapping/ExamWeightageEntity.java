package com.smartsolutions.sms.academic.entity.mapping;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.sms.academic.entity.embeddable.ExamWeightageId;
import com.smartsolutions.sms.academic.entity.master.ExamTermEntity;
import com.smartsolutions.sms.academic.entity.master.SubjectEntity;
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

    @EmbeddedId
    private ExamWeightageId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("standardId")
    @JoinColumn(name = "standard_id")
    private StandardEntity standard;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("subjectId")
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("examTermId")
    @JoinColumn(name = "exam_term_id")
    private ExamTermEntity examTerm;

    @Column(name = "weight_percentage", nullable = false, precision = 5, scale = 2)
    private BigDecimal weightPercentage;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;
}
