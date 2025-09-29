package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.sclass.model.SubjectEntity;
import com.smartsolutions.eschool.sclass.repository.SubjectDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectDao subjectDao;

    public SubjectService(SubjectDao pSubjectDao) {
        this.subjectDao = pSubjectDao;
    }

    public List<SubjectEntity> getAll() {
        return subjectDao.findAll();
    }

    public SubjectEntity getById(Long id) {
        return subjectDao.findById(id);
    }

    public List<SubjectEntity> getByTeacherId(Long id) {
        return subjectDao.findByTeacherId(id);
    }

    public List<SubjectEntity> getByDepartmentId(Long id) {
        return subjectDao.findByDepartmentId(id);
    }

    public String create(SubjectEntity pSubjectEntity) {
        return subjectDao.save(pSubjectEntity) == 1 ? "Subject created" : "Error creating Subject";
    }

    public String update(SubjectEntity pSubjectEntity) {
        return subjectDao.update(pSubjectEntity) == 1 ? "Subject updated" : "Error updating Subject";
    }

    public String delete(Long id) {
        return subjectDao.delete(id) == 1 ? "Subject deleted" : "Error deleting Subject";
    }
}
