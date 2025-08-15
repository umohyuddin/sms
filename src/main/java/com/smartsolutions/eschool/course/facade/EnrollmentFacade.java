package com.smartsolutions.eschool.course.facade;

import com.smartsolutions.eschool.course.model.EnrollmentEntity;
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
    private EnrollmentFacade enrollmentFacade;

    public List<EnrollmentEntity> getAll() {
        return enrollmentFacade.getAll();
    }

    public EnrollmentEntity getById(Long id) {
        return enrollmentFacade.getById(id);
    }

    public List<EnrollmentEntity> getByTeacherId(Long id) {
        return enrollmentFacade.getByTeacherId(id);
    }

    public List<EnrollmentEntity> getByCourseId(Long id) {
        return enrollmentFacade.getByCourseId(id);
    }

    public List<EnrollmentEntity> getByStudentId(Long id) {
        return enrollmentFacade.getByStudentId(id);
    }

    public String create(EnrollmentEntity pEnrollmentEntity) {
        return enrollmentFacade.create(pEnrollmentEntity);
    }

    public String update(EnrollmentEntity pEnrollmentEntity) {
        return enrollmentFacade.update(pEnrollmentEntity);
    }

    public String delete(Long id) {
        return enrollmentFacade.delete(id);
    }
}
