package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.AdmissionTypeErrors;
import com.smartsolutions.eschool.school.dtos.addmissionType.responseDto.AdmissionTypeResponseDTO;
import com.smartsolutions.eschool.student.dtos.admissionType.requestDto.AdmissionTypeCreateRequestDTO;
import com.smartsolutions.eschool.student.mapper.AdmissionTypeMapper;
import com.smartsolutions.eschool.student.model.AdmissionTypeEntity;
import com.smartsolutions.eschool.student.repository.AdmissionTypeRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class AdmissionTypeService {

    private final AdmissionTypeRepository admissionTypeRepository;

    public AdmissionTypeService(AdmissionTypeRepository admissionTypeRepository) {
        this.admissionTypeRepository = admissionTypeRepository;
    }

    public List<AdmissionTypeResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(AdmissionTypeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:AdmissionTypeService] getAll() called - Fetching all for organization: {}", organizationId);
        List<AdmissionTypeEntity> result = admissionTypeRepository.findAllByOrganizationId(organizationId);
        List<AdmissionTypeResponseDTO> responseDTOs = AdmissionTypeMapper.toResponseDTOList(result);
        log.info("[Service:AdmissionTypeService] getAll() succeeded - Found {} admission types", responseDTOs.size());
        return responseDTOs;
    }

    public AdmissionTypeResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(AdmissionTypeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:AdmissionTypeService] getById() called - id: {}, organization: {}", id, organizationId);
        AdmissionTypeEntity entity = admissionTypeRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(AdmissionTypeErrors.ADMISSION_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));

        AdmissionTypeResponseDTO responseDTO = AdmissionTypeMapper.toResponseDTO(entity);
        log.info("[Service:AdmissionTypeService] getById() succeeded - Found admission type: {}", id);
        return responseDTO;
    }

    public List<AdmissionTypeResponseDTO> searchByKeyword(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(AdmissionTypeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:AdmissionTypeService] searchByKeyword() called - keyword: {}, organization: {}", keyword,
                organizationId);
        List<AdmissionTypeEntity> result = admissionTypeRepository.searchByKeywordAndOrganizationId(keyword,
                organizationId);
        List<AdmissionTypeResponseDTO> responseDTOs = AdmissionTypeMapper.toResponseDTOList(result);
        log.info("[Service:AdmissionTypeService] searchByKeyword() succeeded - Found {} admission types",
                responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(AdmissionTypeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:AdmissionTypeService] softDeleteById() called - id: {}, organization: {}", id,
                organizationId);

        int result = admissionTypeRepository.softDeleteByIdAndOrganizationId(id, organizationId);
        if (result == 0) {
            throw new ApiException(AdmissionTypeErrors.ADMISSION_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:AdmissionTypeService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public AdmissionTypeResponseDTO createAdmissionType(AdmissionTypeCreateRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(AdmissionTypeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:AdmissionTypeService] createAdmissionType() called - Creating for organization: {}",
                organizationId);

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().isEmpty()) {
            if (admissionTypeRepository.existsByOrganizationIdAndCode(organizationId,
                    requestDTO.getCode().trim())) {
                throw new ApiException(AdmissionTypeErrors.DUPLICATE_ADMISSION_TYPE_CODE, HttpStatus.CONFLICT);
            }
        }

        AdmissionTypeEntity entity = AdmissionTypeMapper.toEntity(requestDTO);

        AdmissionTypeEntity saved = admissionTypeRepository.save(entity);

        log.info("[Service:AdmissionTypeService] createAdmissionType() succeeded - Admission type created with id: {}",
                saved.getId());
        return AdmissionTypeMapper.toResponseDTO(saved);
    }

    @Transactional
    public AdmissionTypeResponseDTO updateAdmissionType(Long id, AdmissionTypeCreateRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(AdmissionTypeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:AdmissionTypeService] updateAdmissionType() called - id: {}, organization: {}", id,
                organizationId);

        AdmissionTypeEntity existing = admissionTypeRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(
                        () -> new ApiException(AdmissionTypeErrors.ADMISSION_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().equals(existing.getCode())) {
            if (admissionTypeRepository.existsByOrganizationIdAndCodeAndIdNot(organizationId,
                    requestDTO.getCode().trim(), id)) {
                throw new ApiException(AdmissionTypeErrors.DUPLICATE_ADMISSION_TYPE_CODE, HttpStatus.CONFLICT);
            }
        }

        AdmissionTypeMapper.updateEntityFromDTO(existing, requestDTO);

        AdmissionTypeEntity updated = admissionTypeRepository.save(existing);

        log.info("[Service:AdmissionTypeService] updateAdmissionType() succeeded - id: {}", id);
        return AdmissionTypeMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(AdmissionTypeErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:AdmissionTypeService] getStatistics() called - organization: {}", organizationId);

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalAdmissionTypes", admissionTypeRepository.countByOrganizationId(organizationId));
        stats.put("activeAdmissionTypes", admissionTypeRepository.countByOrganizationIdAndIsActiveTrue(organizationId));
        stats.put("inactiveAdmissionTypes",
                admissionTypeRepository.countByOrganizationIdAndIsActiveFalse(organizationId));

        log.info("[Service:AdmissionTypeService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
