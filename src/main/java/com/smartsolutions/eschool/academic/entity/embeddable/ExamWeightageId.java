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
public class ExamWeightageId implements Serializable {

    @Column(name = "organization_id")
    private Long organizationId;

    @Column(name = "standard_id")
    private Long standardId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "exam_term_id")
    private Long examTermId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamWeightageId that = (ExamWeightageId) o;
        return Objects.equals(organizationId, that.organizationId) &&
               Objects.equals(standardId, that.standardId) &&
               Objects.equals(subjectId, that.subjectId) &&
               Objects.equals(examTermId, that.examTermId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationId, standardId, subjectId, examTermId);
    }
}
