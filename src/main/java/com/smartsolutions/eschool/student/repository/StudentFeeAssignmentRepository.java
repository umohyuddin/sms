package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.StudentFeeAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface StudentFeeAssignmentRepository extends JpaRepository<StudentFeeAssignmentEntity, Long> {


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
}



