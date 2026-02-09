package com.smartsolutions.sms.academic.repository;

import com.smartsolutions.sms.academic.entity.mapping.StudentAssessmentEntity;
import com.smartsolutions.sms.academic.entity.embeddable.StudentAssessmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentAssessmentRepository extends JpaRepository<StudentAssessmentEntity, StudentAssessmentId> {

    @Query("SELECT sa FROM StudentAssessmentEntity sa JOIN FETCH sa.student " +
           "WHERE sa.id.assessmentId = :assessmentId AND sa.deleted = false")
    List<StudentAssessmentEntity> findByAssessmentId(@Param("assessmentId") Long assessmentId);

    @Modifying
    @Query("UPDATE StudentAssessmentEntity sa SET sa.deleted = true, sa.deletedAt = CURRENT_TIMESTAMP WHERE sa.id = :id")
    void softDeleteById(@Param("id") StudentAssessmentId id);
}
