package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.model.FailCriteriaEntity;
import com.smartsolutions.eschool.school.service.CampusService;
import com.smartsolutions.eschool.school.service.FailCriteriaService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class FailCriteriaFacade {
    private static final Log LOG = LogFactory.getLog(FailCriteriaFacade.class);
    @Autowired
    @Lazy
    private final FailCriteriaService nFailCriteriaService;

    public FailCriteriaFacade(FailCriteriaService pFailCriteriaService) {
        this.nFailCriteriaService = pFailCriteriaService;
    }


    public List<FailCriteriaEntity> getAll() {
        return nFailCriteriaService.getAll();
    }

    public List<FailCriteriaEntity> getByInstitute(Long id) {
        return nFailCriteriaService.getByInstitute(id);
    }

    public FailCriteriaEntity getById(Long id) {
        return nFailCriteriaService.getById(id);
    }

    public String create(FailCriteriaEntity pFailCriteriaEntity) {
        return nFailCriteriaService.create(pFailCriteriaEntity);
    }

    public String update(FailCriteriaEntity pFailCriteriaEntity) {
        return nFailCriteriaService.update(pFailCriteriaEntity);
    }

    public String delete(Long id) {
        return nFailCriteriaService.delete(id);
    }
}
