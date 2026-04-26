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

    @Query("""
            SELECT COALESCE(SUM(p.amountPaid), 0)
            FROM StudentFeePaymentEntity p
            WHERE p.student.id = :studentId
            AND p.academicYear.id = :academicYearId
            AND p.student.campus.institute.id = :instituteId
            """)
    java.math.BigDecimal findTotalPaidByStudentAndYear(
            @Param("studentId") Long studentId,
            @Param("academicYearId") Long academicYearId,
            @Param("instituteId") Long instituteId
    );

    @Query("""
        SELECT COALESCE(SUM(p.amountPaid), 0)
        FROM StudentFeePaymentEntity p
        WHERE p.student.campus.institute.id = :instituteId
          AND (:campusIds IS NULL OR p.student.campus.id IN :campusIds)
          AND (:academicYearId IS NULL OR p.academicYear.id = :academicYearId)
          AND (:standardId IS NULL OR p.student.standard.id = :standardId)
          AND (:sectionId IS NULL OR p.student.section.id = :sectionId)
          AND (:fromDate IS NULL OR p.paymentDate >= :fromDate)
          AND (:toDate IS NULL OR p.paymentDate <= :toDate)
    """)
    Double sumCollectionByFilters(
            @Param("campusIds") List<Long> campusIds,
            @Param("academicYearId") Long academicYearId,
            @Param("standardId") Long standardId,
            @Param("sectionId") Long sectionId,
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate,
            @Param("instituteId") Long instituteId
    );

    @Query("""
        SELECT 'Total Collections', COALESCE(SUM(p.amountPaid), 0)
        FROM StudentFeePaymentEntity p
        WHERE p.student.campus.institute.id = :instituteId
          AND (:campusIds IS NULL OR p.student.campus.id IN :campusIds)
          AND (:fromDate IS NULL OR p.paymentDate >= :fromDate)
          AND (:toDate IS NULL OR p.paymentDate <= :toDate)
    """)
    List<Object[]> collectionByFeeTypeDistribution(
            @Param("campusIds") List<Long> campusIds,
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate,
            @Param("instituteId") Long instituteId
    );

    @Query("""
        SELECT p.paymentDate, SUM(p.amountPaid)
        FROM StudentFeePaymentEntity p
        WHERE p.student.campus.institute.id = :instituteId
          AND (:campusIds IS NULL OR p.student.campus.id IN :campusIds)
          AND p.paymentDate BETWEEN :fromDate AND :toDate
        GROUP BY p.paymentDate
        ORDER BY p.paymentDate
    """)
    List<Object[]> getRevenueTrend(
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate,
            @Param("campusIds") List<Long> campusIds,
            @Param("instituteId") Long instituteId
    );

    @Query("""
        SELECT p.student.campus.campusName, SUM(p.amountPaid)
        FROM StudentFeePaymentEntity p
        WHERE p.student.campus.institute.id = :instituteId
          AND (:campusIds IS NULL OR p.student.campus.id IN :campusIds)
          AND (:fromDate IS NULL OR p.paymentDate >= :fromDate)
          AND (:toDate IS NULL OR p.paymentDate <= :toDate)
        GROUP BY p.student.campus.campusName
    """)
    List<Object[]> getCollectionByCampus(
            @Param("campusIds") List<Long> campusIds,
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate,
            @Param("instituteId") Long instituteId
    );
}



