package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.sclass.model.TimeTableEntity;
import com.smartsolutions.eschool.sclass.repository.TimeTableDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeTableService {
    private final TimeTableDao timeTableDao;

    public TimeTableService(TimeTableDao pTimeTableDao) {
        this.timeTableDao = pTimeTableDao;
    }

    public List<TimeTableEntity> getAll() {
        return timeTableDao.findAll();
    }

    public TimeTableEntity getById(Long id) {
        return timeTableDao.findById(id);
    }

    public List<TimeTableEntity> getByTeacherId(Long id) {
        return timeTableDao.findByTeacherId(id);
    }

    public List<TimeTableEntity> getByCourseId(Long id) {
        return timeTableDao.findByCourseId(id);
    }

    public String create(TimeTableEntity pTimeTableEntity) {
        return timeTableDao.save(pTimeTableEntity) == 1 ? "TimeTable created" : "Error creating TimeTable";
    }

    public String update(TimeTableEntity pTimeTableEntity) {
        return timeTableDao.update(pTimeTableEntity) == 1 ? "TimeTable updated" : "Error updating TimeTable";
    }

    public String delete(Long id) {
        return timeTableDao.delete(id) == 1 ? "TimeTable deleted" : "Error deleting TimeTable";
    }
}
