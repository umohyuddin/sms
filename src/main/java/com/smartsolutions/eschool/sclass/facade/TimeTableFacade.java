package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.model.TimeTableEntity;
import com.smartsolutions.eschool.sclass.service.TimeTableService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class TimeTableFacade {
    private static final Log LOG = LogFactory.getLog(TimeTableFacade.class);
    @Autowired
    @Lazy
    private TimeTableService timeTableService;

    public List<TimeTableEntity> getAll() {
        return timeTableService.getAll();
    }

    public TimeTableEntity getById(Long id) {
        return timeTableService.getById(id);
    }

    public List<TimeTableEntity> getByTeacherId(Long id) {
        return timeTableService.getByTeacherId(id);
    }

    public List<TimeTableEntity> getByCourseId(Long id) {
        return timeTableService.getByCourseId(id);
    }

    public String create(TimeTableEntity pTimeTableEntity) {
        return timeTableService.create(pTimeTableEntity);
    }

    public String update(TimeTableEntity pTimeTableEntity) {
        return timeTableService.update(pTimeTableEntity);
    }

    public String delete(Long id) {
        return timeTableService.delete(id);
    }
}
