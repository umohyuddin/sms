package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.sclass.repository.EnrollmentDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentDao enrollmentDao;

    public EnrollmentService(EnrollmentDao pEnrollmentDao) {
        this.enrollmentDao = pEnrollmentDao;
    }

    public List<SClassEntity> getAll() {
        return enrollmentDao.findAll();
    }

    public SClassEntity getById(Long id) {
        return enrollmentDao.findById(id);
    }

    public List<SClassEntity> getByTeacherId(Long id) {
        return enrollmentDao.findByTeacherId(id);
    }

    public List<SClassEntity> getByCourseId(Long id) {
        return enrollmentDao.findByCourseId(id);
    }

    public List<SClassEntity> getByStudentId(Long id) {
        return enrollmentDao.findByStudentId(id);
    }

    public String create(SClassEntity pSClassEntity) {
        return enrollmentDao.save(pSClassEntity) == 1 ? "Enrollment created" : "Error creating Enrollment";
    }

    public String update(SClassEntity pSClassEntity) {
        return enrollmentDao.update(pSClassEntity) == 1 ? "Enrollment updated" : "Error updating Enrollment";
    }

    public String delete(Long id) {
        return enrollmentDao.delete(id) == 1 ? "Enrollment deleted" : "Error deleting Enrollment";
    }
}
