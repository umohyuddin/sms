package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.model.EmployeeAttendanceEntity;
import com.smartsolutions.eschool.employee.repository.sql.EmployeeAttendanceDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeAttendanceService {

    private final EmployeeAttendanceDao employeeAttendanceDao;

    public EmployeeAttendanceService(EmployeeAttendanceDao employeeAttendanceDao) {
        this.employeeAttendanceDao = employeeAttendanceDao;
    }


    public List<EmployeeAttendanceEntity> getAll() {
        return employeeAttendanceDao.findAll();
    }

    public EmployeeAttendanceEntity getById(Long id) {
        return employeeAttendanceDao.findById(id);
    }

    public List<EmployeeAttendanceEntity> getByEmpId(Long emp_id) {
        return employeeAttendanceDao.findByEmpId(emp_id);
    }

    public String create(EmployeeAttendanceEntity employeeAttendanceEntity) {
        return employeeAttendanceDao.save(employeeAttendanceEntity) == 1 ? "Attendance created" : "Error creating Attendance";
    }

    public String update(EmployeeAttendanceEntity employeeAttendanceEntity) {
        return employeeAttendanceDao.update(employeeAttendanceEntity) == 1 ? "Attendance updated" : "Error updating Attendance";
    }

    public String delete(Long id) {
        return employeeAttendanceDao.delete(id) == 1 ? "Attendance deleted" : "Error deleting Attendance";
    }
}
