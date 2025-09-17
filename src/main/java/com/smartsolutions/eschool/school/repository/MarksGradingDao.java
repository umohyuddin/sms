package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.MarksGradingEntity;

import java.util.List;

public interface MarksGradingDao {
    int save(MarksGradingEntity pMarksGradingEntity);
    int update(MarksGradingEntity pMarksGradingEntity);
    int delete(Long id);
    MarksGradingEntity findById(Long id);
    List<MarksGradingEntity> findByInstitute(Long id);
    List<MarksGradingEntity> findAll();
}
