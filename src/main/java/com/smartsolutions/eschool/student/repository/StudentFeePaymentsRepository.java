package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.StudentFeeAssignmentEntity;
import com.smartsolutions.eschool.student.model.StudentFeePaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface StudentFeePaymentsRepository extends JpaRepository<StudentFeePaymentEntity, Long> {


    @Query("""
                SELECT COALESCE(SUM(a.totalAmount), 0)
                FROM StudentFeeAssignmentEntity a
                WHERE a.student.id = :studentId
                  AND a.feeRate.academicYear.id = :academicYearId
            """)
    Double findTotalAssignedFee(
            @Param("studentId") Long studentId,
            @Param("academicYearId") Long academicYearId
    );

    @Query("""
            SELECT sf
            FROM StudentFeeAssignmentEntity sf
            JOIN FETCH sf.student s
            JOIN FETCH sf.feeRate fr
            JOIN FETCH sf.feeRate.feeComponent c
            WHERE s.id = :studentId
              AND fr.academicYear.id = :academicYearId
            """)
    List<StudentFeeAssignmentEntity> findAllByStudentAndAcademicYear(
            @Param("studentId") Long studentId,
            @Param("academicYearId") Long academicYearId
    );
}



