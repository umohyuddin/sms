package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.sclass.repository.SClassDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SClassService {
    private final SClassDao SClassDao;

    public SClassService(SClassDao pSClassDao) {
        this.SClassDao = pSClassDao;
    }

    public List<SClassEntity> getAll() {
        return SClassDao.findAll();
    }

    public SClassEntity getById(Long id) {
        return SClassDao.findById(id);
    }

    public List<SClassEntity> getByTeacherId(Long id) {
        return SClassDao.findByTeacherId(id);
    }

    public List<SClassEntity> getByCourseId(Long id) {
        return SClassDao.findByCourseId(id);
    }

    public List<SClassEntity> getByStudentId(Long id) {
        return SClassDao.findByStudentId(id);
    }

    public String create(SClassEntity pSClassEntity) {
        return SClassDao.save(pSClassEntity) == 1 ? "class created" : "Error creating class";
    }

    public String update(SClassEntity pSClassEntity) {
        return SClassDao.update(pSClassEntity) == 1 ? "class updated" : "Error updating class";
    }

    public String delete(Long id) {
        return SClassDao.delete(id) == 1 ? "class deleted" : "Error deleting class";
    }
}
