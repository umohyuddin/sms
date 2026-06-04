package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.StudentFeeSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface StudentFeeSummaryRepository extends JpaRepository<StudentFeeSummaryEntity, Long> {
    @Query("SELECT s FROM StudentFeeSummaryEntity s " +
            "JOIN FETCH s.student st " +
            "LEFT JOIN FETCH s.academicYear ay " +
            "WHERE st.id = :studentId")
    Optional<StudentFeeSummaryEntity> findByStudentId(
            @Param("studentId") Long studentId
    );

    @Query("SELECT s FROM StudentFeeSummaryEntity s " +
            "JOIN FETCH s.student st " +
            "LEFT JOIN FETCH s.academicYear ay")
    List<StudentFeeSummaryEntity> findAllStudentFeeSummary();

    @Query("SELECT s FROM StudentFeeSummaryEntity s " +
            "JOIN FETCH s.student st " +
            "LEFT JOIN FETCH s.academicYear ay " +
            "WHERE st.id = :studentId AND ay.id = :academicYearId")
    Optional<StudentFeeSummaryEntity> findByStudentIdAndAcademicYearId(
            @Param("studentId") Long studentId,
            @Param("academicYearId") Long academicYearId
    );

    @Query("SELECT s FROM StudentFeeSummaryEntity s " +
            "JOIN FETCH s.student st " +
            "LEFT JOIN FETCH s.academicYear ay " +
            "WHERE s.organizationId = :organizationId")
    List<StudentFeeSummaryEntity> findByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT s FROM StudentFeeSummaryEntity s " +
            "JOIN FETCH s.student st " +
            "LEFT JOIN FETCH s.academicYear ay " +
            "WHERE s.organizationId = :organizationId " +
            "AND (LOWER(st.fullName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(st.studentCode) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<StudentFeeSummaryEntity> searchByKeywordAndOrganizationId(
            @Param("keyword") String keyword,
            @Param("organizationId") Long organizationId);
}




