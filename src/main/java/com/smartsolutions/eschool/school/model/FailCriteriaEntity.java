package com.smartsolutions.eschool.school.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "failcriteria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FailCriteriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "inst_id")
    private Integer instituteId;

    @Column(name = "percentage")
    private Integer percentage;

    @Column(name = "subjectmarks")
    private Integer subjectMarks;

    @Column(name = "noofsubjects")
    private Integer noOfSubjects;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    @PrePersist
    public  void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

}
