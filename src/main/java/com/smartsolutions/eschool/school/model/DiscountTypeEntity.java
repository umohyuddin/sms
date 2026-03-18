package com.smartsolutions.eschool.school.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.lookups.model.FeeRecurrenceRuleEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "discount_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountTypeEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", length = 50, nullable = false, unique = true)
    private String code;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "active", nullable = false)
    private Boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "charge_type_id", nullable = false)
    private ChargeTypeEntity chargeType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recurrence_rule_id")
    private FeeRecurrenceRuleEntity recurrenceRule;

    @Column(name = "priority")
    private Integer priority = 0;

    @Column(name = "display_order")
    private Integer displayOrder = 0;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

}
