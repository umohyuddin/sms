package com.smartsolutions.eschool.gl.service;

import com.smartsolutions.eschool.gl.dtos.glAccountMapping.request.GLAccountMappingRequestDTO;
import com.smartsolutions.eschool.gl.dtos.glAccountMapping.response.GLAccountMappingResponseDTO;
import com.smartsolutions.eschool.gl.mapper.GLAccountMappingMapper;
import com.smartsolutions.eschool.gl.model.*;
import com.smartsolutions.eschool.gl.repository.*;
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
public class GLAccountMappingService {

    private final GLAccountMappingRepository mappingRepository;
    private final AccountingModuleRepository moduleRepository;
    private final TransactionTypeRepository transactionTypeRepository;
    private final BusinessKeyRepository businessKeyRepository;
    private final PostingKeyRepository postingKeyRepository;
    private final GLAccountRepository accountRepository;

    public List<GLAccountMappingResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:GLAccountMappingService] getAll() called - Organization: {}", organizationId);
        List<GLAccountMappingEntity> entities = mappingRepository.findAllByOrganizationId(organizationId);
        return GLAccountMappingMapper.toResponseDTOList(entities);
    }

    public GLAccountMappingResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:GLAccountMappingService] getById() called - ID: {}, Org: {}", id, organizationId);
        GLAccountMappingEntity entity = mappingRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND));
        return GLAccountMappingMapper.toResponseDTO(entity);
    }

    @Transactional
    public GLAccountMappingResponseDTO create(GLAccountMappingRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:GLAccountMappingService] create() called");

        GLAccountMappingEntity entity = new GLAccountMappingEntity();
        entity.setOrganizationId(organizationId);
        mapDtoToEntity(requestDTO, entity, organizationId);

        GLAccountMappingEntity saved = mappingRepository.save(entity);
        return getById(saved.getId()); // Fetch to get joins
    }

    @Transactional
    public GLAccountMappingResponseDTO update(Long id, GLAccountMappingRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:GLAccountMappingService] update() called - ID: {}", id);

        GLAccountMappingEntity existing = mappingRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND));

        mapDtoToEntity(requestDTO, existing, organizationId);

        GLAccountMappingEntity updated = mappingRepository.save(existing);
        return getById(updated.getId());
    }

    private void mapDtoToEntity(GLAccountMappingRequestDTO dto, GLAccountMappingEntity entity, Long orgId) {
        entity.setCampusId(dto.getCampusId());
        entity.setPriorityOrder(dto.getPriorityOrder());
        entity.setActive(dto.isActive());

        entity.setAccountingModule(moduleRepository.findByIdAndOrganizationId(dto.getAccountingModuleId(), orgId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND)));

        entity.setTransactionType(transactionTypeRepository.findByIdAndOrganizationId(dto.getTransactionTypeId(), orgId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND)));

        entity.setBusinessKey(businessKeyRepository.findByIdAndOrganizationId(dto.getBusinessKeyId(), orgId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND)));

        entity.setPostingKey(postingKeyRepository.findByIdAndOrganizationId(dto.getPostingKeyId(), orgId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND)));

        entity.setGlAccount(accountRepository.findByIdAndOrganizationId(dto.getGlAccountId(), orgId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND)));
    }

    @Transactional
    public void delete(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:GLAccountMappingService] delete() called - ID: {}", id);
        int result = mappingRepository.softDeleteByIdAndOrganizationId(id, organizationId);
        if (result == 0) {
            throw new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    public List<GLAccountMappingResponseDTO> search(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:GLAccountMappingService] search() called - Keyword: {}", keyword);
        List<GLAccountMappingEntity> entities = mappingRepository.searchByKeywordAndOrganizationId(keyword, organizationId);
        return GLAccountMappingMapper.toResponseDTOList(entities);
    }
}
