package com.smartsolutions.eschool.lookups.model;

import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tax_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaxTypeEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", unique = true, nullable = false, length = 20)
    private String code;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "tax_percentage", nullable = false, precision = 5, scale = 2)
    private java.math.BigDecimal taxPercentage = java.math.BigDecimal.ZERO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;
}
