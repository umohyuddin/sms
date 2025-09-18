package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.SClassEntity;

import java.util.List;

public interface EnrollmentDao {
    int save(SClassEntity pSClassEntity);
    int update(SClassEntity pSClassEntity);
    int delete(Long id);
    SClassEntity findById(Long id);
    List<SClassEntity> findAll();
    List<SClassEntity> findByTeacherId(Long id);
    List<SClassEntity> findByCourseId(Long id);
    List<SClassEntity> findByStudentId(Long id);
}
