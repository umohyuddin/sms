package com.smartsolutions.eschool.employee.model;
import org.hibernate.annotations.SQLRestriction;

import org.hibernate.annotations.SQLDelete;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@SQLDelete(sql = "UPDATE employee_bonus SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "employee_bonus")
@Getter
@Setter
public class EmployeeBonusEntity  extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to employee
    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeMasterEntity employee;

    @Column(name = "bonus_type", nullable = false, length = 50)
    private String bonusType; // e.g., Festival Bonus, Performance

    @Column(name = "amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    // Payroll period reference
    @ManyToOne(optional = false)
    @JoinColumn(name = "payroll_period_id", nullable = false)
    private PayrollPeriodEntity payrollPeriod;

    @Column(name = "remarks", length = 255)
    private String remarks;
}
