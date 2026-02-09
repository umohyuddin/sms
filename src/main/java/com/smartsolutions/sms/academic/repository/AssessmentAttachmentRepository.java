package com.smartsolutions.sms.academic.repository;

import com.smartsolutions.sms.academic.entity.master.AssessmentAttachmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentAttachmentRepository extends JpaRepository<AssessmentAttachmentEntity, Long> {

    @Query("SELECT aa FROM AssessmentAttachmentEntity aa WHERE aa.assessment.id = :assessmentId AND aa.deleted = false")
    List<AssessmentAttachmentEntity> findByAssessmentId(@Param("assessmentId") Long assessmentId);

    @Modifying
    @Query("UPDATE AssessmentAttachmentEntity aa SET aa.deleted = true, aa.deletedAt = CURRENT_TIMESTAMP WHERE aa.id = :id")
    void softDeleteById(@Param("id") Long id);
}
