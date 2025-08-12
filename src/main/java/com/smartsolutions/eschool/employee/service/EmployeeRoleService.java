package com.smartsolutions.eschool.employee.service;

import com.smartsolutions.eschool.employee.model.EmployeeRoleEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeRoleDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRoleService {

    private final EmployeeRoleDao employeeRoleDao;

    public EmployeeRoleService(EmployeeRoleDao employeeRoleDao) {
        this.employeeRoleDao = employeeRoleDao;
    }


    public List<EmployeeRoleEntity> getAll() {
        return employeeRoleDao.findAll();
    }

    public EmployeeRoleEntity getById(Long id) {
        return employeeRoleDao.findById(id);
    }

    public String create(EmployeeRoleEntity employeeRoleEntity) {
        return employeeRoleDao.save(employeeRoleEntity) == 1 ? "Role created" : "Error creating Role";
    }

    public String update(EmployeeRoleEntity employeeRoleEntity) {
        return employeeRoleDao.update(employeeRoleEntity) == 1 ? "Role updated" : "Error updating Role";
    }

    public String delete(Long id) {
        return employeeRoleDao.delete(id) == 1 ? "Role deleted" : "Error deleting Role";
    }
}
