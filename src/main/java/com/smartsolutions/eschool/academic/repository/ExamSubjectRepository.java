package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.mapping.ExamSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamSubjectRepository extends JpaRepository<ExamSubjectEntity, Long> {

        @Query("SELECT es FROM ExamSubjectEntity es LEFT JOIN FETCH es.exam LEFT JOIN FETCH es.subject LEFT JOIN FETCH es.evaluator "
                        +
                        "WHERE es.exam.id = :examId AND es.deleted = false")
        List<ExamSubjectEntity> findByExamId(@Param("examId") Long examId);

        @Query("SELECT es FROM ExamSubjectEntity es LEFT JOIN FETCH es.exam LEFT JOIN FETCH es.subject LEFT JOIN FETCH es.evaluator "
                        +
                        "WHERE es.exam.id = :examId AND es.organizationId = :orgId AND es.deleted = false")
        List<ExamSubjectEntity> findByExamIdAndOrganizationIdAndDeletedFalse(@Param("examId") Long examId,
                        @Param("orgId") Long orgId);

        @Query("SELECT es FROM ExamSubjectEntity es WHERE es.exam.id = :examId AND es.subject.id = :subjectId AND es.deleted = false")
        Optional<ExamSubjectEntity> findByExamAndSubject(@Param("examId") Long examId,
                        @Param("subjectId") Long subjectId);

        @Modifying
        @Query("UPDATE ExamSubjectEntity es SET es.deleted = true, es.deletedAt = CURRENT_TIMESTAMP WHERE es.id = :id")
        void softDeleteById(@Param("id") Long id);
}
