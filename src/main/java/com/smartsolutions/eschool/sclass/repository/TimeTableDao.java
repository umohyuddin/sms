package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.TimeTableEntity;

import java.util.List;

public interface TimeTableDao {
    int save(TimeTableEntity pTimeTableEntity);
    int update(TimeTableEntity pTimeTableEntity);
    int delete(Long id);
    TimeTableEntity findById(Long id);
    List<TimeTableEntity> findAll();
    List<TimeTableEntity> findByTeacherId(Long id);
    List<TimeTableEntity> findByClassId(Long id);
}
