package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.AssessmentEntity;
import java.util.List;

public interface AssessmentDao {
    int save(AssessmentEntity pAssessmentEntity);
    int update(AssessmentEntity pAssessmentEntity);
    int delete(Long id);
    AssessmentEntity findById(Long id);
    List<AssessmentEntity> findAll();
    List<AssessmentEntity> findByStudentId(Long std_id);
    List<AssessmentEntity> findByCourseId(Long course_id);
    List<AssessmentEntity> findStudentWithinCourse(Long std_id, Long course_id);
}
