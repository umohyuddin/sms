package com.smartsolutions.eschool.school.model;

import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "institute_facilities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE institute_facilities SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class InstituteFacilityEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id", nullable = false)
    private InstituteEntity institute;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_type_id", nullable = false)
    private com.smartsolutions.eschool.lookups.model.FacilityTypeEntity facilityType;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
}
