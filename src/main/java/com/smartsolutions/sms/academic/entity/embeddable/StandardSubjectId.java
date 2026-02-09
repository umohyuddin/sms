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
public class StandardSubjectId implements Serializable {

    @Column(name = "organization_id")
    private Long organizationId;

    @Column(name = "standard_id")
    private Long standardId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "academic_year_id")
    private Long academicYearId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StandardSubjectId that = (StandardSubjectId) o;
        return Objects.equals(organizationId, that.organizationId) &&
               Objects.equals(standardId, that.standardId) &&
               Objects.equals(subjectId, that.subjectId) &&
               Objects.equals(academicYearId, that.academicYearId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationId, standardId, subjectId, academicYearId);
    }
}
