package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeRoleEntity;

import java.util.List;

public interface EmployeeRoleDao {

    int save(EmployeeRoleEntity employeeRoleEntity);
    int update(EmployeeRoleEntity employeeRoleEntity);
    int delete(Long id);
    EmployeeRoleEntity findById(Long id);
    List<EmployeeRoleEntity> findAll();
}
