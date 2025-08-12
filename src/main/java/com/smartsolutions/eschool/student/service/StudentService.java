package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.StudentDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentDao studentDao;
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<StudentEntity> getAll() {
        return studentDao.findAll();
    }

    public StudentEntity getById(Long id) {
        return studentDao.findById(id);
    }
    public List<StudentEntity> getByCampus(Long campus_id) {
        return studentDao.findByCampus(campus_id);
    }

    public List<StudentEntity> getByInstitute(Long institute_id) {
        return studentDao.findByInstitute(institute_id);
    }

    public String create(StudentEntity pStudentEntity) {
        return studentDao.save(pStudentEntity) == 1 ? "Student created" : "Error creating Student";
    }

    public String update(StudentEntity pStudentEntity) {
        return studentDao.update(pStudentEntity) == 1 ? "Student updated" : "Error updating Student";
    }

    public String delete(Long id) {
        return studentDao.delete(id) == 1 ? "Student deleted" : "Error deleting Student";
    }

}
