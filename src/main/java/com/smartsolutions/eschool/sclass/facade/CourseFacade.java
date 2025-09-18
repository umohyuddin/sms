package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.model.SubjectEntity;
import com.smartsolutions.eschool.sclass.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class CourseFacade {
    private static final Log LOG = LogFactory.getLog(CourseFacade.class);
    @Autowired
    @Lazy
    private CourseService courseService;

    public List<SubjectEntity> getAll() {
        return courseService.getAll();
    }

    public SubjectEntity getById(Long id) {
        return courseService.getById(id);
    }

    public List<SubjectEntity> getByTeacherId(Long id) {
        return courseService.getByTeacherId(id);
    }

    public List<SubjectEntity> getByDepartmentId(Long id) {
        return courseService.getByDepartmentId(id);
    }

    public String create(SubjectEntity pSubjectEntity) {
        return courseService.create(pSubjectEntity);
    }

    public String update(SubjectEntity pSubjectEntity) {
        return courseService.update(pSubjectEntity);
    }

    public String delete(Long id) {
        return courseService.delete(id);
    }
}
