package com.smartsolutions.eschool.course.facade;

import com.smartsolutions.eschool.course.model.EnrollmentEntity;
import com.smartsolutions.eschool.course.service.EnrollmentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class EnrollmentFacade {

    private static final Log LOG = LogFactory.getLog(CourseFacade.class);
    @Autowired
    @Lazy
    private EnrollmentService enrollmentService;

    public List<EnrollmentEntity> getAll() {
        return enrollmentService.getAll();
    }

    public EnrollmentEntity getById(Long id) {
        return enrollmentService.getById(id);
    }

    public List<EnrollmentEntity> getByTeacherId(Long id) {
        return enrollmentService.getByTeacherId(id);
    }

    public List<EnrollmentEntity> getByCourseId(Long id) {
        return enrollmentService.getByCourseId(id);
    }

    public List<EnrollmentEntity> getByStudentId(Long id) {
        return enrollmentService.getByStudentId(id);
    }

    public String create(EnrollmentEntity pEnrollmentEntity) {
        return enrollmentService.create(pEnrollmentEntity);
    }

    public String update(EnrollmentEntity pEnrollmentEntity) {
        return enrollmentService.update(pEnrollmentEntity);
    }

    public String delete(Long id) {
        return enrollmentService.delete(id);
    }
}
