package com.smartsolutions.eschool.student.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
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
public class StudentFeePaymentEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // organization_id is inherited from AuditableEntity

    // --- Foreign Keys ---

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_year_id", nullable = false)
    private AcademicYearEntity academicYear;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;
}
