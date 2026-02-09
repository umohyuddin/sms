package com.smartsolutions.sms.academic.entity.master;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.sms.academic.entity.mapping.TeacherSubjectAssignmentEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "assessments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssessmentEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_subject_assignment_id", nullable = false)
    private TeacherSubjectAssignmentEntity teacherSubjectAssignment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assessment_type_id", nullable = false)
    private AssessmentTypeEntity assessmentType;

    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "total_marks", nullable = false, precision = 6, scale = 2)
    private BigDecimal totalMarks;

    @Column(name = "passing_marks", precision = 6, scale = 2)
    private BigDecimal passingMarks;

    @Column(name = "assessment_date")
    private LocalDate assessmentDate;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "is_published", nullable = false)
    private boolean published = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_year_id", nullable = false)
    private AcademicYearEntity academicYear;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;
}
