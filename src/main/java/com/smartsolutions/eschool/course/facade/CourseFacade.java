package com.smartsolutions.eschool.course.facade;

import com.smartsolutions.eschool.course.model.CourseEntity;
import com.smartsolutions.eschool.course.service.CourseService;
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

    public List<CourseEntity> getAll() {
        return courseService.getAll();
    }

    public CourseEntity getById(Long id) {
        return courseService.getById(id);
    }

    public List<CourseEntity> getByTeacherId(Long id) {
        return courseService.getByTeacherId(id);
    }

    public List<CourseEntity> getByDepartmentId(Long id) {
        return courseService.getByDepartmentId(id);
    }

    public String create(CourseEntity pCourseEntity) {
        return courseService.create(pCourseEntity);
    }

    public String update(CourseEntity pCourseEntity) {
        return courseService.update(pCourseEntity);
    }

    public String delete(Long id) {
        return courseService.delete(id);
    }
}
