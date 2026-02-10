package com.smartsolutions.eschool.academic.entity.mapping;

import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.academic.entity.master.ExamEntity;
import com.smartsolutions.eschool.academic.entity.master.ExamEntity;
import com.smartsolutions.eschool.academic.entity.master.SubjectEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "exam_subjects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamSubjectEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id")
    private ExamEntity exam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    @Column(name = "total_marks", nullable = false, precision = 6, scale = 2)
    private BigDecimal totalMarks;

    @Column(name = "passing_marks", nullable = false, precision = 6, scale = 2)
    private BigDecimal passingMarks;

    @Column(name = "exam_date", nullable = false)
    private LocalDate examDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluator_id")
    private EmployeeMasterEntity evaluator;

    @Builder.Default
    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @Builder.Default
    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;
}
