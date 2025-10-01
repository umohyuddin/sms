package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.SubjectEntity;

import java.util.List;

public interface SubjectDao {
    int save(SubjectEntity pSubjectEntity);
    int update(SubjectEntity pSubjectEntity);
    int delete(Long id);
    SubjectEntity findById(Long id);
    List<SubjectEntity> findAll();
    List<SubjectEntity> findByTeacherId(Long id);
    List<SubjectEntity> findByClassId(Long id);
}
