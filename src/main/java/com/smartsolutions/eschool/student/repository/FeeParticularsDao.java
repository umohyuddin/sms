package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.FeeParticularsEntity;


import java.util.List;

public interface FeeParticularsDao {
    int save(FeeParticularsEntity pFeeParticularsEntity);
    int update(FeeParticularsEntity pFeeParticularsEntity);
    int delete(Long id);
    FeeParticularsEntity findById(Long id);
    List<FeeParticularsEntity> findAll();
    List<FeeParticularsEntity> findByInstitute(Long id);
}
