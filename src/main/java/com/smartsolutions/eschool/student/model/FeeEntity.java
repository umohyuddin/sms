package com.smartsolutions.eschool.student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;

@Entity
@Table(name = "fee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fee_id")
    private Long feeId;

    @Column(name = "std_id")
    private Long studentId;

    @Column(name = "tuition_fee", precision = 10, scale = 2)
    private BigDecimal tuitionFee;

    @Column(name = "stationery", precision = 10, scale = 2)
    private BigDecimal stationery;

    @Column(name = "sports", precision = 10, scale = 2)
    private BigDecimal sports;

    @Column(name = "annual_fee", precision = 10, scale = 2)
    private BigDecimal annualFee;

    @Column(name = "electricity", precision = 10, scale = 2)
    private BigDecimal electricity;

    @Column(name = "maintenance", precision = 10, scale = 2)
    private BigDecimal maintenance;

    @Column(name = "miscellaneous", precision = 10, scale = 2)
    private BigDecimal miscellaneous;

    @Column(name = "t_amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "p_amount", precision = 10, scale = 2)
    private BigDecimal paidAmount;

    @Column(name = "arrears", precision = 10, scale = 2)
    private BigDecimal arrears;

    @Column(name = "year")
    private Year year;

    @Column(name = "month")
    private Integer month;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private FeeStatus status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "std_id", referencedColumnName = "student_id", insertable = false, updatable = false)
    private StudentEntity student;

    public enum FeeStatus {
        Paid, Pending, Conflict
    }
}
