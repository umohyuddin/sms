package com.smartsolutions.eschool.academic.entity.embeddable;

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
public class ExamSubjectId implements Serializable {

    @Column(name = "organization_id")
    private Long organizationId;

    @Column(name = "exam_id")
    private Long examId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamSubjectId that = (ExamSubjectId) o;
        return Objects.equals(organizationId, that.organizationId) &&
               Objects.equals(examId, that.examId) &&
               Objects.equals(subjectId, that.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationId, examId, subjectId);
    }
}
