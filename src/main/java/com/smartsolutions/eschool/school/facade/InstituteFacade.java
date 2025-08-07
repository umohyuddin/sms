package com.smartsolutions.eschool.school.facade;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.service.InstituteService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class InstituteFacade {
    private static final Log LOG = LogFactory.getLog(InstituteFacade.class);
    @Autowired
    @Lazy
    private final InstituteService nInstituteService;

    public InstituteFacade(InstituteService pInstituteService) {
        this.nInstituteService = pInstituteService;
    }

    public List<InstituteEntity> getAll() {
        return nInstituteService.getAll();
    }

    public InstituteEntity getById(Long id) {
        return nInstituteService.getById(id);
    }

    public String create(InstituteEntity pInstituteEntity) {
        return nInstituteService.create(pInstituteEntity);
    }

    public String update(InstituteEntity pInstituteEntity) {
        return nInstituteService.update(pInstituteEntity);
    }

    public String delete(Long id) {
        return nInstituteService.delete(id);
    }
}
