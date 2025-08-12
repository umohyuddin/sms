package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    public List<EmployeeEntity> getAll() {
        return employeeDao.findAll();
    }

    public EmployeeEntity getById(Long id) {
        return employeeDao.findById(id);
    }
    public List<EmployeeEntity> getByCampus(Long campus_id) {
        return employeeDao.findByCampus(campus_id);
    }

    public List<EmployeeEntity> getByInstitute(Long institute_id) {
        return employeeDao.findByInstitute(institute_id);
    }

    public String create(EmployeeEntity employeeEntity) {
        return employeeDao.save(employeeEntity) == 1 ? "Employee created" : "Error creating Employee";
    }

    public String update(EmployeeEntity employeeEntity) {
        return employeeDao.update(employeeEntity) == 1 ? "Employee updated" : "Error updating Employee";
    }

    public String delete(Long id) {
        return employeeDao.delete(id) == 1 ? "Employee deleted" : "Error deleting Employee";
    }
}
