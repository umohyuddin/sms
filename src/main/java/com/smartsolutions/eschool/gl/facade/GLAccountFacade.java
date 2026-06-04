package com.smartsolutions.eschool.gl.facade;

import com.smartsolutions.eschool.gl.dtos.accounts.requestDto.GLAccountCreateRequestDTO;
import com.smartsolutions.eschool.gl.dtos.accounts.responseDto.GLAccountResponseDTO;
import com.smartsolutions.eschool.gl.service.GLAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@RequiredArgsConstructor
@Slf4j
public class GLAccountFacade {

    private final GLAccountService glAccountService;

    public List<GLAccountResponseDTO> getAll() {
        log.info("[Facade:GLAccountFacade] getAll() called");
        return glAccountService.getAll();
    }

    public GLAccountResponseDTO getById(Long id) {
        log.info("[Facade:GLAccountFacade] getById() called - id: {}", id);
        return glAccountService.getById(id);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:GLAccountFacade] softDeleteById() called - id: {}", id);
        glAccountService.softDeleteById(id);
    }

    public GLAccountResponseDTO createAccount(GLAccountCreateRequestDTO dto) {
        log.info("[Facade:GLAccountFacade] createAccount() called - code: {}", dto.getAccountCode());
        return glAccountService.createAccount(dto);
    }

    public GLAccountResponseDTO updateAccount(Long id, GLAccountCreateRequestDTO dto) {
        log.info("[Facade:GLAccountFacade] updateAccount() called - id: {}", id);
        return glAccountService.updateAccount(id, dto);
    }

    public List<GLAccountResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:GLAccountFacade] searchByKeyword() called - keyword: {}", keyword);
        return glAccountService.searchByKeyword(keyword);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:GLAccountFacade] getStatistics() called");
        return glAccountService.getStatistics();
    }
}
