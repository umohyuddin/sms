package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import com.smartsolutions.eschool.student.model.FeeEntity;

import java.util.List;

public interface FeeDao {
    int save(FeeEntity pFeeEntity);
    int update(FeeEntity pFeeEntity);
    int delete(Long id);
    FeeEntity findById(Long id);
    List<FeeEntity> findAll();
    List<FeeEntity> findByStudent(Long std_id);
}
