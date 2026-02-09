package com.smartsolutions.sms.academic.entity.mapping;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.sms.academic.entity.embeddable.StandardSubjectId;
import com.smartsolutions.sms.academic.entity.master.SubjectEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "standard_subjects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StandardSubjectEntity extends AuditableEntity {

    @EmbeddedId
    private StandardSubjectId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("standardId")
    @JoinColumn(name = "standard_id")
    private StandardEntity standard;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("subjectId")
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("academicYearId")
    @JoinColumn(name = "academic_year_id")
    private AcademicYearEntity academicYear;

    @Column(name = "is_optional", nullable = false)
    private boolean optional = false;

    @Column(name = "weekly_hours")
    private Integer weeklyHours;

    @Column(name = "theory_marks")
    private Integer theoryMarks;

    @Column(name = "practical_marks")
    private Integer practicalMarks;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;
}
