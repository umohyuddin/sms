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

import java.math.BigDecimal;

@Entity
@SQLDelete(sql = "UPDATE student_fee_summary SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "student_fee_summary", uniqueConstraints = {@UniqueConstraint(columnNames = {"student_id", "academic_year_id"})})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentFeeSummaryEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // organization_id is inherited from AuditableEntity

    private BigDecimal totalAssignedFee;
    private BigDecimal totalDiscount;
    private BigDecimal totalPaid;
    private BigDecimal totalLateFee = BigDecimal.ZERO;
    private BigDecimal totalTax = BigDecimal.ZERO;
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    // Replace string with FK to AcademicYearEntity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_year_id", nullable = false)
    private AcademicYearEntity academicYear;
}


