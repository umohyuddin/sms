package com.smartsolutions.eschool.course.service;

import com.smartsolutions.eschool.course.model.SClassEntity;
import com.smartsolutions.eschool.course.repository.SClassDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SClassService {
    private final SClassDao sClassDao;

    public SClassService(SClassDao pSClassDao) {
        this.sClassDao = pSClassDao;
    }

    public List<SClassEntity> getAll() {
        return sClassDao.findAll();
    }

    public SClassEntity getById(Long id) {
        return sClassDao.findById(id);
    }

    public List<SClassEntity> getByTeacherId(Long id) {
        return sClassDao.findByTeacherId(id);
    }

    public List<SClassEntity> getByCourseId(Long id) {
        return sClassDao.findByCourseId(id);
    }

    public String create(SClassEntity pSClassEntity) {
        return sClassDao.save(pSClassEntity) == 1 ? "Class created" : "Error creating Class";
    }

    public String update(SClassEntity pSClassEntity) {
        return sClassDao.update(pSClassEntity) == 1 ? "Class updated" : "Error updating Class";
    }

    public String delete(Long id) {
        return sClassDao.delete(id) == 1 ? "Class deleted" : "Error deleting Class";
    }
}
