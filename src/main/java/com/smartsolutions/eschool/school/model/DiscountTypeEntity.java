package com.smartsolutions.eschool.school.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "discount_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountTypeEntity  extends AuditableEntity {

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

    @Column(name = "charge_type", nullable = false, length = 50)
    private String chargeType;
    // You can convert to ENUM later: FIXED, PERCENTAGE, PER_CREDIT, etc.

    @Column(name = "recurrence_rule", length = 50)
    private String recurrenceRule;

    @Column(name = "priority")
    private Integer priority = 0;

    @Column(name = "display_order")
    private Integer displayOrder = 0;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

}
