package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.school.model.InventoryEntity;
import com.smartsolutions.eschool.school.repository.InventoryDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
public class InventoryService {

    private final InventoryDao nInventoryDao;

    public InventoryService(InventoryDao pInventoryDao) {
        this.nInventoryDao = pInventoryDao;
    }


    public List<InventoryEntity> getAll() {
        log.info("Fetching all Inventory items from database");
        try {
            List<InventoryEntity> result = nInventoryDao.findAll();
            log.info("Successfully fetched {} Inventory items", result.size());
            return result;
        } catch (Exception e) {
            log.error("Unexpected error while fetching all Inventory items", e);
            throw new CustomServiceException("Failed to fetch all Inventory items");
        }
    }

    public List<InventoryEntity> findByCampus(Long id) {
        log.info("Fetching Inventory items for campus ID: {} from database", id);
        try {
            List<InventoryEntity> result = nInventoryDao.findByCampus(id);
            log.info("Successfully fetched {} Inventory items for campus ID: {}", result.size(), id);
            return result;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Inventory items for campus ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch Inventory items by campus");
        }
    }

    public List<InventoryEntity> findByInstitute(Long id) {
        log.info("Fetching Inventory items for institute ID: {} from database", id);
        try {
            List<InventoryEntity> result = nInventoryDao.findByInstitute(id);
            log.info("Successfully fetched {} Inventory items for institute ID: {}", result.size(), id);
            return result;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Inventory items for institute ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch Inventory items by institute");
        }
    }

    public InventoryEntity getById(Long id) {
        log.info("Fetching Inventory item with ID: {} from database", id);
        try {
            InventoryEntity result = nInventoryDao.findById(id);
            if (result != null) {
                log.info("Successfully fetched Inventory item: id={}", result.getId());
            } else {
                log.warn("Inventory item not found with ID: {}", id);
            }
            return result;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Inventory item ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch Inventory item by ID");
        }
    }

    @Transactional
    public String create(InventoryEntity pInventoryEntity) {
        log.info("Creating new Inventory item in database: {}", pInventoryEntity.getItemName());
        try {
            int result = nInventoryDao.save(pInventoryEntity);
            if (result == 1) {
                log.info("Inventory item saved successfully with ID: {}", pInventoryEntity.getId());
                return "Inventory created";
            }
            log.warn("Failed to create Inventory item: {}", pInventoryEntity.getItemName());
            return "Error creating Inventory";
        } catch (Exception e) {
            log.error("Unexpected error while creating Inventory item", e);
            throw new CustomServiceException("Failed to create Inventory item");
        }
    }

    @Transactional
    public String update(InventoryEntity pInventoryEntity) {
        log.info("Updating Inventory item with ID: {} in database", pInventoryEntity.getId());
        try {
            int result = nInventoryDao.update(pInventoryEntity);
            if (result == 1) {
                log.info("Inventory item updated successfully with ID: {}", pInventoryEntity.getId());
                return "Inventory updated";
            }
            log.warn("Failed to update Inventory item ID: {}", pInventoryEntity.getId());
            return "Error updating Inventory";
        } catch (Exception e) {
            log.error("Unexpected error while updating Inventory item ID: {}", pInventoryEntity.getId(), e);
            throw new CustomServiceException("Failed to update Inventory item");
        }
    }

    @Transactional
    public String delete(Long id) {
        log.info("Deleting Inventory item with ID: {} from database", id);
        try {
            int result = nInventoryDao.delete(id);
            if (result == 1) {
                log.info("Inventory item deleted successfully with ID: {}", id);
                return "Inventory deleted";
            }
            log.warn("Failed to delete Inventory item ID: {}", id);
            return "Error deleting Inventory";
        } catch (Exception e) {
            log.error("Unexpected error while deleting Inventory item ID: {}", id, e);
            throw new CustomServiceException("Failed to delete Inventory item");
        }
    }

    public List<InventoryEntity> searchByKeyword(String keyword) {
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("Fetching Inventory items based on search from database with keyword: '{}'", searchKey);
        try {
            List<InventoryEntity> result = nInventoryDao.searchByKeyword(searchKey);
            log.info("Successfully fetched {} Inventory items based on search", result.size());
            return result;
        } catch (Exception e) {
            log.error("Unexpected error while searching Inventory items", e);
            throw new CustomServiceException("Failed to search Inventory items");
        }
    }
}
