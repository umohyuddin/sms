package com.smartsolutions.eschool.employee.repository.sql;


import com.smartsolutions.eschool.employee.model.EmployeeEntity;

import java.util.List;

public interface EmployeeDao {

    int save(EmployeeEntity employeeEntity);
    int update(EmployeeEntity employeeEntity);
    int delete(Long id);
    EmployeeEntity findById(Long id);
    List<EmployeeEntity> findAll();
    List<EmployeeEntity> findByCampus(Long campus_id);
    List<EmployeeEntity> findByInstitute(Long institute_id);

}
