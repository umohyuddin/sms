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
public class StudentTermResultId implements Serializable {

    @Column(name = "organization_id")
    private Long organizationId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "academic_year_id")
    private Long academicYearId;

    @Column(name = "exam_term_id")
    private Long examTermId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentTermResultId that = (StudentTermResultId) o;
        return Objects.equals(organizationId, that.organizationId) &&
               Objects.equals(studentId, that.studentId) &&
               Objects.equals(academicYearId, that.academicYearId) &&
               Objects.equals(examTermId, that.examTermId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationId, studentId, academicYearId, examTermId);
    }
}
