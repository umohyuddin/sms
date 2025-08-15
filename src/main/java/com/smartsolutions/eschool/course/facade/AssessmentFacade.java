package com.smartsolutions.eschool.course.facade;

import com.smartsolutions.eschool.course.model.AssessmentEntity;
import com.smartsolutions.eschool.course.service.AssessmentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class AssessmentFacade {

    private static final Log LOG = LogFactory.getLog(AssessmentFacade.class);
    @Autowired
    @Lazy
    private AssessmentService assessmentService;

    public List<AssessmentEntity> getAll() {
        return assessmentService.getAll();
    }

    public AssessmentEntity getById(Long id) {
        return assessmentService.getById(id);
    }

    public List<AssessmentEntity> getByCourseId(Long id) {
        return assessmentService.getByCourseId(id);
    }

    public List<AssessmentEntity> getByStudentId(Long id) {
        return assessmentService.getByStudentId(id);
    }

    public List<AssessmentEntity> getStudentWithinCourse(Long std_id, Long course_id ) {
        return assessmentService.getStudentWithinCourse(std_id, course_id);
    }

    public String create(AssessmentEntity pAssessmentEntity) {
        return assessmentService.create(pAssessmentEntity);
    }

    public String update(AssessmentEntity pAssessmentEntity) {
        return assessmentService.update(pAssessmentEntity);
    }

    public String delete(Long id) {
        return assessmentService.delete(id);
    }
}
