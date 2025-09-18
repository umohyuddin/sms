package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.model.TimeTableEntity;
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
    private static final Log LOG = LogFactory.getLog(CourseFacade.class);
    @Autowired
    @Lazy
    private SClassService sClassService;

    public List<TimeTableEntity> getAll() {
        return sClassService.getAll();
    }

    public TimeTableEntity getById(Long id) {
        return sClassService.getById(id);
    }

    public List<TimeTableEntity> getByTeacherId(Long id) {
        return sClassService.getByTeacherId(id);
    }

    public List<TimeTableEntity> getByCourseId(Long id) {
        return sClassService.getByCourseId(id);
    }

    public String create(TimeTableEntity pTimeTableEntity) {
        return sClassService.create(pTimeTableEntity);
    }

    public String update(TimeTableEntity pTimeTableEntity) {
        return sClassService.update(pTimeTableEntity);
    }

    public String delete(Long id) {
        return sClassService.delete(id);
    }
}
