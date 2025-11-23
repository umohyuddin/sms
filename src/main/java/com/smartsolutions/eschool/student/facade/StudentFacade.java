package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.model.StudentEntity;
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


    public List<StudentDTO> getAll() {
        return studentService.getAll();
    }

    public List<StudentDTO> getStudentsByCampus(Long campusId) {
        return studentService.getStudentsByCampus(campusId);
    }
    public List<StudentDTO> getStudentsByName(String studentName) {
        return studentService.getStudentsByName(studentName);
    }
    public List<StudentDTO> getStudentsByStandard(Long id) {
        return studentService.getStudentsByStandard(id);
    }
    public List<StudentDTO> getStudentsBySection(Long id) {
        return studentService.getStudentsBySection(id);
    }

    public StudentDTO getById(Long id) {
        return studentService.getById(id);
    }
    public StudentDTO getByStudentCode(String studentCode) {
        return studentService.getByStudentCode(studentCode);
    }






//    public List<StudentEntity> getByInstitute(Long inst_id) {
//        return studentService.getByInstitute(inst_id);
//    }
//    public List<StudentEntity> getByCampus(Long cmp_id) {
//        return studentService.getByCampus(cmp_id);
//    }
//
//    public String create(StudentEntity pStudentEntity) {
//        return studentService.create(pStudentEntity);
//    }
//
//    public String update(StudentEntity pStudentEntity) {
//        return studentService.update(pStudentEntity);
//    }
//    public String delete(Long id) {
//        return studentService.delete(id);
//    }
}
