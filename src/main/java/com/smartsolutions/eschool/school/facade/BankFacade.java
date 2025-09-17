package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.model.BankEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.service.BankService;
import com.smartsolutions.eschool.school.service.CampusService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class BankFacade {
    private static final Log LOG = LogFactory.getLog(BankFacade.class);
    @Autowired
    @Lazy
    private final BankService nBankService;

    public BankFacade(BankService pBankService) {
        this.nBankService = pBankService;
    }


    public List<BankEntity> getAll() {
        return nBankService.getAll();
    }

    public List<BankEntity> getByInstitute(Long id) {
        return nBankService.getByInstitute(id);
    }

    public BankEntity getById(Long id) {
        return nBankService.getById(id);
    }

    public String create(BankEntity pBankEntity) {
        return nBankService.create(pBankEntity);
    }

    public String update(BankEntity pBankEntity) {
        return nBankService.update(pBankEntity);
    }

    public String delete(Long id) {
        return nBankService.delete(id);
    }
}
