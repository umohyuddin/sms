package com.smartsolutions.eschool.gl.service;

import com.smartsolutions.eschool.gl.dtos.accounts.requestDto.GLAccountCreateRequestDTO;
import com.smartsolutions.eschool.gl.dtos.accounts.responseDto.GLAccountResponseDTO;
import com.smartsolutions.eschool.gl.error.GLAccountErrors;
import com.smartsolutions.eschool.gl.mapper.GLAccountMapper;
import com.smartsolutions.eschool.gl.model.GLAccountEntity;
import com.smartsolutions.eschool.gl.repository.GLAccountRepository;
import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import com.smartsolutions.eschool.global.utils.EntityReferenceValidator;

@Service
@RequiredArgsConstructor
@Slf4j
public class GLAccountService {

    private final GLAccountRepository glAccountRepository;
    private final com.smartsolutions.eschool.global.utils.EntityReferenceValidator entityReferenceValidator;

    public List<GLAccountResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GLAccountErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GLAccountService] getAll() called - Fetching all for organization: {}", organizationId);
        List<GLAccountEntity> result = glAccountRepository.findAllByOrganizationId(organizationId);
        List<GLAccountResponseDTO> responseDTOs = GLAccountMapper.toResponseDTOList(result);
        log.info("[Service:GLAccountService] getAll() succeeded - Found {} accounts", responseDTOs.size());
        return responseDTOs;
    }

    public GLAccountResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GLAccountErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GLAccountService] getById() called - id: {}, organization: {}", id, organizationId);
        GLAccountEntity entity = glAccountRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND));

        GLAccountResponseDTO responseDTO = GLAccountMapper.toResponseDTO(entity);
        log.info("[Service:GLAccountService] getById() succeeded - Found account: {}", id);
        return responseDTO;
    }

    public GLAccountEntity getAccountByCode(Long organizationId, String accountCode) {
        log.info("[Service:GLAccountService] getAccountByCode() called - code: {}, organization: {}", accountCode, organizationId);
        return glAccountRepository.findByOrganizationIdAndAccountCode(organizationId, accountCode)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, "Account not found with code: " + accountCode, HttpStatus.NOT_FOUND));
    }

    @Transactional
    public GLAccountResponseDTO createAccount(GLAccountCreateRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GLAccountErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GLAccountService] createAccount() called - Creating for organization: {}", organizationId);

        if (glAccountRepository.existsByOrganizationIdAndAccountCode(organizationId, requestDTO.getAccountCode().trim())) {
            throw new ApiException(GLAccountErrors.DUPLICATE_ACCOUNT_CODE, HttpStatus.CONFLICT);
        }

        GLAccountEntity entity = GLAccountMapper.toEntity(requestDTO);
        entity.setOrganizationId(organizationId);

        if (requestDTO.getParentId() != null) {
            GLAccountEntity parent = glAccountRepository.findByIdAndOrganizationId(requestDTO.getParentId(), organizationId)
                    .orElseThrow(() -> new ApiException(GLAccountErrors.PARENT_ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND));
            entity.setParent(parent);
            entity.setLevelNo(parent.getLevelNo() + 1);
            // Optionally inherit account type from parent
            entity.setAccountType(parent.getAccountType());
        } else {
            entity.setLevelNo(1);
        }

        GLAccountEntity saved = glAccountRepository.save(entity);
        log.info("[Service:GLAccountService] createAccount() succeeded - Account created with id: {}", saved.getId());
        return GLAccountMapper.toResponseDTO(saved);
    }

    @Transactional
    public GLAccountResponseDTO updateAccount(Long id, GLAccountCreateRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GLAccountErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GLAccountService] updateAccount() called - id: {}, organization: {}", id, organizationId);

        GLAccountEntity existing = glAccountRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (!existing.getAccountCode().equals(requestDTO.getAccountCode().trim())) {
            if (glAccountRepository.existsByOrganizationIdAndAccountCodeAndIdNot(organizationId, requestDTO.getAccountCode().trim(), id)) {
                throw new ApiException(GLAccountErrors.DUPLICATE_ACCOUNT_CODE, HttpStatus.CONFLICT);
            }
        }

        GLAccountMapper.updateEntityFromDTO(existing, requestDTO);

        if (requestDTO.getParentId() != null) {
            if (!requestDTO.getParentId().equals(existing.getParent() != null ? existing.getParent().getId() : null)) {
                GLAccountEntity parent = glAccountRepository.findByIdAndOrganizationId(requestDTO.getParentId(), organizationId)
                        .orElseThrow(() -> new ApiException(GLAccountErrors.PARENT_ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND));
                existing.setParent(parent);
                existing.setLevelNo(parent.getLevelNo() + 1);
            }
        } else {
            existing.setParent(null);
            existing.setLevelNo(1);
        }

        GLAccountEntity updated = glAccountRepository.save(existing);
        log.info("[Service:GLAccountService] updateAccount() succeeded - id: {}", id);
        return GLAccountMapper.toResponseDTO(updated);
    }

    @Transactional
    public void softDeleteById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
        entityReferenceValidator.ensureNotReferenced(GLAccountEntity.class, id);
            throw new ApiException(GLAccountErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GLAccountService] softDeleteById() called - id: {}, organization: {}", id, organizationId);

        int result = glAccountRepository.softDeleteByIdAndOrganizationId(id, organizationId);
        if (result == 0) {
            throw new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:GLAccountService] softDeleteById() succeeded - id: {}", id);
    }

    public List<GLAccountResponseDTO> searchByKeyword(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GLAccountErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GLAccountService] searchByKeyword() called - keyword: {}, organization: {}", keyword, organizationId);
        List<GLAccountEntity> result = glAccountRepository.searchByKeywordAndOrganizationId(keyword, organizationId);
        List<GLAccountResponseDTO> responseDTOs = GLAccountMapper.toResponseDTOList(result);
        log.info("[Service:GLAccountService] searchByKeyword() succeeded - Found {} accounts", responseDTOs.size());
        return responseDTOs;
    }

    public Map<String, Long> getStatistics() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GLAccountErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GLAccountService] getStatistics() called - organization: {}", organizationId);

        Map<String, Long> stats = new java.util.HashMap<>();
        stats.put("totalAccounts", glAccountRepository.countByOrganizationId(organizationId));
        stats.put("activeAccounts", glAccountRepository.countByOrganizationIdAndActiveTrue(organizationId));
        stats.put("inactiveAccounts", glAccountRepository.countByOrganizationIdAndActiveFalse(organizationId));

        log.info("[Service:GLAccountService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }

    public List<GLAccountEntity> getChartOfAccounts(Long organizationId) {
        return glAccountRepository.findAllByOrganizationIdAndIsActiveTrue(organizationId);
    }
}
