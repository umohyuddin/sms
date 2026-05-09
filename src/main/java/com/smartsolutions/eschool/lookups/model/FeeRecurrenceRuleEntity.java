package com.smartsolutions.eschool.lookups.model;
import org.hibernate.annotations.SQLRestriction;

import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;


@Entity
@SQLDelete(sql = "UPDATE fee_recurrence_rules SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "fee_recurrence_rules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeeRecurrenceRuleEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", length = 30, unique = true, nullable = false)
    private String code;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "occurrence_interval")
    private Integer occurrenceInterval;
}
