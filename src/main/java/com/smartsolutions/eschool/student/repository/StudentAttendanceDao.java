package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.FeeEntity;
import com.smartsolutions.eschool.student.model.StudentAttendanceEntity;

import java.util.List;

public interface StudentAttendanceDao {
    int save(StudentAttendanceEntity pStudentAttendanceEntity);
    int update(StudentAttendanceEntity pStudentAttendanceEntity);
    int delete(Long id);
    StudentAttendanceEntity findById(Long id);
    List<StudentAttendanceEntity> findAll();
    List<StudentAttendanceEntity> findByStudent(Long std_id);
}
