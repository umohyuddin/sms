package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.model.FeeParticularsEntity;
import com.smartsolutions.eschool.student.service.FeeParticularsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class FeeParticularsFacade {

    private static final Log LOG = LogFactory.getLog(FeeParticularsFacade.class);
    @Autowired
    @Lazy
    private FeeParticularsService nFeeParticularsService;

    public List<FeeParticularsEntity> getAll() {
        return nFeeParticularsService.getAll();
    }
    public FeeParticularsEntity getById(Long id) {
        return nFeeParticularsService.getById(id);
    }

    public List<FeeParticularsEntity> getByInstitute(Long id) {
        return nFeeParticularsService.getByInstitute(id);
    }

    public String create(FeeParticularsEntity pFeeParticularsEntity) {
        return nFeeParticularsService.create(pFeeParticularsEntity);
    }

    public String update(FeeParticularsEntity pFeeParticularsEntity) {
        return nFeeParticularsService.update(pFeeParticularsEntity);
    }
    public String delete(Long id) {
        return nFeeParticularsService.delete(id);
    }
}
