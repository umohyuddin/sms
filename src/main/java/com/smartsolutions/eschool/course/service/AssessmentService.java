package com.smartsolutions.eschool.course.service;

import com.smartsolutions.eschool.course.model.AssessmentEntity;
import com.smartsolutions.eschool.course.repository.AssessmentDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    private final AssessmentDao assessmentDao;

    public AssessmentService(AssessmentDao pAssessmentDao) {
        this.assessmentDao = pAssessmentDao;
    }


    public List<AssessmentEntity> getAll() {
        return assessmentDao.findAll();
    }

    public AssessmentEntity getById(Long id) {
        return assessmentDao.findById(id);
    }

    public List<AssessmentEntity> getByCourseId(Long id) {
        return assessmentDao.findByCourseId(id);
    }

    public List<AssessmentEntity> getByStudentId(Long id) {
        return assessmentDao.findByStudentId(id);
    }

    public List<AssessmentEntity> getStudentWithinCourse(Long std_id, Long course_id ) {
        return assessmentDao.findStudentWithinCourse(std_id, course_id);
    }

    public String create(AssessmentEntity pAssessmentEntity) {
        return assessmentDao.save(pAssessmentEntity) == 1 ? "Assessment created" : "Error creating Assessment";
    }

    public String update(AssessmentEntity pAssessmentEntity) {
        return assessmentDao.update(pAssessmentEntity) == 1 ? "Assessment updated" : "Error updating Assessment";
    }

    public String delete(Long id) {
        return assessmentDao.delete(id) == 1 ? "Assessment deleted" : "Error deleting Assessment";
    }
}
