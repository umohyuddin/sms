package com.smartsolutions.eschool.lookups.model;

import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "country", uniqueConstraints = @UniqueConstraint(columnNames = {"country_code"}))
@Getter
@Setter
public class CountryEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_code", nullable = false, length = 5, unique = true)
    private String countryCode;

    @Column(name = "country_name", nullable = false, length = 100)
    private String countryName;

    @Column(name = "iso_code", length = 3)
    private String isoCode;

    @Column(name = "phone_code", length = 10)
    private String phoneCode;
}

