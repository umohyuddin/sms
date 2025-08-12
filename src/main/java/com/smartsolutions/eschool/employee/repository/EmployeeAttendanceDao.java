package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeAttendanceEntity;

import java.util.List;

public interface EmployeeAttendanceDao {
    int save(EmployeeAttendanceEntity employeeAttendanceEntity);
    int update(EmployeeAttendanceEntity employeeAttendanceEntity);
    int delete(Long id);
    EmployeeAttendanceEntity findById(Long id);
    List<EmployeeAttendanceEntity> findAll();
    List<EmployeeAttendanceEntity> findByEmpId(Long emp_id);
}
