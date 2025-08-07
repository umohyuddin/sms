package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.model.EmployeeSalaryEntity;
import com.smartsolutions.eschool.employee.repository.sql.EmployeeSalaryDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSalaryService {
    private final EmployeeSalaryDao employeeSalaryDao;

    public EmployeeSalaryService(EmployeeSalaryDao employeeSalaryDao) {
        this.employeeSalaryDao = employeeSalaryDao;
    }


    public List<EmployeeSalaryEntity> getAll() {
        return employeeSalaryDao.findAll();
    }
    public List<EmployeeSalaryEntity> getByEmpId(Long emp_id) {
        return employeeSalaryDao.findByEmpId(emp_id);
    }

    public EmployeeSalaryEntity getById(Long id) {
        return employeeSalaryDao.findById(id);
    }

    public String create(EmployeeSalaryEntity employeeSalaryEntity) {
        return employeeSalaryDao.save(employeeSalaryEntity) == 1 ? "Salary created" : "Error creating Salary";
    }

    public String update(EmployeeSalaryEntity employeeSalaryEntity) {
        return employeeSalaryDao.update(employeeSalaryEntity) == 1 ? "Salary updated" : "Error updating Salary";
    }

    public String delete(Long id) {
        return employeeSalaryDao.delete(id) == 1 ? "Salary deleted" : "Error deleting Salary";
    }
}
