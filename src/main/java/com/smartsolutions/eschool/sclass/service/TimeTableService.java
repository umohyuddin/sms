package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.sclass.model.TimeTableEntity;
import com.smartsolutions.eschool.sclass.repository.TimeTableRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TimeTableService {
    private final TimeTableRepository timeTableRepository;

    public TimeTableService(TimeTableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }

    public List<TimeTableEntity> getAll() {
        return timeTableRepository.findAll();
    }

    public TimeTableEntity getById(Long id) {
        return timeTableRepository.findById(id).orElse(null);
    }

    public List<TimeTableEntity> getByTeacherId(Long id) {
        return timeTableRepository.findByTeacherId(id);
    }

    public List<TimeTableEntity> getByClassId(Integer id) {
        return timeTableRepository.findByClsId(id);
    }

    @Transactional
    public String create(TimeTableEntity pTimeTableEntity) {
        timeTableRepository.save(pTimeTableEntity);
        return "TimeTable created";
    }

    @Transactional
    public String update(TimeTableEntity pTimeTableEntity) {
        timeTableRepository.save(pTimeTableEntity);
        return "TimeTable updated";
    }

    @Transactional
    public String delete(Long id) {
        timeTableRepository.deleteById(id);
        return "TimeTable deleted";
    }
}
