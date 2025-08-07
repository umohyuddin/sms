package com.smartsolutions.eschool.employee.facade;

import com.smartsolutions.eschool.employee.model.EmployeeRoleEntity;
import com.smartsolutions.eschool.employee.service.EmployeeRoleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class EmployeeRoleFacade {

    private static final Log LOG = LogFactory.getLog(EmployeeRoleFacade.class);
    @Autowired
    @Lazy
    private EmployeeRoleService employeeRoleService;


    public List<EmployeeRoleEntity> getAll() {
        return employeeRoleService.getAll();
    }
    public EmployeeRoleEntity getById(Long id) {
        return employeeRoleService.getById(id);
    }


    public String create(EmployeeRoleEntity employeeRoleEntity) {
        return employeeRoleService.create(employeeRoleEntity);
    }

    public String update(EmployeeRoleEntity employeeRoleEntity) {
        return employeeRoleService.update(employeeRoleEntity);
    }
    public String delete(Long id) {
        return employeeRoleService.delete(id);
    }
}
