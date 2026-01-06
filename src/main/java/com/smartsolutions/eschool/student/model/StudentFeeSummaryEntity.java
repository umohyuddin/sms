package com.smartsolutions.eschool.student.model;

import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "student_fee_summary", uniqueConstraints = {@UniqueConstraint(columnNames = {"student_id", "academic_year_id"})})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentFeeSummaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalAssignedFee;

    private BigDecimal totalPaid;

    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;
    // Replace string with FK to AcademicYearEntity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_year_id", nullable = false)
    private AcademicYearEntity academicYear;

}


