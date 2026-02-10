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

    @Query("SELECT ew FROM ExamWeightageEntity ew WHERE ew.standard.id = :standardId AND ew.deleted = false")
    List<ExamWeightageEntity> findByStandardId(@Param("standardId") Long standardId);

    @Query("SELECT ew FROM ExamWeightageEntity ew " +
            "JOIN FETCH ew.subject s " +
            "JOIN FETCH ew.examTerm et " +
            "WHERE ew.standard.id = :standardId " +
            "AND ew.examTerm.id = :examTermId " +
            "AND ew.deleted = false " +
            "AND ew.active = true")
    List<ExamWeightageEntity> findByStandardAndExamTerm(@Param("standardId") Long standardId,
            @Param("examTermId") Long examTermId);

    @Modifying
    @Query("UPDATE ExamWeightageEntity ew SET ew.deleted = true, ew.deletedAt = CURRENT_TIMESTAMP WHERE ew.id = :id")
    void softDeleteById(@Param("id") Long id);
}
