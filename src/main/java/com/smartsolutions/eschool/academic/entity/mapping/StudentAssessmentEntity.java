package com.smartsolutions.eschool.academic.entity.mapping;

import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.academic.entity.embeddable.StudentAssessmentId;
import com.smartsolutions.eschool.academic.entity.master.AssessmentEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_assessments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentAssessmentEntity extends AuditableEntity {

    @EmbeddedId
    private StudentAssessmentId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("assessmentId")
    @JoinColumn(name = "assessment_id")
    private AssessmentEntity assessment;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @Column(name = "obtained_marks", precision = 6, scale = 2)
    private BigDecimal obtainedMarks;

    @Column(name = "grade", length = 5)
    private String grade;

    @Column(name = "remarks", length = 255)
    private String remarks;

    @Enumerated(EnumType.STRING)
    @Column(name = "submission_status")
    private SubmissionStatus submissionStatus = SubmissionStatus.NOT_SUBMITTED;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluated_by")
    private EmployeeMasterEntity evaluatedBy;

    @Column(name = "evaluated_at")
    private LocalDateTime evaluatedAt;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;

    public enum SubmissionStatus {
        SUBMITTED, NOT_SUBMITTED
    }
}
