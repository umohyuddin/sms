package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.mapping.ExamWeightageEntity;
import com.smartsolutions.eschool.academic.entity.embeddable.ExamWeightageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamWeightageRepository extends JpaRepository<ExamWeightageEntity, ExamWeightageId> {

    @Query("SELECT ew FROM ExamWeightageEntity ew WHERE ew.id.standardId = :standardId AND ew.deleted = false")
    List<ExamWeightageEntity> findByStandardId(@Param("standardId") Long standardId);

    @Modifying
    @Query("UPDATE ExamWeightageEntity ew SET ew.deleted = true, ew.deletedAt = CURRENT_TIMESTAMP WHERE ew.id = :id")
    void softDeleteById(@Param("id") ExamWeightageId id);
}
