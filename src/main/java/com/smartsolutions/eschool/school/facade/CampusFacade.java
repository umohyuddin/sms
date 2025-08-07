package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.service.CampusService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CampusFacade {

    private static final Log LOG = LogFactory.getLog(CampusFacade.class);
    @Autowired
    @Lazy
    private final CampusService nCampusService;

    public CampusFacade(CampusService pCampusService) {
        this.nCampusService = pCampusService;
    }


    public List<CampusEntity> getAll() {
        return nCampusService.getAll();
    }

    public CampusEntity getById(Long id) {
        return nCampusService.getById(id);
    }

    public String create(CampusEntity pCampusEntity) {
        return nCampusService.create(pCampusEntity);
    }

    public String update(CampusEntity pCampusEntity) {
        return nCampusService.update(pCampusEntity);
    }

    public String delete(Long id) {
        return nCampusService.delete(id);
    }
}
