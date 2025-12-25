package com.smartsolutions.eschool.employee.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "salary_payment")
@Getter
@Setter
public class SalaryPaymentEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to employee salary (computed salary for month)
    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_salary_id", nullable = false)
    private EmployeeMasterSalary employeeSalary;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_mode", nullable = false, length = 20)
    private PaymentMode paymentMode;

    @Column(name = "transaction_reference", length = 100)
    private String transactionReference;

    @Column(name = "amount_paid", nullable = false, precision = 12, scale = 2)
    private BigDecimal amountPaid;

    @Column(name = "remarks", length = 255)
    private String remarks;
    @Column(name = "deleted")
    private Boolean deleted;

    // Payment mode enum
    public enum PaymentMode {
        BANK_TRANSFER,
        CASH,
        CHEQUE,
        OTHER
    }
}
