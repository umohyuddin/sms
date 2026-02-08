package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.sclass.model.AssessmentEntity;
import com.smartsolutions.eschool.sclass.repository.AssessmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssessmentService {

    private final AssessmentRepository assessmentRepository;

    public AssessmentService(AssessmentRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }

    public List<AssessmentEntity> getAll() {
        return assessmentRepository.findAll();
    }

    public AssessmentEntity getById(Long id) {
        return assessmentRepository.findById(id).orElse(null);
    }

    public List<AssessmentEntity> getByCourseId(Integer id) {
        return assessmentRepository.findByCourseId(id);
    }

    public List<AssessmentEntity> getByStudentId(Long id) {
        return assessmentRepository.findByStudentId(id);
    }

    public List<AssessmentEntity> getStudentWithinCourse(Long std_id, Integer course_id ) {
        return assessmentRepository.findStudentWithinCourse(std_id, course_id);
    }

    @Transactional
    public String create(AssessmentEntity pAssessmentEntity) {
        assessmentRepository.save(pAssessmentEntity);
        return "Assessment created";
    }

    @Transactional
    public String update(AssessmentEntity pAssessmentEntity) {
        assessmentRepository.save(pAssessmentEntity);
        return "Assessment updated";
    }

    @Transactional
    public String delete(Long id) {
        assessmentRepository.deleteById(id);
        return "Assessment deleted";
    }
}
