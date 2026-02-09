package com.smartsolutions.sms.academic.entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentExamMarksId implements Serializable {

    @Column(name = "organization_id")
    private Long organizationId;

    @Column(name = "exam_subject_id")
    private Long examSubjectId;

    @Column(name = "student_id")
    private Long studentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentExamMarksId that = (StudentExamMarksId) o;
        return Objects.equals(organizationId, that.organizationId) &&
               Objects.equals(examSubjectId, that.examSubjectId) &&
               Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationId, examSubjectId, studentId);
    }
}
