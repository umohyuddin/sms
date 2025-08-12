package com.smartsolutions.eschool.student.repository;

import com.smartsolutions.eschool.student.model.StudentEntity;

import java.util.List;

public interface StudentDao {
    int save(StudentEntity pStudentEntity);
    int update(StudentEntity pStudentEntity);
    int delete(Long id);
    StudentEntity findById(Long id);
    List<StudentEntity> findAll();
    List<StudentEntity> findByCampus(Long cmp_id);
    List<StudentEntity> findByInstitute(Long inst_id);
}