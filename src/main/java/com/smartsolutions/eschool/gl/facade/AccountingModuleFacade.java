package com.smartsolutions.eschool.gl.facade;

import com.smartsolutions.eschool.gl.dtos.accountingModule.request.AccountingModuleRequestDTO;
import com.smartsolutions.eschool.gl.dtos.accountingModule.response.AccountingModuleResponseDTO;
import com.smartsolutions.eschool.gl.service.AccountingModuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class AccountingModuleFacade {

    private final AccountingModuleService accountingModuleService;

    public List<AccountingModuleResponseDTO> getAll() {
        log.info("[Facade:AccountingModuleFacade] getAll() called");
        return accountingModuleService.getAll();
    }

    public AccountingModuleResponseDTO getById(Long id) {
        log.info("[Facade:AccountingModuleFacade] getById() called - ID: {}", id);
        return accountingModuleService.getById(id);
    }

    public AccountingModuleResponseDTO create(AccountingModuleRequestDTO requestDTO) {
        log.info("[Facade:AccountingModuleFacade] create() called");
        return accountingModuleService.create(requestDTO);
    }

    public AccountingModuleResponseDTO update(Long id, AccountingModuleRequestDTO requestDTO) {
        log.info("[Facade:AccountingModuleFacade] update() called - ID: {}", id);
        return accountingModuleService.update(id, requestDTO);
    }

    public void delete(Long id) {
        log.info("[Facade:AccountingModuleFacade] delete() called - ID: {}", id);
        accountingModuleService.delete(id);
    }

    public List<AccountingModuleResponseDTO> search(String keyword) {
        log.info("[Facade:AccountingModuleFacade] search() called - Keyword: {}", keyword);
        return accountingModuleService.search(keyword);
    }
}
