package com.smartsolutions.eschool.sclass.repository;

import com.smartsolutions.eschool.sclass.model.SectionEntity;

import java.util.List;

public interface SectionDao {
    int save(SectionEntity pSectionEntity);
    int update(SectionEntity pSectionEntity);
    int delete(Long id);
    SectionEntity findById(Long id);
    List<SectionEntity> findAll();
    List<SectionEntity> findByClassId(Long id);
    List<SectionEntity> findByCampusId(Long id);
    List<SectionEntity> findByInstituteId(Long id);
}
