package com.smartsolutions.eschool.employee.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salary_slip")
public class SalarySlipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to employee_salary
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_salary_id", nullable = false)
    private EmployeeSalaryEntity employeeSalary;

    // Link to payroll_period
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payroll_period_id", nullable = false)
    private PayrollPeriodEntity payrollPeriod;

    // PDF or file location
    @Column(name = "slip_url", length = 255)
    private String slipUrl;

    @Column(name = "deleted")
    private Boolean deleted = false;
}
