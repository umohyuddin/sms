package com.smartsolutions.eschool.academic.entity.mapping;
import org.hibernate.annotations.SQLRestriction;

import org.hibernate.annotations.SQLDelete;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.academic.entity.mapping.ExamSubjectEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@SQLDelete(sql = "UPDATE student_exam_marks SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "student_exam_marks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentExamMarksEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_subject_id")
    private ExamSubjectEntity examSubject;

    @ManyToOne(fetch = FetchType.LAZY)
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

    @Builder.Default
    @Column(name = "is_active", nullable = false)
    private boolean active = true;
}
