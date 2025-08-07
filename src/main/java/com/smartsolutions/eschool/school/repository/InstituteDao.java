package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteEntity;

import java.util.List;

public interface InstituteDao {
    int save(InstituteEntity pInstituteEntity);
    int update(InstituteEntity pInstituteEntity);
    int delete(Long id);
    InstituteEntity findById(Long id);
    List<InstituteEntity> findAll();
}
