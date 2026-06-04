package com.smartsolutions.eschool.student.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@SQLDelete(sql = "UPDATE student_fee_invoices SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "student_fee_invoices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StudentFeeInvoiceEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "invoice_number", unique = true, nullable = false, length = 50)
    private String invoiceNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_year_id", nullable = false)
    private AcademicYearEntity academicYear;

    @Column(name = "month", nullable = false, length = 20)
    private String month;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "total_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "late_fee_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal lateFeeAmount = BigDecimal.ZERO;

    @Column(name = "discount_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal discountAmount;

    @Column(name = "paid_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal paidAmount;

    @Column(name = "balance", nullable = false, precision = 12, scale = 2)
    private BigDecimal balance;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "invoice_date", nullable = false)
    private LocalDate invoiceDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private InvoiceStatus status = InvoiceStatus.UNPAID;

    @Column(name = "waived_amount", precision = 12, scale = 2)
    private BigDecimal waivedAmount = BigDecimal.ZERO;

    @Column(name = "waived_reason")
    private String waivedReason;

    @Column(name = "last_reminder_sent_at")
    private java.time.LocalDateTime lastReminderSentAt;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentFeeInvoiceDetailEntity> details;

    public enum InvoiceStatus {
        UNPAID, PARTIAL, PAID, CANCELLED
    }
}
