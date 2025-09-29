package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.ResultEntity;
import com.smartsolutions.eschool.sclass.model.SClassEntity;

import java.util.List;

public interface ResultDao {

    int save(ResultEntity pResultEntity);
    int update(ResultEntity pResultEntity);
    int delete(Long id);
    ResultEntity findById(Long id);
    List<ResultEntity> findAll();
    List<ResultEntity> findByClassId(Long id);
    List<ResultEntity> findBySubjectId(Long id);
    List<ResultEntity> findByStudentId(Long id);
}
