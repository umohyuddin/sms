package com.smartsolutions.eschool.academic.repository;

import com.smartsolutions.eschool.academic.entity.mapping.StudentAssessmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentAssessmentRepository extends JpaRepository<StudentAssessmentEntity, Long> {

    @Query("SELECT sa FROM StudentAssessmentEntity sa JOIN FETCH sa.student WHERE sa.assessment.id = :assessmentId AND sa.deleted = false")
    List<StudentAssessmentEntity> findByAssessmentId(@Param("assessmentId") Long assessmentId);

    @Query("SELECT sa FROM StudentAssessmentEntity sa WHERE sa.assessment.id = :assessmentId AND sa.student.id = :studentId AND sa.deleted = false")
    Optional<StudentAssessmentEntity> findByAssessmentIdAndStudentId(@Param("assessmentId") Long assessmentId, @Param("studentId") Long studentId);

    @Query("SELECT sa FROM StudentAssessmentEntity sa WHERE sa.student.id = :studentId AND sa.deleted = false")
    List<StudentAssessmentEntity> findByStudentId(@Param("studentId") Long studentId);

    @Modifying
    @Query("UPDATE StudentAssessmentEntity sa SET sa.deleted = true, sa.deletedAt = CURRENT_TIMESTAMP WHERE sa.id = :id")
    void softDeleteById(@Param("id") Long id);
}
