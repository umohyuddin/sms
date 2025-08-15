package com.smartsolutions.eschool.course.facade;

import com.smartsolutions.eschool.course.model.SClassEntity;
import com.smartsolutions.eschool.course.service.SClassService;
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
    private static final Log LOG = LogFactory.getLog(CourseFacade.class);
    @Autowired
    @Lazy
    private SClassService sClassService;

    public List<SClassEntity> getAll() {
        return sClassService.getAll();
    }

    public SClassEntity getById(Long id) {
        return sClassService.getById(id);
    }

    public List<SClassEntity> getByTeacherId(Long id) {
        return sClassService.getByTeacherId(id);
    }

    public List<SClassEntity> getByCourseId(Long id) {
        return sClassService.getByCourseId(id);
    }

    public String create(SClassEntity pSClassEntity) {
        return sClassService.create(pSClassEntity);
    }

    public String update(SClassEntity pSClassEntity) {
        return sClassService.update(pSClassEntity);
    }

    public String delete(Long id) {
        return sClassService.delete(id);
    }
}
