package com.smartsolutions.sms.academic.entity.mapping;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.sms.academic.entity.embeddable.StudentExamMarksId;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "student_exam_marks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentExamMarksEntity extends AuditableEntity {

    @EmbeddedId
    private StudentExamMarksId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("examSubjectId")
    @JoinColumn(name = "exam_subject_id")
    private ExamSubjectEntity examSubject;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @Column(name = "obtained_marks", precision = 6, scale = 2)
    private BigDecimal obtainedMarks;

    @Column(name = "grace_marks", precision = 6, scale = 2)
    private BigDecimal graceMarks = BigDecimal.ZERO;

    @Column(name = "is_locked")
    private boolean locked = false;

    @Column(name = "remarks", length = 255)
    private String remarks;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;
}
