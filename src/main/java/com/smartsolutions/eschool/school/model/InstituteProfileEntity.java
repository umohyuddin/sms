package com.smartsolutions.eschool.school.model;
import org.hibernate.annotations.SQLRestriction;

import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;


@Entity
@SQLDelete(sql = "UPDATE institute_profiles SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "institute_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteProfileEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id", nullable = false, unique = true)
    private InstituteEntity institute;

    @Lob
    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "mission")
    private String mission;

    @Lob
    @Column(name = "vision")
    private String vision;

    @Lob
    @Column(name = "values")
    private String values;

    @Lob
    @Column(name = "about_chairperson")
    private String aboutChairperson;

    @Column(name = "organization_email", length = 100)
    private String organizationEmail;
}
