package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.MCQEntity;

import java.util.List;

public interface MCQDao {

    int save(MCQEntity pMCQEntity);
    int update(MCQEntity pMCQEntity);
    int delete(Long id);
    MCQEntity findById(Long id);
    List<MCQEntity> findAll();
    List<MCQEntity> findByChapter(Long sid, Long chp);
    List<MCQEntity> findBySubjectId(Long id);

}
