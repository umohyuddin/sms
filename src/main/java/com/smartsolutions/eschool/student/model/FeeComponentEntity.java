package com.smartsolutions.eschool.student.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Entity
@Table(name = "fee_component", uniqueConstraints = {@UniqueConstraint(columnNames = {"fee_catalog_id", "component_code"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLRestriction("deleted = false")
public class FeeComponentEntity extends AuditableEntity {
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

    @Column(name = "deleted")
    private boolean deleted = false;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    @Column(name = "discount_able", nullable = false)
    private boolean discountable;


    @OneToMany(mappedBy = "feeComponent", fetch = FetchType.LAZY)
    private List<FeeRateEntity> feeRates;
    //private String description;

}
