package com.smartsolutions.eschool.lookups.model;
import org.hibernate.annotations.SQLRestriction;

import org.hibernate.annotations.SQLDelete;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@SQLDelete(sql = "UPDATE provinces SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "provinces", uniqueConstraints = { @UniqueConstraint(columnNames = { "country_id", "name" }) })
@Getter
@Setter
public class ProvinceEntity extends ScopeAuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name; // e.g. "Punjab"

    @Column(length = 10)
    private String code; // e.g. "PB"

    @Column(nullable = false)
    private Boolean isActive = true;

    /*
     * -----------------------------
     * COUNTRY (FK)
     * -----------------------------
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private CountryEntity country;
}
