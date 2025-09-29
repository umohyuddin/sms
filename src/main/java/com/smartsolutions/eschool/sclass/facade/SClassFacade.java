package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.sclass.service.SClassService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class SClassFacade {

    private static final Log LOG = LogFactory.getLog(SClassFacade.class);
    @Autowired
    @Lazy
    private SClassService SClassService;

    public List<SClassEntity> getAll() {
        return SClassService.getAll();
    }

    public SClassEntity getById(Long id) {
        return SClassService.getById(id);
    }

    public List<SClassEntity> getByTeacherId(Long id) {
        return SClassService.getByTeacherId(id);
    }

    public List<SClassEntity> getByCourseId(Long id) {
        return SClassService.getByCourseId(id);
    }

    public List<SClassEntity> getByStudentId(Long id) {
        return SClassService.getByStudentId(id);
    }

    public String create(SClassEntity pSClassEntity) {
        return SClassService.create(pSClassEntity);
    }

    public String update(SClassEntity pSClassEntity) {
        return SClassService.update(pSClassEntity);
    }

    public String delete(Long id) {
        return SClassService.delete(id);
    }
}
