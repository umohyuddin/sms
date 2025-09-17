package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.model.MarksGradingEntity;
import com.smartsolutions.eschool.school.service.MarksGradingService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class MarksGradingFacade {
    private static final Log LOG = LogFactory.getLog(MarksGradingFacade.class);
    @Autowired
    @Lazy
    private final MarksGradingService nMarksGradingService;

    public MarksGradingFacade(MarksGradingService pMarksGradingService) {
        this.nMarksGradingService = pMarksGradingService;
    }


    public List<MarksGradingEntity> getAll() {
        return nMarksGradingService.getAll();
    }

    public List<MarksGradingEntity> getByInstitute(long id) {
        return nMarksGradingService.getByInstitute(id);
    }

    public MarksGradingEntity getById(Long id) {
        return nMarksGradingService.getById(id);
    }

    public String create(MarksGradingEntity pMarksGradingEntity) {
        return nMarksGradingService.create(pMarksGradingEntity);
    }

    public String update(MarksGradingEntity pMarksGradingEntity) {
        return nMarksGradingService.update(pMarksGradingEntity);
    }

    public String delete(Long id) {
        return nMarksGradingService.delete(id);
    }
}
