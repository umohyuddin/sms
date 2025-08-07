package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InventoryEntity;

import java.util.List;

public interface InventoryDao {

    int save(InventoryEntity pInventoryEntity);
    int update(InventoryEntity pInventoryEntity);
    int delete(Long id);
    InventoryEntity findById(Long id);
    List<InventoryEntity> findByCampus(Long id);
    List<InventoryEntity> findByInstitute(Long id);
    List<InventoryEntity> findAll();
}
