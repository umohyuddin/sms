package com.smartsolutions.sms.academic.entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherSubjectAssignmentId implements Serializable {

    @Column(name = "organization_id")
    private Long organizationId;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "standard_id")
    private Long standardId;

    @Column(name = "section_id")
    private Long sectionId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "academic_year_id")
    private Long academicYearId;

    @Column(name = "effective_from")
    private LocalDate effectiveFrom;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherSubjectAssignmentId that = (TeacherSubjectAssignmentId) o;
        return Objects.equals(organizationId, that.organizationId) &&
               Objects.equals(employeeId, that.employeeId) &&
               Objects.equals(standardId, that.standardId) &&
               Objects.equals(sectionId, that.sectionId) &&
               Objects.equals(subjectId, that.subjectId) &&
               Objects.equals(academicYearId, that.academicYearId) &&
               Objects.equals(effectiveFrom, that.effectiveFrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationId, employeeId, standardId, sectionId, subjectId, academicYearId, effectiveFrom);
    }
}
