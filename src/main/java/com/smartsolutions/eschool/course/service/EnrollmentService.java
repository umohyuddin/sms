package com.smartsolutions.eschool.course.service;

import com.smartsolutions.eschool.course.model.EnrollmentEntity;
import com.smartsolutions.eschool.course.repository.EnrollmentDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentDao enrollmentDao;

    public EnrollmentService(EnrollmentDao pEnrollmentDao) {
        this.enrollmentDao = pEnrollmentDao;
    }

    public List<EnrollmentEntity> getAll() {
        return enrollmentDao.findAll();
    }

    public EnrollmentEntity getById(Long id) {
        return enrollmentDao.findById(id);
    }

    public List<EnrollmentEntity> getByTeacherId(Long id) {
        return enrollmentDao.findByTeacherId(id);
    }

    public List<EnrollmentEntity> getByCourseId(Long id) {
        return enrollmentDao.findByCourseId(id);
    }

    public List<EnrollmentEntity> getByStudentId(Long id) {
        return enrollmentDao.findByStudentId(id);
    }

    public String create(EnrollmentEntity pEnrollmentEntity) {
        return enrollmentDao.save(pEnrollmentEntity) == 1 ? "Enrollment created" : "Error creating Enrollment";
    }

    public String update(EnrollmentEntity pEnrollmentEntity) {
        return enrollmentDao.update(pEnrollmentEntity) == 1 ? "Enrollment updated" : "Error updating Enrollment";
    }

    public String delete(Long id) {
        return enrollmentDao.delete(id) == 1 ? "Enrollment deleted" : "Error deleting Enrollment";
    }
}
