package com.smartsolutions.eschool.employee.model;


import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.global.enums.ComponentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "salary_component")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE salary_component SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class SalaryComponentEntity  extends AuditableEntity {
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


}
