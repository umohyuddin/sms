package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.sclass.model.TimeTableEntity;
import com.smartsolutions.eschool.sclass.repository.SClassDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SClassService {
    private final SClassDao sClassDao;

    public SClassService(SClassDao pSClassDao) {
        this.sClassDao = pSClassDao;
    }

    public List<TimeTableEntity> getAll() {
        return sClassDao.findAll();
    }

    public TimeTableEntity getById(Long id) {
        return sClassDao.findById(id);
    }

    public List<TimeTableEntity> getByTeacherId(Long id) {
        return sClassDao.findByTeacherId(id);
    }

    public List<TimeTableEntity> getByCourseId(Long id) {
        return sClassDao.findByCourseId(id);
    }

    public String create(TimeTableEntity pTimeTableEntity) {
        return sClassDao.save(pTimeTableEntity) == 1 ? "Class created" : "Error creating Class";
    }

    public String update(TimeTableEntity pTimeTableEntity) {
        return sClassDao.update(pTimeTableEntity) == 1 ? "Class updated" : "Error updating Class";
    }

    public String delete(Long id) {
        return sClassDao.delete(id) == 1 ? "Class deleted" : "Error deleting Class";
    }
}
