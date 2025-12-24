package com.smartsolutions.eschool.employee.repository;


import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "salary_component")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaryComponentRepository extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ComponentType type;

    @Column(name = "is_percentage", nullable = false)
    private Boolean isPercentage = true;

    @Column(nullable = false)
    private Boolean deleted = false;


    public enum ComponentType {
        EARNING,
        DEDUCTION
    }
}
