package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.model.BankEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.service.BankService;
import com.smartsolutions.eschool.school.service.CampusService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class BankFacade {
    private static final Log LOG = LogFactory.getLog(BankFacade.class);
    @Autowired
    @Lazy
    private final BankService nBankService;

    public BankFacade(BankService pBankService) {
        this.nBankService = pBankService;
    }


    public List<BankEntity> getAll() {
        log.info("Facade: Request to fetch all Banks");
        List<BankEntity> result = nBankService.getAll();
        log.info("Facade: Successfully fetched {} Banks", result.size());
        return result;
    }

    public List<BankEntity> getByInstitute(Long id) {
        log.info("Facade: Request to fetch Banks for Institute ID: {}", id);
        List<BankEntity> result = nBankService.getByInstitute(id);
        log.info("Facade: Successfully fetched {} Banks for Institute ID: {}", result.size(), id);
        return result;
    }

    public BankEntity getById(Long id) {
        log.info("Facade: Request to fetch Bank ID: {}", id);
        BankEntity result = nBankService.getById(id);
        log.info("Facade: Successfully fetched Bank ID: {}", id);
        return result;
    }

    public String create(BankEntity pBankEntity) {
        log.info("Facade: Request to create Bank: {}", pBankEntity.getName());
        String result = nBankService.create(pBankEntity);
        log.info("Facade: Create Bank result: {}", result);
        return result;
    }

    public String update(BankEntity pBankEntity) {
        log.info("Facade: Request to update Bank ID: {}", pBankEntity.getId());
        String result = nBankService.update(pBankEntity);
        log.info("Facade: Update Bank result: {}", result);
        return result;
    }

    public String delete(Long id) {
        log.info("Facade: Request to delete Bank ID: {}", id);
        String result = nBankService.delete(id);
        log.info("Facade: Delete Bank result: {}", result);
        return result;
    }

    public List<BankEntity> searchByKeyword(String keyword) {
        log.info("Facade: Request to search Banks with keyword: '{}'", keyword);
        List<BankEntity> result = nBankService.searchByKeyword(keyword);
        log.info("Facade: Search completed, found {} Banks", result.size());
        return result;
    }
}
