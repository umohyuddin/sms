package com.smartsolutions.sms.academic.repository;

import com.smartsolutions.sms.academic.entity.mapping.ExamSubjectEntity;
import com.smartsolutions.sms.academic.entity.embeddable.ExamSubjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamSubjectRepository extends JpaRepository<ExamSubjectEntity, ExamSubjectId> {

    @Query("SELECT es FROM ExamSubjectEntity es JOIN FETCH es.subject JOIN FETCH es.evaluator " +
           "WHERE es.id.examId = :examId AND es.deleted = false")
    List<ExamSubjectEntity> findSubjectsByExamId(@Param("examId") Long examId);

    @Modifying
    @Query("UPDATE ExamSubjectEntity es SET es.deleted = true, es.deletedAt = CURRENT_TIMESTAMP WHERE es.id = :id")
    void softDeleteById(@Param("id") ExamSubjectId id);
}
