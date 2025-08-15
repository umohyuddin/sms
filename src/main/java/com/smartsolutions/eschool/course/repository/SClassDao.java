package com.smartsolutions.eschool.course.repository;

import com.smartsolutions.eschool.course.model.CourseEntity;
import com.smartsolutions.eschool.course.model.SClassEntity;

import java.util.List;

public interface SClassDao {
    int save(SClassEntity pSClassEntity);
    int update(SClassEntity pSClassEntity);
    int delete(Long id);
    SClassEntity findById(Long id);
    List<SClassEntity> findAll();
    List<SClassEntity> findByTeacherId(Long id);
    List<SClassEntity> findByCourseId(Long id);
}
