package com.smartsolutions.eschool.employee.facade;


import com.smartsolutions.eschool.employee.model.EmployeeAttendanceEntity;
import com.smartsolutions.eschool.employee.service.EmployeeAttendanceService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class EmployeeAttendanceFacade {

    private static final Log LOG = LogFactory.getLog(EmployeeAttendanceFacade.class);
    @Autowired
    @Lazy
    private EmployeeAttendanceService employeeAttendanceService;


    public List<EmployeeAttendanceEntity> getAll() {
        return employeeAttendanceService.getAll();
    }
    public EmployeeAttendanceEntity getById(Long id) {
        return employeeAttendanceService.getById(id);
    }

    public List<EmployeeAttendanceEntity> getByEmpId(Long emp_id) {
        return employeeAttendanceService.getByEmpId(emp_id);
    }

    public String create(EmployeeAttendanceEntity employeeAttendanceEntity) {
        return employeeAttendanceService.create(employeeAttendanceEntity);
    }

    public String update(EmployeeAttendanceEntity employeeAttendanceEntity) {
        return employeeAttendanceService.update(employeeAttendanceEntity);
    }
    public String delete(Long id) {
        return employeeAttendanceService.delete(id);
    }
}
