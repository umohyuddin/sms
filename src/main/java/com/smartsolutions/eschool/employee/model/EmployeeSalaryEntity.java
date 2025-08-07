package com.smartsolutions.eschool.employee.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "salary")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSalaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slr_id")
    private Long id;

    @Column(name = "emp_id", nullable = false)
    private Long empId;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "month", nullable = false)
    private Integer month;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private SalaryStatus status;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    private EmployeeEntity employee;

    public enum SalaryStatus {
        Paid,
        Pending,
        Conflict
    }
}
