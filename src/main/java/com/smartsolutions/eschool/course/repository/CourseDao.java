package com.smartsolutions.eschool.course.repository;

import com.smartsolutions.eschool.course.model.CourseEntity;

import java.util.List;

public interface CourseDao {
    int save(CourseEntity pCourseEntity);
    int update(CourseEntity pCourseEntity);
    int delete(Long id);
    CourseEntity findById(Long id);
    List<CourseEntity> findAll();
    List<CourseEntity> findByTeacherId(Long id);
    List<CourseEntity> findByDepartmentId(Long id);
}
