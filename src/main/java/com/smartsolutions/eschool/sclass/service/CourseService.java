package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.sclass.model.SubjectEntity;
import com.smartsolutions.eschool.sclass.repository.CourseDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseDao courseDao;

    public CourseService(CourseDao pCourseDao) {
        this.courseDao = pCourseDao;
    }

    public List<SubjectEntity> getAll() {
        return courseDao.findAll();
    }

    public SubjectEntity getById(Long id) {
        return courseDao.findById(id);
    }

    public List<SubjectEntity> getByTeacherId(Long id) {
        return courseDao.findByTeacherId(id);
    }

    public List<SubjectEntity> getByDepartmentId(Long id) {
        return courseDao.findByDepartmentId(id);
    }

    public String create(SubjectEntity pSubjectEntity) {
        return courseDao.save(pSubjectEntity) == 1 ? "Course created" : "Error creating Course";
    }

    public String update(SubjectEntity pSubjectEntity) {
        return courseDao.update(pSubjectEntity) == 1 ? "Course updated" : "Error updating Course";
    }

    public String delete(Long id) {
        return courseDao.delete(id) == 1 ? "Course deleted" : "Error deleting Course";
    }
}
