package com.smartsolutions.eschool.gl.service;

import com.smartsolutions.eschool.gl.dtos.accountingModule.request.AccountingModuleRequestDTO;
import com.smartsolutions.eschool.gl.dtos.accountingModule.response.AccountingModuleResponseDTO;
import com.smartsolutions.eschool.gl.mapper.AccountingModuleMapper;
import com.smartsolutions.eschool.gl.model.AccountingModuleEntity;
import com.smartsolutions.eschool.gl.repository.AccountingModuleRepository;
import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.gl.error.GLAccountErrors;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountingModuleService {

    private final AccountingModuleRepository accountingModuleRepository;

    public List<AccountingModuleResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:AccountingModuleService] getAll() called - Organization: {}", organizationId);
        List<AccountingModuleEntity> entities = accountingModuleRepository.findAllByOrganizationId(organizationId);
        return AccountingModuleMapper.toResponseDTOList(entities);
    }

    public AccountingModuleResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:AccountingModuleService] getById() called - ID: {}, Org: {}", id, organizationId);
        AccountingModuleEntity entity = accountingModuleRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND));
        return AccountingModuleMapper.toResponseDTO(entity);
    }

    @Transactional
    public AccountingModuleResponseDTO create(AccountingModuleRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:AccountingModuleService] create() called - Code: {}", requestDTO.getCode());

        if (accountingModuleRepository.existsByOrganizationIdAndCode(organizationId, requestDTO.getCode().trim())) {
            throw new ApiException(GLAccountErrors.DUPLICATE_ACCOUNT_CODE, HttpStatus.CONFLICT);
        }

        AccountingModuleEntity entity = AccountingModuleMapper.toEntity(requestDTO);
        entity.setOrganizationId(organizationId);
        AccountingModuleEntity saved = accountingModuleRepository.save(entity);
        return AccountingModuleMapper.toResponseDTO(saved);
    }

    @Transactional
    public AccountingModuleResponseDTO update(Long id, AccountingModuleRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:AccountingModuleService] update() called - ID: {}", id);

        AccountingModuleEntity existing = accountingModuleRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (!existing.getCode().equals(requestDTO.getCode().trim())) {
            if (accountingModuleRepository.existsByOrganizationIdAndCodeAndIdNot(organizationId, requestDTO.getCode().trim(), id)) {
                throw new ApiException(GLAccountErrors.DUPLICATE_ACCOUNT_CODE, HttpStatus.CONFLICT);
            }
        }

        AccountingModuleMapper.updateEntityFromDTO(existing, requestDTO);
        AccountingModuleEntity updated = accountingModuleRepository.save(existing);
        return AccountingModuleMapper.toResponseDTO(updated);
    }

    @Transactional
    public void delete(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:AccountingModuleService] delete() called - ID: {}", id);
        int result = accountingModuleRepository.softDeleteByIdAndOrganizationId(id, organizationId);
        if (result == 0) {
            throw new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    public List<AccountingModuleResponseDTO> search(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:AccountingModuleService] search() called - Keyword: {}", keyword);
        List<AccountingModuleEntity> entities = accountingModuleRepository.searchByKeywordAndOrganizationId(keyword, organizationId);
        return AccountingModuleMapper.toResponseDTOList(entities);
    }
}
