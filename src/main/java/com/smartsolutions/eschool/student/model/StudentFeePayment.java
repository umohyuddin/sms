package com.smartsolutions.eschool.student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_fee_payments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentFeePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- Foreign Keys ---

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id", nullable = false)
    private StudentFeeAssignmentEntity assignment;

    // --- Fields ---

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "amount_paid", nullable = false)
    private Double amountPaid;

    @Column(name = "payment_month", nullable = false, length = 20)
    private String paymentMonth;

    @Column(name = "payment_year", nullable = false)
    private Integer paymentYear;

    @Column(name = "payment_mode", length = 50)
    private String paymentMode;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
