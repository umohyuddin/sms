package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.model.FeeEntity;
import com.smartsolutions.eschool.student.service.FeeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Scope("prototype")
public class FeeFacade {

    private static final Log LOG = LogFactory.getLog(FeeFacade.class);
    @Autowired
    @Lazy
    private FeeService feeService;


    public List<FeeEntity> getAll() {
        return feeService.getAll();
    }
    public FeeEntity getById(Long id) {
        return feeService.getById(id);
    }

    public List<FeeEntity> getByStudent(Long std_id) {
        return feeService.getByStudent(std_id);
    }

    public String create(FeeEntity pFeeEntity) {
        return feeService.create(pFeeEntity);
    }

    public String update(FeeEntity pFeeEntity) {
        return feeService.update(pFeeEntity);
    }
    public String delete(Long id) {
        return feeService.delete(id);
    }
}
