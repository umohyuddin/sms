package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.model.InventoryEntity;
import java.util.List;
import com.smartsolutions.eschool.school.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Slf4j
public class InventoryFacade {
    private final InventoryService nInventoryService;

    public InventoryFacade(InventoryService pInventoryService) {
        this.nInventoryService = pInventoryService;
    }


    public List<InventoryEntity> getAll() {
        log.info("Facade: Request to fetch all Inventory items");
        List<InventoryEntity> result = nInventoryService.getAll();
        log.info("Facade: Successfully fetched {} Inventory items", result.size());
        return result;
    }

    public List<InventoryEntity> findByCampus(Long id) {
        log.info("Facade: Request to fetch Inventory items for campus ID: {}", id);
        List<InventoryEntity> result = nInventoryService.findByCampus(id);
        log.info("Facade: Successfully fetched {} Inventory items for campus ID: {}", result.size(), id);
        return result;
    }

    public List<InventoryEntity> findByInstitute(Long id) {
        log.info("Facade: Request to fetch Inventory items for institute ID: {}", id);
        List<InventoryEntity> result = nInventoryService.findByInstitute(id);
        log.info("Facade: Successfully fetched {} Inventory items for institute ID: {}", result.size(), id);
        return result;
    }

    public InventoryEntity getById(Long id) {
        log.info("Facade: Request to fetch Inventory item ID: {}", id);
        InventoryEntity result = nInventoryService.getById(id);
        log.info("Facade: Successfully fetched Inventory item ID: {}", id);
        return result;
    }

    public String create(InventoryEntity pInventoryEntity) {
        log.info("Facade: Request to create Inventory item: {}", pInventoryEntity.getItemName());
        String result = nInventoryService.create(pInventoryEntity);
        log.info("Facade: Create Inventory result: {}", result);
        return result;
    }

    public String update(InventoryEntity pInventoryEntity) {
        log.info("Facade: Request to update Inventory item ID: {}", pInventoryEntity.getId());
        String result = nInventoryService.update(pInventoryEntity);
        log.info("Facade: Update Inventory result: {}", result);
        return result;
    }

    public String delete(Long id) {
        log.info("Facade: Request to delete Inventory item ID: {}", id);
        String result = nInventoryService.delete(id);
        log.info("Facade: Delete Inventory result: {}", result);
        return result;
    }

    public List<InventoryEntity> searchByKeyword(String keyword) {
        log.info("Facade: Request to search Inventory items with keyword: '{}'", keyword);
        List<InventoryEntity> result = nInventoryService.searchByKeyword(keyword);
        log.info("Facade: Search completed, found {} Inventory items", result.size());
        return result;
    }
}
