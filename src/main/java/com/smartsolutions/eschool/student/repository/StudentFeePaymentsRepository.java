package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.StudentFeeAssignmentEntity;
import com.smartsolutions.eschool.student.model.StudentFeePaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Repository
public interface StudentFeePaymentsRepository extends JpaRepository<StudentFeePaymentEntity, Long> {


    @Query("""
            SELECT p FROM StudentFeePaymentEntity p
                        WHERE p.student.id = :studentId
                        AND p.academicYear.id = :academicYearId
            """)
    List<StudentFeePaymentEntity> findPaymentsByStudentAndAcademicYear(
            @Param("studentId") Long studentId,
            @Param("academicYearId") Long academicYearId
    );


    @Query("""
                SELECT COALESCE(SUM(p.amountPaid), 0)
                FROM StudentFeePaymentEntity p
                WHERE p.academicYear.id = :academicYearId
            """)
    Double getTotalFeeCollected(@Param("academicYearId") Long academicYearId);


    @Query("SELECT COALESCE(SUM(sfp.amountPaid), 0) " +
            "FROM StudentFeePaymentEntity sfp " +
            "WHERE sfp.academicYear.id = :academicYearId " +
            "AND sfp.paymentDate <= :endOfMonth")
    Double getTotalCollectedUpToMonth(Long academicYearId, LocalDate endOfMonth);
}



