package com.smartsolutions.eschool.gl.service;

import com.smartsolutions.eschool.gl.dtos.businessKey.request.BusinessKeyRequestDTO;
import com.smartsolutions.eschool.gl.dtos.businessKey.response.BusinessKeyResponseDTO;
import com.smartsolutions.eschool.gl.mapper.BusinessKeyMapper;
import com.smartsolutions.eschool.gl.model.BusinessKeyEntity;
import com.smartsolutions.eschool.gl.repository.BusinessKeyRepository;
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
public class BusinessKeyService {

    private final BusinessKeyRepository businessKeyRepository;

    public List<BusinessKeyResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:BusinessKeyService] getAll() called - Organization: {}", organizationId);
        List<BusinessKeyEntity> entities = businessKeyRepository.findAllByOrganizationId(organizationId);
        return BusinessKeyMapper.toResponseDTOList(entities);
    }

    public BusinessKeyResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:BusinessKeyService] getById() called - ID: {}, Org: {}", id, organizationId);
        BusinessKeyEntity entity = businessKeyRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND));
        return BusinessKeyMapper.toResponseDTO(entity);
    }

    @Transactional
    public BusinessKeyResponseDTO create(BusinessKeyRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:BusinessKeyService] create() called - Code: {}", requestDTO.getCode());

        if (businessKeyRepository.existsByOrganizationIdAndCode(organizationId, requestDTO.getCode().trim())) {
            throw new ApiException(GLAccountErrors.DUPLICATE_ACCOUNT_CODE, HttpStatus.CONFLICT);
        }

        BusinessKeyEntity entity = BusinessKeyMapper.toEntity(requestDTO);
        entity.setOrganizationId(organizationId);
        BusinessKeyEntity saved = businessKeyRepository.save(entity);
        return BusinessKeyMapper.toResponseDTO(saved);
    }

    @Transactional
    public BusinessKeyResponseDTO update(Long id, BusinessKeyRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:BusinessKeyService] update() called - ID: {}", id);

        BusinessKeyEntity existing = businessKeyRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (!existing.getCode().equals(requestDTO.getCode().trim())) {
            if (businessKeyRepository.existsByOrganizationIdAndCodeAndIdNot(organizationId, requestDTO.getCode().trim(), id)) {
                throw new ApiException(GLAccountErrors.DUPLICATE_ACCOUNT_CODE, HttpStatus.CONFLICT);
            }
        }

        BusinessKeyMapper.updateEntityFromDTO(existing, requestDTO);
        BusinessKeyEntity updated = businessKeyRepository.save(existing);
        return BusinessKeyMapper.toResponseDTO(updated);
    }

    @Transactional
    public void delete(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:BusinessKeyService] delete() called - ID: {}", id);
        int result = businessKeyRepository.softDeleteByIdAndOrganizationId(id, organizationId);
        if (result == 0) {
            throw new ApiException(GLAccountErrors.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    public List<BusinessKeyResponseDTO> search(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:BusinessKeyService] search() called - Keyword: {}", keyword);
        List<BusinessKeyEntity> entities = businessKeyRepository.searchByKeywordAndOrganizationId(keyword, organizationId);
        return BusinessKeyMapper.toResponseDTOList(entities);
    }
}
