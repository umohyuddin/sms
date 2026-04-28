package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.mapping.ExamWeightageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamWeightageRepository extends JpaRepository<ExamWeightageEntity, Long> {

        @Query("SELECT ew FROM ExamWeightageEntity ew WHERE ew.standardSubject.standard.id = :standardId AND ew.deleted = false")
        List<ExamWeightageEntity> findByStandardId(@Param("standardId") Long standardId);

        @Query("SELECT ew FROM ExamWeightageEntity ew WHERE ew.academicYear.id = :academicYearId AND ew.standardSubject.standard.id = :standardId AND ew.deleted = false")
        List<ExamWeightageEntity> findByAcademicYearIdAndStandardId(@Param("academicYearId") Long academicYearId,
                        @Param("standardId") Long standardId);

        @Query("SELECT ew FROM ExamWeightageEntity ew " +
                        "JOIN FETCH ew.standardSubject ss " +
                        "JOIN FETCH ss.subject s " +
                        "JOIN FETCH ew.examTerm et " +
                        "WHERE ss.standard.id = :standardId " +
                        "AND ew.examTerm.id = :examTermId " +
                        "AND ew.deleted = false " +
                        "AND ew.active = true")
        List<ExamWeightageEntity> findByStandardAndExamTerm(@Param("standardId") Long standardId,
                        @Param("examTermId") Long examTermId);

        @Modifying
        @Query("UPDATE ExamWeightageEntity ew SET ew.deleted = true, ew.deletedAt = CURRENT_TIMESTAMP " +
                        "WHERE ew.academicYear.id = :academicYearId " +
                        "AND ew.standardSubject.standard.id = :standardId " +
                        "AND ew.examTerm.id = :examTermId")
        void bulkSoftDelete(@Param("academicYearId") Long academicYearId,
                        @Param("standardId") Long standardId,
                        @Param("examTermId") Long examTermId);

        @Modifying
        @Query("UPDATE ExamWeightageEntity ew SET ew.deleted = true, ew.deletedAt = CURRENT_TIMESTAMP WHERE ew.id = :id")
        void softDeleteById(@Param("id") Long id);
}
