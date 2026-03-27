package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.StudentFeePaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentFeePaymentsRepository extends JpaRepository<StudentFeePaymentEntity, Long> {

    @Query("""
            SELECT p FROM StudentFeePaymentEntity p
            WHERE p.student.id = :studentId
            AND p.academicYear.id = :academicYearId
            AND p.student.campus.institute.id = :instituteId
            """)
    List<StudentFeePaymentEntity> findPaymentsByStudentAndAcademicYear(
            @Param("studentId") Long studentId,
            @Param("academicYearId") Long academicYearId,
            @Param("instituteId") Long instituteId
    );

    @Query("""
            SELECT COALESCE(SUM(p.amountPaid), 0)
            FROM StudentFeePaymentEntity p
            WHERE p.academicYear.id = :academicYearId
            AND p.student.campus.institute.id = :instituteId
            """)
    Double getTotalFeeCollected(
            @Param("academicYearId") Long academicYearId,
            @Param("instituteId") Long instituteId
    );

    @Query("""
            SELECT COALESCE(SUM(sfp.amountPaid), 0)
            FROM StudentFeePaymentEntity sfp
            WHERE sfp.academicYear.id = :academicYearId
            AND sfp.paymentDate <= :endOfMonth
            AND sfp.student.campus.institute.id = :instituteId
            """)
    Double getTotalCollectedUpToMonth(
            @Param("academicYearId") Long academicYearId,
            @Param("endOfMonth") LocalDate endOfMonth,
            @Param("instituteId") Long instituteId
    );
}



