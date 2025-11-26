package com.smartsolutions.eschool.student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "student_fee_assignments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentFeeAssignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- Foreign Keys ---

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fee_rate_id", nullable = false)
    private FeeRateEntity feeRate;

    // --- Fields ---

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "assigned_date")
    private LocalDate assignedDate;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<StudentFeePaymentEntity> payments;
}
