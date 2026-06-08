package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.student.error.GuardianRelationErrors;
import com.smartsolutions.eschool.student.dtos.guardianRelation.requestDto.GuardianRelationCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.guardianRelation.responseDto.GuardianRelationResponseDTO;
import com.smartsolutions.eschool.student.mapper.GuardianRelationMapper;
import com.smartsolutions.eschool.student.model.GuardianRelationEntity;
import com.smartsolutions.eschool.student.repository.GuardianRelationRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.smartsolutions.eschool.global.utils.EntityReferenceValidator;

@Service
@Slf4j
public class GuardianRelationService {

    private final GuardianRelationRepository guardianRelationRepository;
    private com.smartsolutions.eschool.global.utils.EntityReferenceValidator entityReferenceValidator;

    public GuardianRelationService(GuardianRelationRepository guardianRelationRepository,
                             com.smartsolutions.eschool.global.utils.EntityReferenceValidator entityReferenceValidator) {
        this.entityReferenceValidator = entityReferenceValidator;

        this.guardianRelationRepository = guardianRelationRepository;
    }

    public List<GuardianRelationResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianRelationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianRelationService] getAll() called - Fetching all for organization: {}", organizationId);
        List<GuardianRelationEntity> result = guardianRelationRepository.findAllByOrganizationId(organizationId);
        List<GuardianRelationResponseDTO> responseDTOs = GuardianRelationMapper.toResponseDTOList(result);
        log.info("[Service:GuardianRelationService] getAll() succeeded - Found {} guardian relations", responseDTOs.size());
        return responseDTOs;
    }

    public List<GuardianRelationResponseDTO> getActive() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianRelationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianRelationService] getActive() called - organization: {}", organizationId);
        List<GuardianRelationEntity> result = guardianRelationRepository.findAllByOrganizationIdAndIsActiveTrue(organizationId);
        List<GuardianRelationResponseDTO> responseDTOs = GuardianRelationMapper.toResponseDTOList(result);
        log.info("[Service:GuardianRelationService] getActive() succeeded - Found {} active guardian relations", responseDTOs.size());
        return responseDTOs;
    }

    public List<GuardianRelationResponseDTO> getInactive() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianRelationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianRelationService] getInactive() called - organization: {}", organizationId);
        List<GuardianRelationEntity> result = guardianRelationRepository.findAllByOrganizationIdAndIsActiveFalse(organizationId);
        List<GuardianRelationResponseDTO> responseDTOs = GuardianRelationMapper.toResponseDTOList(result);
        log.info("[Service:GuardianRelationService] getInactive() succeeded - Found {} inactive guardian relations", responseDTOs.size());
        return responseDTOs;
    }

    public GuardianRelationResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianRelationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianRelationService] getById() called - id: {}, organization: {}", id, organizationId);
        GuardianRelationEntity entity = guardianRelationRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(GuardianRelationErrors.GUARDIAN_RELATION_NOT_FOUND, HttpStatus.NOT_FOUND));

        GuardianRelationResponseDTO responseDTO = GuardianRelationMapper.toResponseDTO(entity);
        log.info("[Service:GuardianRelationService] getById() succeeded - Found guardian relation: {}", id);
        return responseDTO;
    }

    public List<GuardianRelationResponseDTO> searchByKeyword(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianRelationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianRelationService] searchByKeyword() called - keyword: {}, organization: {}", keyword, organizationId);
        List<GuardianRelationEntity> result = guardianRelationRepository.searchByKeywordAndOrganizationId(keyword, organizationId);
        List<GuardianRelationResponseDTO> responseDTOs = GuardianRelationMapper.toResponseDTOList(result);
        log.info("[Service:GuardianRelationService] searchByKeyword() succeeded - Found {} guardian relations", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
        entityReferenceValidator.ensureNotReferenced(GuardianRelationEntity.class, id);
            throw new ApiException(GuardianRelationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianRelationService] softDeleteById() called - id: {}, organization: {}", id, organizationId);

        int result = guardianRelationRepository.softDeleteByIdAndOrganizationId(id, organizationId);
        if (result == 0) {
            throw new ApiException(GuardianRelationErrors.GUARDIAN_RELATION_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:GuardianRelationService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public GuardianRelationResponseDTO createGuardianRelation(GuardianRelationCreateRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianRelationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianRelationService] createGuardianRelation() called - Creating for organization: {}", organizationId);

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().isEmpty()) {
            if (guardianRelationRepository.existsByOrganizationIdAndCode(organizationId, requestDTO.getCode().trim())) {
                throw new ApiException(GuardianRelationErrors.DUPLICATE_GUARDIAN_RELATION_CODE, HttpStatus.CONFLICT);
            }
        }
        
        if (requestDTO.getName() != null && !requestDTO.getName().trim().isEmpty()) {
            if (guardianRelationRepository.existsByOrganizationIdAndName(organizationId, requestDTO.getName().trim())) {
                throw new ApiException(GuardianRelationErrors.DUPLICATE_GUARDIAN_RELATION_NAME, HttpStatus.CONFLICT);
            }
        }

        GuardianRelationEntity entity = GuardianRelationMapper.toEntity(requestDTO);

        GuardianRelationEntity saved = guardianRelationRepository.save(entity);

        log.info("[Service:GuardianRelationService] createGuardianRelation() succeeded - created with id: {}", saved.getId());
        return GuardianRelationMapper.toResponseDTO(saved);
    }

    @Transactional
    public GuardianRelationResponseDTO updateGuardianRelation(Long id, GuardianRelationCreateRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianRelationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianRelationService] updateGuardianRelation() called - id: {}, organization: {}", id, organizationId);

        GuardianRelationEntity existing = guardianRelationRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ApiException(GuardianRelationErrors.GUARDIAN_RELATION_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().equals(existing.getCode())) {
            if (guardianRelationRepository.existsByOrganizationIdAndCodeAndIdNot(organizationId, requestDTO.getCode().trim(), id)) {
                throw new ApiException(GuardianRelationErrors.DUPLICATE_GUARDIAN_RELATION_CODE, HttpStatus.CONFLICT);
            }
        }
        
        if (requestDTO.getName() != null && !requestDTO.getName().trim().equals(existing.getName())) {
            if (guardianRelationRepository.existsByOrganizationIdAndNameAndIdNot(organizationId, requestDTO.getName().trim(), id)) {
                throw new ApiException(GuardianRelationErrors.DUPLICATE_GUARDIAN_RELATION_NAME, HttpStatus.CONFLICT);
            }
        }

        GuardianRelationMapper.updateEntityFromDTO(existing, requestDTO);

        GuardianRelationEntity updated = guardianRelationRepository.save(existing);

        log.info("[Service:GuardianRelationService] updateGuardianRelation() succeeded - id: {}", id);
        return GuardianRelationMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(GuardianRelationErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:GuardianRelationService] getStatistics() called - organization: {}", organizationId);

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalGuardianRelations", guardianRelationRepository.countByOrganizationId(organizationId));
        stats.put("activeGuardianRelations", guardianRelationRepository.countByOrganizationIdAndIsActiveTrue(organizationId));
        stats.put("inactiveGuardianRelations", guardianRelationRepository.countByOrganizationIdAndIsActiveFalse(organizationId));

        log.info("[Service:GuardianRelationService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
