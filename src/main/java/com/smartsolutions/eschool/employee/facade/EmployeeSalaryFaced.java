package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.model.EmployeeSalaryEntity;
import com.smartsolutions.eschool.employee.service.EmployeeSalaryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class EmployeeSalaryFaced {

    private static final Log LOG = LogFactory.getLog(EmployeeSalaryFaced.class);
    @Autowired
    @Lazy
    private EmployeeSalaryService employeeSalaryService;


    public List<EmployeeSalaryEntity> getAll() {
        return employeeSalaryService.getAll();
    }
    public EmployeeSalaryEntity getById(Long id) {
        return employeeSalaryService.getById(id);
    }

    public List<EmployeeSalaryEntity> getByEmpId(Long emp_id) {
        return employeeSalaryService.getByEmpId(emp_id);
    }


    public String create(EmployeeSalaryEntity employeeSalaryEntity) {
        return employeeSalaryService.create(employeeSalaryEntity);
    }

    public String update(EmployeeSalaryEntity employeeSalaryEntity) {
        return employeeSalaryService.update(employeeSalaryEntity);
    }
    public String delete(Long id) {
        return employeeSalaryService.delete(id);
    }
}
