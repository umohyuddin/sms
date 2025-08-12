package com.smartsolutions.eschool.course.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "assessments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessments_id")
    private Long assessmentId;

    @Column(name = "enr_id", nullable = false)
    private Long enrollmentId;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "assessments_date", nullable = false)
    private LocalDate assessmentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AssessmentStatus status;

    @Column(name = "marks", nullable = false)
    private Integer marks;

    @Column(name = "grade", length = 2)
    private String grade;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enr_id", referencedColumnName = "enrollment_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private EnrollmentEntity enrollment;

    public enum AssessmentStatus {
        P, A
    }
}
