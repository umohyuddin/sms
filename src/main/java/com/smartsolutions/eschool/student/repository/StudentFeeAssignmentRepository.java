package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.StudentFeeAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentFeeAssignmentRepository extends JpaRepository<StudentFeeAssignmentEntity, Long> {

    @Query("""
            SELECT CASE WHEN COUNT(sfa) > 0 THEN true ELSE false END
            FROM StudentFeeAssignmentEntity sfa
            WHERE sfa.student.id = :studentId
              AND sfa.academicYear.id = :academicYearId
              AND sfa.organizationId = :instituteId
            """)
    boolean isFeeAssigned(@Param("studentId") Long studentId,
                          @Param("academicYearId") Long academicYearId,
                          @Param("instituteId") Long instituteId);

    @Query("""
            SELECT COALESCE(SUM(a.totalAmount), 0)
            FROM StudentFeeAssignmentEntity a
            WHERE a.student.id = :studentId
              AND a.academicYear.id = :academicYearId
              AND a.organizationId = :instituteId
            """)
    BigDecimal findTotalAssignedFee(
            @Param("studentId") Long studentId,
            @Param("academicYearId") Long academicYearId,
            @Param("instituteId") Long instituteId
    );

    @Query("""
            SELECT COALESCE(SUM(a.totalAmount), 0)
            FROM StudentFeeAssignmentEntity a
            WHERE a.student.id = :studentId
              AND a.academicYear.id = :academicYearId
              AND a.organizationId = :instituteId
              AND a.feeRate.feeComponent.discountable = true
            """)
    BigDecimal findTotalDiscountableAssignedFee(
            @Param("studentId") Long studentId,
            @Param("academicYearId") Long academicYearId,
            @Param("instituteId") Long instituteId
    );

    @Query("""
            SELECT sfa
            FROM StudentFeeAssignmentEntity sfa
            JOIN FETCH sfa.student s
            LEFT JOIN FETCH s.campus c
            LEFT JOIN FETCH s.standard st
            LEFT JOIN FETCH s.section sec
            LEFT JOIN FETCH s.academicYear ay
            JOIN FETCH sfa.feeRate fr
            LEFT JOIN FETCH fr.feeComponent fc
            LEFT JOIN FETCH fc.feeCatalog fca
            LEFT JOIN FETCH fca.chargeType ct
            LEFT JOIN FETCH fca.recurrenceRule rr
            WHERE s.id = :studentId
              AND sfa.academicYear.id = :academicYearId
              AND sfa.organizationId = :instituteId
            """)
    List<StudentFeeAssignmentEntity> findAllByStudentAndAcademicYear(
            @Param("studentId") Long studentId,
            @Param("academicYearId") Long academicYearId,
            @Param("instituteId") Long instituteId
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
            LEFT JOIN FETCH fr.feeComponent fc
            LEFT JOIN FETCH fc.feeCatalog fca
            LEFT JOIN FETCH fca.chargeType ct
            LEFT JOIN FETCH fca.recurrenceRule rr
            WHERE s.id = :studentId
              AND a.academicYear.id = :academicYearId
              AND a.organizationId = :instituteId
            """)
    List<StudentFeeAssignmentEntity> findAssignedFeesForStudentAndYear(
            @Param("studentId") Long studentId,
            @Param("academicYearId") Long academicYearId,
            @Param("instituteId") Long instituteId
    );

    @Query("""
            SELECT COALESCE(SUM(a.totalAmount), 0)
            FROM StudentFeeAssignmentEntity a
            WHERE a.academicYear.id = :academicYearId
              AND a.organizationId = :instituteId
            """)
    BigDecimal getTotalFeeAssigned(@Param("academicYearId") Long academicYearId, @Param("instituteId") Long instituteId);


    @Query("""
            SELECT sfa FROM StudentFeeAssignmentEntity sfa
            JOIN FETCH sfa.student s
            LEFT JOIN FETCH s.campus c
            LEFT JOIN FETCH s.standard st
            LEFT JOIN FETCH s.section sec
            LEFT JOIN FETCH s.academicYear ay
            JOIN FETCH sfa.feeRate fr
            LEFT JOIN FETCH fr.feeComponent fc
            LEFT JOIN FETCH fc.feeCatalog fca
            LEFT JOIN FETCH fca.chargeType ct
            LEFT JOIN FETCH fca.recurrenceRule rr
            WHERE sfa.organizationId = :instituteId
            ORDER BY sfa.createdAt DESC
            """)
    List<StudentFeeAssignmentEntity> findAllWithStudent(@Param("instituteId") Long instituteId);

    @Query("""
            SELECT sfa FROM StudentFeeAssignmentEntity sfa
            JOIN FETCH sfa.student s
            LEFT JOIN FETCH s.campus c
            LEFT JOIN FETCH s.standard st
            LEFT JOIN FETCH s.section sec
            LEFT JOIN FETCH s.academicYear ay
            JOIN FETCH sfa.feeRate fr
            LEFT JOIN FETCH fr.feeComponent fc
            LEFT JOIN FETCH fc.feeCatalog fca
            LEFT JOIN FETCH fca.chargeType ct
            LEFT JOIN FETCH fca.recurrenceRule rr
            WHERE sfa.organizationId = :instituteId
              AND (LOWER(s.fullName) LIKE LOWER(CONCAT('%', :keyword, '%'))
               OR LOWER(s.studentCode) LIKE LOWER(CONCAT('%', :keyword, '%')))
            ORDER BY sfa.createdAt DESC
            """)
    List<StudentFeeAssignmentEntity> searchByStudentKeyword(@Param("keyword") String keyword, @Param("instituteId") Long instituteId);

    @Query("""
            SELECT COUNT(sfa)
            FROM StudentFeeAssignmentEntity sfa
            WHERE sfa.organizationId = :instituteId
            """)
    Long countTotalAssignments(@Param("instituteId") Long instituteId);

    @Query("""
            SELECT COUNT(sfa) FROM StudentFeeAssignmentEntity sfa
            WHERE sfa.academicYear.id = :academicYearId
              AND sfa.organizationId = :instituteId
            """)
    Long countByAcademicYear(@Param("academicYearId") Long academicYearId, @Param("instituteId") Long instituteId);


    @Query("""
            SELECT sfa FROM StudentFeeAssignmentEntity sfa
            JOIN FETCH sfa.student s
            LEFT JOIN FETCH s.campus c
            LEFT JOIN FETCH s.standard st
            LEFT JOIN FETCH s.section sec
            LEFT JOIN FETCH s.academicYear ay
            JOIN FETCH sfa.feeRate fr
            LEFT JOIN FETCH fr.feeComponent fc
            LEFT JOIN FETCH fc.feeCatalog fca
            LEFT JOIN FETCH fca.chargeType ct
            LEFT JOIN FETCH fca.recurrenceRule rr
            WHERE sfa.id = :id AND sfa.organizationId = :instituteId
            """)
    Optional<StudentFeeAssignmentEntity> findByIdAndInstituteId(@Param("id") Long id, @Param("instituteId") Long instituteId);

    @Query("""
        SELECT COALESCE(SUM(a.totalAmount), 0)
        FROM StudentFeeAssignmentEntity a
        WHERE a.organizationId = :instituteId
          AND (:campusIds IS NULL OR a.student.campus.id IN :campusIds)
          AND (:academicYearId IS NULL OR a.academicYear.id = :academicYearId)
    """)
    BigDecimal sumPendingDuesByFilters(
            @Param("campusIds") java.util.List<Long> campusIds,
            @Param("academicYearId") Long academicYearId,
            @Param("instituteId") Long instituteId
    );

    @Query("""
        SELECT a.student.standard.standardName, COALESCE(SUM(a.totalAmount), 0)
        FROM StudentFeeAssignmentEntity a
        WHERE a.organizationId = :instituteId
          AND (:campusIds IS NULL OR a.student.campus.id IN :campusIds)
        GROUP BY a.student.standard.standardName
    """)
    java.util.List<Object[]> pendingDuesByStandardDistribution(
            @Param("campusIds") java.util.List<Long> campusIds,
            @Param("instituteId") Long instituteId
    );

    @Query("""
        SELECT 
            'ALL',
            COUNT(a)
        FROM StudentFeeAssignmentEntity a
        WHERE a.organizationId = :instituteId
          AND (:campusIds IS NULL OR a.student.campus.id IN :campusIds)
    """)
    java.util.List<Object[]> getFeeStatusDistribution(
            @Param("campusIds") java.util.List<Long> campusIds,
            @Param("instituteId") Long instituteId
    );}

