package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.DepartmentTypeErrors;
import com.smartsolutions.eschool.school.dtos.departmentTypes.requestDto.DepartmentTypeCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.departmentTypes.response.DepartmentTypeResponseDTO;
import com.smartsolutions.eschool.school.mapper.DepartmentTypeMapper;
import com.smartsolutions.eschool.school.model.DepartmentTypeEntity;
import com.smartsolutions.eschool.school.repository.DepartmentTypeRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DepartmentTypeService {

    private final DepartmentTypeRepository departmentTypeRepository;

    public DepartmentTypeService(DepartmentTypeRepository departmentTypeRepository) {
        this.departmentTypeRepository = departmentTypeRepository;
    }

    public List<DepartmentTypeResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentTypeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentTypeService] getAll() called - Fetching all for organization: {}", organizationId);
        List<DepartmentTypeEntity> result = departmentTypeRepository.findByOrganizationId(organizationId);
        List<DepartmentTypeResponseDTO> responseDTOs = DepartmentTypeMapper.toResponseDTOList(result);
        log.info("[Service:DepartmentTypeService] getAll() succeeded - Found {} department types", responseDTOs.size());
        return responseDTOs;
    }

    public DepartmentTypeResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentTypeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentTypeService] getById() called - id: {}, organization: {}", id, organizationId);
        DepartmentTypeEntity entity = departmentTypeRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(DepartmentTypeErrors.DEPARTMENT_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));

        DepartmentTypeResponseDTO responseDTO = DepartmentTypeMapper.toResponseDTO(entity);
        log.info("[Service:DepartmentTypeService] getById() succeeded - Found department type: {}", id);
        return responseDTO;
    }

    @Transactional
    public void softDeleteById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentTypeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentTypeService] softDeleteById() called - id: {}, organization: {}", id, organizationId);

        int result = departmentTypeRepository.softDeleteByIdAndOrganizationId(id, organizationId);
        if (result == 0) {
            throw new ApiException(DepartmentTypeErrors.DEPARTMENT_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:DepartmentTypeService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public DepartmentTypeResponseDTO createDepartmentType(DepartmentTypeCreateRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentTypeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentTypeService] createDepartmentType() called - Creating for organization: {}", organizationId);

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().isEmpty()) {
            if (departmentTypeRepository.existsByOrganizationIdAndCode(organizationId, requestDTO.getCode().trim())) {
                throw new ApiException(DepartmentTypeErrors.DUPLICATE_DEPARTMENT_TYPE_CODE, HttpStatus.CONFLICT);
            }
        }

        DepartmentTypeEntity entity = DepartmentTypeMapper.toEntity(requestDTO);
        // organizationId is handled by prePersist but we can set it explicitly if needed or let AuditableEntity handle it.
        // AuditableEntity.prePersist calls SecurityUtils.getCurrentOrganizationId()
        
        DepartmentTypeEntity saved = departmentTypeRepository.save(entity);

        log.info("[Service:DepartmentTypeService] createDepartmentType() succeeded - Department type created with id: {}", saved.getId());
        return DepartmentTypeMapper.toResponseDTO(saved);
    }

    @Transactional
    public DepartmentTypeResponseDTO updateDepartmentType(Long id, DepartmentTypeCreateRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentTypeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentTypeService] updateDepartmentType() called - id: {}, organization: {}", id, organizationId);

        DepartmentTypeEntity existing = departmentTypeRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(DepartmentTypeErrors.DEPARTMENT_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().equals(existing.getCode())) {
            if (departmentTypeRepository.existsByOrganizationIdAndCodeAndIdNot(organizationId, requestDTO.getCode().trim(), id)) {
                throw new ApiException(DepartmentTypeErrors.DUPLICATE_DEPARTMENT_TYPE_CODE, HttpStatus.CONFLICT);
            }
        }

        DepartmentTypeMapper.updateEntityFromDTO(existing, requestDTO);
        DepartmentTypeEntity updated = departmentTypeRepository.save(existing);

        log.info("[Service:DepartmentTypeService] updateDepartmentType() succeeded - id: {}", id);
        return DepartmentTypeMapper.toResponseDTO(updated);
    }

    public List<DepartmentTypeResponseDTO> searchByKeyword(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentTypeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentTypeService] searchByKeyword() called - keyword: {}, organization: {}", keyword, organizationId);
        List<DepartmentTypeEntity> result = departmentTypeRepository.searchByKeywordAndOrganizationId(keyword, organizationId);
        List<DepartmentTypeResponseDTO> responseDTOs = DepartmentTypeMapper.toResponseDTOList(result);
        log.info("[Service:DepartmentTypeService] searchByKeyword() succeeded - Found {} department types", responseDTOs.size());
        return responseDTOs;
    }

    public java.util.Map<String, Long> getStatistics() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(DepartmentTypeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:DepartmentTypeService] getStatistics() called - organization: {}", organizationId);

        java.util.Map<String, Long> stats = new java.util.HashMap<>();
        stats.put("total", departmentTypeRepository.countByOrganizationId(organizationId));
        stats.put("active", departmentTypeRepository.countByOrganizationIdAndActiveTrue(organizationId));
        stats.put("inactive", departmentTypeRepository.countByOrganizationIdAndActiveFalse(organizationId));

        log.info("[Service:DepartmentTypeService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
