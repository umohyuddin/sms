package com.smartsolutions.eschool.sclass.model;

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
    @Column(name = "id")
    private Long id;

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


    public enum AssessmentStatus {
        P, A
    }
}
