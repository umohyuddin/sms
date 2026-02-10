package com.smartsolutions.eschool.academic.entity.mapping;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.academic.entity.embeddable.StudentTermResultId;
import com.smartsolutions.eschool.academic.entity.master.ExamTermEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_term_result")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentTermResultEntity extends AuditableEntity {

    @EmbeddedId
    private StudentTermResultId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("academicYearId")
    @JoinColumn(name = "academic_year_id")
    private AcademicYearEntity academicYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("examTermId")
    @JoinColumn(name = "exam_term_id")
    private ExamTermEntity examTerm;

    @Column(name = "total_marks", precision = 8, scale = 2)
    private BigDecimal totalMarks;

    @Column(name = "obtained_marks", precision = 8, scale = 2)
    private BigDecimal obtainedMarks;

    @Column(name = "percentage", precision = 5, scale = 2)
    private BigDecimal percentage;

    @Column(name = "grade", length = 10)
    private String grade;

    @Column(name = "gpa", precision = 3, scale = 2)
    private BigDecimal gpa;

    @Column(name = "generated_at")
    private LocalDateTime generatedAt;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;
}
