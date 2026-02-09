package com.smartsolutions.sms.academic.entity.master;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "student_activity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentActivityEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

    @Column(name = "activity_type", length = 100)
    private String activityType;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "activity_date")
    private LocalDate activityDate;

    @Column(name = "grade", length = 10)
    private String grade;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;
}
