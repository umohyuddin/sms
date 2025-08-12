package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.student.model.StudentAttendanceEntity;
import com.smartsolutions.eschool.student.repository.StudentAttendanceDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAttendanceService {

    private final StudentAttendanceDao studentAttendanceDao;
    public StudentAttendanceService(StudentAttendanceDao studentAttendanceDao) {
        this.studentAttendanceDao = studentAttendanceDao;
    }

    public List<StudentAttendanceEntity> getAll() {
        return studentAttendanceDao.findAll();
    }

    public StudentAttendanceEntity getById(Long id) {
        return studentAttendanceDao.findById(id);
    }
    public List<StudentAttendanceEntity> getByStudent(Long std_id) {
        return studentAttendanceDao.findByStudent(std_id);
    }

    public String create(StudentAttendanceEntity pStudentAttendanceEntity) {
        return studentAttendanceDao.save(pStudentAttendanceEntity) == 1 ? "Student Attendance created" : "Error creating Student Attendance";
    }

    public String update(StudentAttendanceEntity pStudentAttendanceEntity) {
        return studentAttendanceDao.update(pStudentAttendanceEntity) == 1 ? "Student Attendance updated" : "Error updating Student Attendance";
    }

    public String delete(Long id) {
        return studentAttendanceDao.delete(id) == 1 ? "Student Attendance deleted" : "Error deleting Student Attendance";
    }
}
