package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.AssessmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<AssessmentEntity, Long> {

    List<AssessmentEntity> findByStudentId(Long studentId);

    List<AssessmentEntity> findBySubjectId(Integer subjectId);

    @org.springframework.data.jpa.repository.Query("SELECT a FROM AssessmentEntity a WHERE a.classId = :classId")
    List<AssessmentEntity> findByClsId(@org.springframework.data.repository.query.Param("classId") Integer classId);

    @Query("SELECT a FROM AssessmentEntity a WHERE a.studentId = :studentId AND a.subjectId = :subjectId")
    List<AssessmentEntity> findStudentWithinCourse(@Param("studentId") Long studentId, @Param("subjectId") Integer subjectId);
    
    // Note: Assuming sbj_id in AssessmentEntity maps to subjectId
    @Query("SELECT a FROM AssessmentEntity a WHERE a.subjectId = :courseId")
    List<AssessmentEntity> findByCourseId(@Param("courseId") Integer courseId);
}
