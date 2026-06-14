package com.smartsolutions.eschool.gl.service;

import com.smartsolutions.eschool.gl.dtos.transactionType.request.TransactionTypeRequestDTO;
import com.smartsolutions.eschool.gl.dtos.transactionType.response.TransactionTypeResponseDTO;
import com.smartsolutions.eschool.gl.mapper.TransactionTypeMapper;
import com.smartsolutions.eschool.gl.model.TransactionTypeEntity;
import com.smartsolutions.eschool.gl.repository.TransactionTypeRepository;
import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.gl.error.GLAccountErrors;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.smartsolutions.eschool.global.utils.EntityReferenceValidator;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionTypeService {

    private final TransactionTypeRepository transactionTypeRepository;
    private final com.smartsolutions.eschool.global.utils.EntityReferenceValidator entityReferenceValidator;

    public List<TransactionTypeResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:TransactionTypeService] getAll() called - Organization: {}", organizationId);
        List<TransactionTypeEntity> entities = transactionTypeRepository.findAllByOrganizationId(organizationId);
        return TransactionTypeMapper.toResponseDTOList(entities);
    }

    public TransactionTypeResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:TransactionTypeService] getById() called - ID: {}, Org: {}", id, organizationId);
        TransactionTypeEntity entity = transactionTypeRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND));
        return TransactionTypeMapper.toResponseDTO(entity);
    }

    @Transactional
    public TransactionTypeResponseDTO create(TransactionTypeRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:TransactionTypeService] create() called - Code: {}", requestDTO.getCode());

        if (transactionTypeRepository.existsByOrganizationIdAndCode(organizationId, requestDTO.getCode().trim())) {
            throw new ApiException(GLAccountErrors.DUPLICATE_ACCOUNT_CODE, HttpStatus.CONFLICT);
        }

        TransactionTypeEntity entity = TransactionTypeMapper.toEntity(requestDTO);
        entity.setOrganizationId(organizationId);
        TransactionTypeEntity saved = transactionTypeRepository.save(entity);
        return TransactionTypeMapper.toResponseDTO(saved);
    }

    @Transactional
    public TransactionTypeResponseDTO update(Long id, TransactionTypeRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:TransactionTypeService] update() called - ID: {}", id);

        TransactionTypeEntity existing = transactionTypeRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (!existing.getCode().equals(requestDTO.getCode().trim())) {
            if (transactionTypeRepository.existsByOrganizationIdAndCodeAndIdNot(organizationId, requestDTO.getCode().trim(), id)) {
                throw new ApiException(GLAccountErrors.DUPLICATE_ACCOUNT_CODE, HttpStatus.CONFLICT);
            }
        }

        TransactionTypeMapper.updateEntityFromDTO(existing, requestDTO);
        TransactionTypeEntity updated = transactionTypeRepository.save(existing);
        return TransactionTypeMapper.toResponseDTO(updated);
    }

    @Transactional
    public void delete(Long id) {
        entityReferenceValidator.ensureNotReferenced(TransactionTypeEntity.class, id);
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:TransactionTypeService] delete() called - ID: {}", id);
        int result = transactionTypeRepository.softDeleteByIdAndOrganizationId(id, organizationId);
        if (result == 0) {
            throw new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    public List<TransactionTypeResponseDTO> search(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:TransactionTypeService] search() called - Keyword: {}", keyword);
        List<TransactionTypeEntity> entities = transactionTypeRepository.searchByKeywordAndOrganizationId(keyword, organizationId);
        return TransactionTypeMapper.toResponseDTOList(entities);
    }
}
