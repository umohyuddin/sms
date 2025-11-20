package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;

import java.util.List;

public interface StandardDao {
    int save(StandardEntity standardEntity);
    int update(StandardEntity standardEntity);
    int delete(Long id);
    StandardEntity findById(Long id);
    List<StandardEntity> findAll();
//    List<SClassEntity> findByTeacherId(Long id);
//    List<SClassEntity> findByCourseId(Long id);
//    List<SClassEntity> findByStudentId(Long id);
}
