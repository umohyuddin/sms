package com.smartsolutions.eschool.lookups.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "provinces", uniqueConstraints = {@UniqueConstraint(columnNames = {"country_id", "name"})})
@Getter
@Setter
public class ProvinceEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;       // e.g. "Punjab"

    @Column(length = 10)
    private String code;       // e.g. "PB"

    @Column(nullable = false)
    private Boolean isActive = true;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    /* -----------------------------
     * COUNTRY (FK)
     * ----------------------------- */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private CountryEntity country;
}
