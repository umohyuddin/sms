package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.StudentFeeAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface StudentFeeAssignmentRepository extends JpaRepository<StudentFeeAssignmentEntity, Long> {

    @Query("SELECT CASE WHEN COUNT(sfa) > 0 THEN true ELSE false END " +
            "FROM StudentFeeAssignmentEntity sfa " +
            "WHERE sfa.student.id = :studentId " +
            "AND sfa.feeRate.academicYear.id = :academicYearId")
    boolean isFeeAssigned(@Param("studentId") Long studentId,
                          @Param("academicYearId") Long academicYearId);

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


    @Query("""
                SELECT a
                FROM StudentFeeAssignmentEntity a
                JOIN FETCH a.student s
                LEFT JOIN FETCH s.campus c
                LEFT JOIN FETCH s.standard st
                LEFT JOIN FETCH s.section sec
                LEFT JOIN FETCH s.academicYear ay
                JOIN FETCH a.feeRate fr
                JOIN FETCH fr.feeComponent fc
                JOIN FETCH fc.feeCatalog fca
                WHERE s.id = :studentId
                  AND s.academicYear.id = :academicYearId
            """)
    List<StudentFeeAssignmentEntity> findAssignedFeesForStudentAndYear(
            @Param("studentId") Long studentId,
            @Param("academicYearId") Long academicYearId
    );

    /**
     * Calculates the total fee amount assigned to students for a specific academic year.
     * This query sums the totalAmount from all Student Fee Assignments
     * that belong to the given academic year via the associated Fee Rate.
     * If no fee assignments exist for the specified academic year,
     * the result will be 0 instead of NULL.
     *
     * @param academicYearId the ID of the academic year
     * @return total fee amount assigned for the academic year
     */

    @Query("""
                SELECT COALESCE(SUM(a.totalAmount), 0)
                FROM StudentFeeAssignmentEntity a
                WHERE a.feeRate.academicYear.id = :academicYearId
            """)
    Double getTotalFeeAssigned(@Param("academicYearId") Long academicYearId);


    /**
     * Calculates the total amount of fees that are overdue for a specific academic year.
     * The query sums the `totalAmount` from all Student Fee Assignments where:
     * 1. The due date has already passed (`dueDate < CURRENT_DATE`)
     * 2. The fee assignment belongs to the specified academic year via the Fee Rate
     * If no overdue fees exist, the method returns 0 instead of NULL.
     *
     * @param academicYearId the ID of the academic year
     * @return the total overdue fee amount for the academic year
     */
    @Query("""
                SELECT COALESCE(SUM(a.totalAmount), 0)
                FROM StudentFeeAssignmentEntity a
                WHERE a.dueDate < CURRENT_DATE
                  AND a.feeRate.academicYear.id = :academicYearId
            """)
    Double getOverdueAmount(@Param("academicYearId") Long academicYearId);

}



