package com.smartsolutions.eschool.student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "fee_component")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeeComponentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many components belong to one Fee Catalog
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fee_catalog_id", nullable = false)
    private FeeCatalogEntity feeCatalog;

    @Column(name = "component_code", nullable = false, length = 50)
    private String componentCode;

    @Column(name = "component_name", nullable = false, length = 100)
    private String componentName;

    @Column(name = "account_code", length = 50)
    private String accountCode;

    @Column(name = "taxable", nullable = false)
    private boolean taxable = false;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;



    @OneToMany(mappedBy = "feeComponent", fetch = FetchType.LAZY)
    private List<FeeRateEntity> feeRates;
}
