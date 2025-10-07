package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.model.MCQEntity;
import com.smartsolutions.eschool.sclass.service.MCQService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class MCQFacade {

    private static final Log LOG = LogFactory.getLog(MCQFacade.class);
    @Autowired
    @Lazy
    private MCQService nMCQService;

    public List<MCQEntity> getAll() {
        return nMCQService.getAll();
    }

    public MCQEntity getById(Long id) {
        return nMCQService.getById(id);
    }

    public List<MCQEntity> getByChapter(Long id, Long chp) {
        return nMCQService.getByChapter(id, chp);
    }

    public List<MCQEntity> getBySubjectId(Long id) {
        return nMCQService.getBySubjectId(id);
    }

    public String create(MCQEntity pMCQEntity) {
        return nMCQService.create(pMCQEntity);
    }

    public String update(MCQEntity pMCQEntity) {
        return nMCQService.update(pMCQEntity);
    }

    public String delete(Long id) {
        return nMCQService.delete(id);
    }
}
