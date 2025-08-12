package com.smartsolutions.eschool.student.facade;


import com.smartsolutions.eschool.student.model.StudentAttendanceEntity;
import com.smartsolutions.eschool.student.service.StudentAttendanceService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class StudentAttendanceFacade {

    private static final Log LOG = LogFactory.getLog(StudentAttendanceFacade.class);
    @Autowired
    @Lazy
    private StudentAttendanceService studentAttendanceService;


    public List<StudentAttendanceEntity> getAll() {
        return studentAttendanceService.getAll();
    }
    public StudentAttendanceEntity getById(Long id) {
        return studentAttendanceService.getById(id);
    }

    public List<StudentAttendanceEntity> getByStudent(Long std_id) {
        return studentAttendanceService.getByStudent(std_id);
    }

    public String create(StudentAttendanceEntity pStudentAttendanceEntity) {
        return studentAttendanceService.create(pStudentAttendanceEntity);
    }

    public String update(StudentAttendanceEntity pStudentAttendanceEntity) {
        return studentAttendanceService.update(pStudentAttendanceEntity);
    }
    public String delete(Long id) {
        return studentAttendanceService.delete(id);
    }
}
