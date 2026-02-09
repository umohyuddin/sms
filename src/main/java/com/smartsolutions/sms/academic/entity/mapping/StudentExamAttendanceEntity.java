package com.smartsolutions.sms.academic.entity.mapping;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.sms.academic.entity.embeddable.StudentExamAttendanceId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_exam_attendance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentExamAttendanceEntity extends AuditableEntity {

    @EmbeddedId
    private StudentExamAttendanceId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("examSubjectId")
    @JoinColumn(name = "exam_subject_id")
    private ExamSubjectEntity examSubject;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AttendanceStatus status;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;

    public enum AttendanceStatus {
        PRESENT, ABSENT, UFM
    }
}
