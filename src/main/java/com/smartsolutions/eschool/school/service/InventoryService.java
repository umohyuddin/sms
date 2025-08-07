package com.smartsolutions.eschool.school.service;
import com.smartsolutions.eschool.school.model.InventoryEntity;
import com.smartsolutions.eschool.school.repository.InventoryDao;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InventoryService {

    private final InventoryDao nInventoryDao;

    public InventoryService(InventoryDao pInventoryDao) {
        this.nInventoryDao = pInventoryDao;
    }


    public List<InventoryEntity> getAll() {
        return nInventoryDao.findAll();
    }

    public List<InventoryEntity> findByCampus(Long id) {
        return nInventoryDao.findByCampus(id);
    }

    public List<InventoryEntity> findByInstitute(Long id) {
        return nInventoryDao.findByInstitute(id);
    }

    public InventoryEntity getById(Long id) {
        return nInventoryDao.findById(id);
    }

    public String create(InventoryEntity pInventoryEntity) {
        return nInventoryDao.save(pInventoryEntity) == 1 ? "Inventory created" : "Error creating Inventory";
    }

    public String update(InventoryEntity pInventoryEntity) {
        return nInventoryDao.update(pInventoryEntity) == 1 ? "Inventory updated" : "Error updating Inventory";
    }

    public String delete(Long id) {
        return nInventoryDao.delete(id) == 1 ? "Inventory deleted" : "Error deleting Inventory";
    }
}
