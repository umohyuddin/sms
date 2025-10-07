package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.service.SClassService;
import com.smartsolutions.eschool.sclass.service.SectionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class SectionFacade {
    private static final Log LOG = LogFactory.getLog(SectionFacade.class);
    @Autowired
    @Lazy
    private SectionService nSectionService;

    public List<SectionEntity> getAll() {
        return nSectionService.getAll();
    }

    public SectionEntity getById(Long id) {
        return nSectionService.getById(id);
    }

    public List<SectionEntity> getByInstituteId(Long id) {
        return nSectionService.getByInstituteId(id);
    }

    public List<SectionEntity> getByCampusId(Long id) {
        return nSectionService.getByCampusId(id);
    }

    public List<SectionEntity> getByClassId(Long id) {
        return nSectionService.getByClassId(id);
    }

    public String create(SectionEntity pSectionEntity) {
        return nSectionService.create(pSectionEntity);
    }

    public String update(SectionEntity pSectionEntity) {
        return nSectionService.update(pSectionEntity);
    }

    public String delete(Long id) {
        return nSectionService.delete(id);
    }
}
