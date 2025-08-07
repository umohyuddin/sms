package com.smartsolutions.eschool.employee.repository.sql;

import com.smartsolutions.eschool.employee.model.EmployeeSalaryEntity;

import java.util.List;

public interface EmployeeSalaryDao {

    int save(EmployeeSalaryEntity employeeSalaryEntity);
    int update(EmployeeSalaryEntity employeeSalaryEntity);
    int delete(Long id);
    EmployeeSalaryEntity findById(Long id);
    List<EmployeeSalaryEntity> findAll();
    List<EmployeeSalaryEntity> findByEmpId(Long emp_id);
}
