package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.FailCriteriaEntity;

import java.util.List;

public interface FailCriteriaDao {

    int save(FailCriteriaEntity pFailCriteriaEntity);
    int update(FailCriteriaEntity pFailCriteriaEntity);
    int delete(Long id);
    FailCriteriaEntity findById(Long id);
    List<FailCriteriaEntity> findByInstitute(Long id);
    List<FailCriteriaEntity> findAll();

}
