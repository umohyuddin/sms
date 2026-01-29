package com.smartsolutions.eschool.sclass.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.school.model.AcademicSubjectEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "standard_subjects",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"standard_id", "subject_id"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StandardSubjectEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "standard_id", nullable = false)
    private StandardEntity standard;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject_id", nullable = false)
    private AcademicSubjectEntity subject;

    @Column(name = "is_optional", nullable = false)
    private Boolean isOptional = false;
}