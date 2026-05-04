package com.smartsolutions.eschool.school.model;
import org.hibernate.annotations.SQLRestriction;

import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;


import java.time.LocalDate;

@Entity
@SQLDelete(sql = "UPDATE institute_accreditations SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "institute_accreditations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteAccreditationEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id", nullable = false)
    private InstituteEntity institute;

    @Column(name = "authority_name", length = 100)
    private String authorityName;

    @Column(name = "license_number", length = 50)
    private String licenseNumber;

    @Column(name = "valid_from")
    private LocalDate validFrom;

    @Column(name = "valid_to")
    private LocalDate validTo;

    @Column(name = "is_active")
    private Boolean isActive = true;
}
