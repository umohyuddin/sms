package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import com.smartsolutions.eschool.employee.service.EmployeeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class EmployeeFacade {

    private static final Log LOG = LogFactory.getLog(EmployeeFacade.class);
    @Autowired
    @Lazy
    private EmployeeService employeeService;


    public List<EmployeeEntity> getAll() {
        return employeeService.getAll();
    }
    public EmployeeEntity getById(Long id) {
        return employeeService.getById(id);
    }

    public List<EmployeeEntity> getByCampus(Long campus_id) {
        return employeeService.getByCampus(campus_id);
    }

    public List<EmployeeEntity> getByInstitute(Long institute_id) {
        return employeeService.getByInstitute(institute_id);
    }

    public String create(EmployeeEntity employeeEntity) {
        return employeeService.create(employeeEntity);
    }

    public String update(EmployeeEntity employeeEntity) {
        return employeeService.update(employeeEntity);
    }
    public String delete(Long id) {
        return employeeService.delete(id);
    }
}
