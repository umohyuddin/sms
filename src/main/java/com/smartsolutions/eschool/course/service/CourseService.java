package com.smartsolutions.eschool.course.service;

import com.smartsolutions.eschool.course.model.CourseEntity;
import com.smartsolutions.eschool.course.repository.CourseDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseDao courseDao;

    public CourseService(CourseDao pCourseDao) {
        this.courseDao = pCourseDao;
    }

    public List<CourseEntity> getAll() {
        return courseDao.findAll();
    }

    public CourseEntity getById(Long id) {
        return courseDao.findById(id);
    }

    public List<CourseEntity> getByTeacherId(Long id) {
        return courseDao.findByTeacherId(id);
    }

    public List<CourseEntity> getByDepartmentId(Long id) {
        return courseDao.findByDepartmentId(id);
    }

    public String create(CourseEntity pCourseEntity) {
        return courseDao.save(pCourseEntity) == 1 ? "Course created" : "Error creating Course";
    }

    public String update(CourseEntity pCourseEntity) {
        return courseDao.update(pCourseEntity) == 1 ? "Course updated" : "Error updating Course";
    }

    public String delete(Long id) {
        return courseDao.delete(id) == 1 ? "Course deleted" : "Error deleting Course";
    }
}
