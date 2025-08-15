package com.smartsolutions.eschool.course.repository;

import com.smartsolutions.eschool.course.model.CourseEntity;
import com.smartsolutions.eschool.course.model.EnrollmentEntity;

import java.util.List;

public interface EnrollmentDao {
    int save(EnrollmentEntity pEnrollmentEntity);
    int update(EnrollmentEntity pEnrollmentEntity);
    int delete(Long id);
    EnrollmentEntity findById(Long id);
    List<EnrollmentEntity> findAll();
    List<EnrollmentEntity> findByTeacherId(Long id);
    List<EnrollmentEntity> findByCourseId(Long id);
    List<EnrollmentEntity> findByStudentId(Long id);
}
