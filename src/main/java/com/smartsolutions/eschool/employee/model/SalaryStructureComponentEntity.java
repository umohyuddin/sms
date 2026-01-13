package com.smartsolutions.eschool.employee.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(
        name = "salary_structure_component",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_salary_structure_component_unique",
                        columnNames = {"salary_structure_id", "component_id"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaryStructureComponentEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation to SalaryStructure
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salary_structure_id", nullable = false)
    private SalaryStructureEntity salaryStructure;

    // Relation to SalaryComponent
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "component_id", nullable = false)
    private SalaryComponentEntity component;

    // Value: % if isPercentage=true, fixed amount otherwise
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal value;

    @Column(nullable = false)
    private Boolean deleted = false;

}
