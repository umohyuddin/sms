package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.sclass.service.EnrollmentService;
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

    public List<SClassEntity> getAll() {
        return enrollmentService.getAll();
    }

    public SClassEntity getById(Long id) {
        return enrollmentService.getById(id);
    }

    public List<SClassEntity> getByTeacherId(Long id) {
        return enrollmentService.getByTeacherId(id);
    }

    public List<SClassEntity> getByCourseId(Long id) {
        return enrollmentService.getByCourseId(id);
    }

    public List<SClassEntity> getByStudentId(Long id) {
        return enrollmentService.getByStudentId(id);
    }

    public String create(SClassEntity pSClassEntity) {
        return enrollmentService.create(pSClassEntity);
    }

    public String update(SClassEntity pSClassEntity) {
        return enrollmentService.update(pSClassEntity);
    }

    public String delete(Long id) {
        return enrollmentService.delete(id);
    }
}
