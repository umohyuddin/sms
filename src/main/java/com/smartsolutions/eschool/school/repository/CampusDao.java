package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.CampusEntity;

import java.util.List;

public interface CampusDao {

    int save(CampusEntity pCampusEntity);
    int update(CampusEntity pCampusEntity);
    int delete(Long id);
    CampusEntity findById(Long id);
    List<CampusEntity> findAll();
}
