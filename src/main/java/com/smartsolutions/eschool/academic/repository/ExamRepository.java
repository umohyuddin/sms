package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.master.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity, Long> {

        @Query("SELECT e FROM ExamEntity e WHERE e.id = :id AND e.deleted = false")
        Optional<ExamEntity> findByIdAndDeletedFalse(@Param("id") Long id);

        @Query("SELECT e FROM ExamEntity e JOIN FETCH e.academicYear JOIN FETCH e.examTerm JOIN FETCH e.campus JOIN FETCH e.standard JOIN FETCH e.section "
                        +
                        "WHERE e.standard.id = :standardId AND e.section.id = :sectionId AND e.academicYear.id = :academicYearId AND e.deleted = false")
        List<ExamEntity> findExamsByStandardSectionAndAcademicYear(@Param("standardId") Long standardId,
                        @Param("sectionId") Long sectionId,
                        @Param("academicYearId") Long academicYearId);

        // Alias for convenience
        default List<ExamEntity> findBySectionAndAcademicYear(Long standardId, Long sectionId, Long academicYearId) {
                return findExamsByStandardSectionAndAcademicYear(standardId, sectionId, academicYearId);
        }

        @Query("SELECT e FROM ExamEntity e WHERE e.organizationId = :orgId AND e.status = :status AND e.deleted = false")
        List<ExamEntity> findByStatus(@Param("orgId") Long orgId, @Param("status") ExamEntity.ExamStatus status);

        @Modifying
        @Query("UPDATE ExamEntity e SET e.deleted = true, e.deletedAt = CURRENT_TIMESTAMP WHERE e.id = :id")
        void softDeleteById(@Param("id") Long id);
}
