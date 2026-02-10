package com.smartsolutions.eschool.student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_attendance", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "student_id", "attendance_date" })
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentAttendanceEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "standard_id")
    private Long standardId;

    @Column(name = "section_id")
    private Long sectionId;

    @Column(name = "attendance_date", nullable = false)
    private LocalDate attendanceDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AttendanceStatus status;

    @Column(name = "marked_by")
    private Long markedBy; // teacher/admin who marked attendance

    @Column(name = "remarks")
    private String remarks;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private StudentEntity student;

    public enum AttendanceStatus {
        PRESENT, ABSENT, LEAVE
    }
}
