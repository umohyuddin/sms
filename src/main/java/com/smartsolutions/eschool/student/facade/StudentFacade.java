package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.employee.facade.EmployeeFacade;
import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import com.smartsolutions.eschool.employee.service.EmployeeService;
import com.smartsolutions.eschool.student.model.FeeEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.service.FeeService;
import com.smartsolutions.eschool.student.service.StudentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class StudentFacade {

    private static final Log LOG = LogFactory.getLog(StudentFacade.class);
    @Autowired
    @Lazy
    private StudentService studentService;


    public List<StudentEntity> getAll() {
        return studentService.getAll();
    }
    public StudentEntity getById(Long id) {
        return studentService.getById(id);
    }

    public List<StudentEntity> getByInstitute(Long inst_id) {
        return studentService.getByInstitute(inst_id);
    }
    public List<StudentEntity> getByCampus(Long cmp_id) {
        return studentService.getByCampus(cmp_id);
    }

    public String create(StudentEntity pStudentEntity) {
        return studentService.create(pStudentEntity);
    }

    public String update(StudentEntity pStudentEntity) {
        return studentService.update(pStudentEntity);
    }
    public String delete(Long id) {
        return studentService.delete(id);
    }
}
