package com.smartsolutions.eschool.student.model;
import org.hibernate.annotations.SQLRestriction;

import org.hibernate.annotations.SQLDelete;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@SQLDelete(sql = "UPDATE student_fee_assignments SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "student_fee_assignments", uniqueConstraints = {@UniqueConstraint(columnNames = {"student_id", "fee_rate_id", "academic_year_id"})})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentFeeAssignmentEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // organization_id is inherited from AuditableEntity

    // --- Foreign Keys ---

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fee_rate_id", nullable = false)
    private FeeRateEntity feeRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_year_id", nullable = false)
    private AcademicYearEntity academicYear;

    // --- Fields ---

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "assigned_date")
    private LocalDate assignedDate;
}
