package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.DepartmentEntity;

import java.util.List;

public interface DepartmentDao {
    int save(DepartmentEntity pDepartmentEntity);
    int update(DepartmentEntity pDepartmentEntity);
    int delete(Long id);
    DepartmentEntity findById(Long id);
    List<DepartmentEntity> findAll();
}
