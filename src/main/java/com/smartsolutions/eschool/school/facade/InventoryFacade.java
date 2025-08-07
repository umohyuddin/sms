package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.model.InventoryEntity;
import java.util.List;
import com.smartsolutions.eschool.school.service.InventoryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class InventoryFacade {
    private static final Log LOG = LogFactory.getLog(InventoryFacade.class);
    @Autowired
    @Lazy
    private final InventoryService nInventoryService;

    public InventoryFacade(InventoryService pInventoryService) {
        this.nInventoryService = pInventoryService;
    }


    public List<InventoryEntity> getAll() {
        return nInventoryService.getAll();
    }

    public List<InventoryEntity> findByCampus(Long id) {
        return nInventoryService.findByCampus(id);
    }

    public List<InventoryEntity> findByInstitute(Long id) {
        return nInventoryService.findByInstitute(id);
    }

    public InventoryEntity getById(Long id) {
        return nInventoryService.getById(id);
    }

    public String create(InventoryEntity pInventoryEntity) {
        return nInventoryService.create(pInventoryEntity);
    }

    public String update(InventoryEntity pInventoryEntity) {
        return nInventoryService.update(pInventoryEntity);
    }

    public String delete(Long id) {
        return nInventoryService.delete(id);
    }
}
