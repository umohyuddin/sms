package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.CampusErrors;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.sclass.dtos.requestDto.StandardCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.sclass.error.StandardErrors;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.sclass.mapper.StandardMapper;
import com.smartsolutions.eschool.util.SecurityUtils;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StandardService {
    private final StandardRepository standardRepository;
    private final CampusRepository campusRepository;

    public StandardService(StandardRepository standardRepository, CampusRepository campusRepository) {
        this.standardRepository = standardRepository;
        this.campusRepository = campusRepository;
    }

    public List<StandardDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StandardErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StandardService] getAll() called - Fetching all for institute: {}", organizationId);
        List<StandardEntity> result = standardRepository.findByInstituteIdAndDeletedFalse(organizationId);
        List<StandardDTO> response = StandardMapper.toResponseDTOList(result);
        log.info("[Service:StandardService] getAll() succeeded - Found {} standards", response.size());
        return response;
    }

    public StandardDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StandardErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StandardService] getById() called - id: {}, institute: {}", id, organizationId);
        StandardEntity standardEntity = standardRepository.findByIdAndInstituteIdAndDeletedFalse(id, organizationId)
                .orElseThrow(() -> new ApiException(StandardErrors.STANDARD_NOT_FOUND, HttpStatus.NOT_FOUND));
        StandardDTO response = StandardMapper.toResponseDTO(standardEntity);
        log.info("[Service:StandardService] getById() succeeded - Found standard: {}", id);
        return response;
    }

    public List<StandardDTO> findByCampusId(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StandardErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info(
                "[Service:StandardService] findByCampusId() called - Fetching standards with campus ID {} for institute: {}",
                id, organizationId);
        if (id == null) {
            throw new ApiException(StandardErrors.INVALID_STANDARD_DATA, HttpStatus.BAD_REQUEST);
        }
        List<StandardEntity> results = standardRepository.findByCampusIdAndInstituteId(id, organizationId);
        List<StandardDTO> response = StandardMapper.toResponseDTOList(results);
        log.info("[Service:StandardService] findByCampusId() succeeded - Found {} standards", response.size());
        return response;
    }

    @Transactional
    public StandardCreateRequestDTO create(StandardCreateRequestDTO standardDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StandardErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StandardService] create() called - Creating for institute: {}", organizationId);

        if (standardDTO.getStandardCode() != null && !standardDTO.getStandardCode().trim().isEmpty()) {
            if (standardRepository.existsByInstituteIdAndStandardCode(organizationId,
                    standardDTO.getStandardCode().trim())) {
                throw new ApiException(StandardErrors.DUPLICATE_STANDARD_CODE, HttpStatus.CONFLICT);
            }
        }

        if (standardDTO.getStandardName() != null && !standardDTO.getStandardName().trim().isEmpty()) {
            if (standardRepository.existsByInstituteIdAndStandardName(organizationId,
                    standardDTO.getStandardName().trim())) {
                throw new ApiException(StandardErrors.INVALID_STANDARD_DATA, "Standard with this name already exists",
                        HttpStatus.CONFLICT);
            }
        }

        StandardEntity entity = StandardMapper.toEntity(standardDTO);

        if (standardDTO.getCampusId() != null) {
            CampusEntity campus = campusRepository
                    .findByIdAndInstituteId(standardDTO.getCampusId(), organizationId)
                    .orElseThrow(() -> new ApiException(CampusErrors.CAMPUS_NOT_FOUND, HttpStatus.NOT_FOUND));
            entity.setCampus(campus);
        }

        StandardEntity saved = standardRepository.save(entity);
        StandardCreateRequestDTO responseDTO = new StandardCreateRequestDTO();
        responseDTO.setId(saved.getId());
        responseDTO.setStandardName(saved.getStandardName());
        responseDTO.setStandardCode(saved.getStandardCode());
        responseDTO.setDescription(saved.getDescription());
        responseDTO.setCampusId(saved.getCampus() != null ? saved.getCampus().getId() : null);

        log.info("[Service:StandardService] create() succeeded - Standard created with id: {}", responseDTO.getId());
        return responseDTO;
    }

    @Transactional
    public int softDeleteById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StandardErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StandardService] softDeleteById() called - id: {}, institute: {}", id, organizationId);

        if (standardRepository.findByIdAndInstituteIdAndDeletedFalse(id, organizationId).isEmpty()) {
            throw new ApiException(StandardErrors.STANDARD_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        int result = standardRepository.softDeleteByIdAndInstituteId(id, organizationId);
        log.info("[Service:StandardService] softDeleteById() succeeded - id: {}", id);
        return result;
    }

    @Transactional
    public StandardDTO updateStandard(Long id, StandardCreateRequestDTO dto) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StandardErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StandardService] updateStandard() called - id: {}, institute: {}", id, organizationId);

        StandardEntity entity = standardRepository.findByIdAndInstituteIdAndDeletedFalse(id, organizationId)
                .orElseThrow(() -> new ApiException(StandardErrors.STANDARD_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (dto.getStandardCode() != null && !dto.getStandardCode().trim().equals(entity.getStandardCode())) {
            if (standardRepository.existsByInstituteIdAndStandardCodeAndIdNot(organizationId,
                    dto.getStandardCode().trim(), id)) {
                throw new ApiException(StandardErrors.DUPLICATE_STANDARD_CODE, HttpStatus.CONFLICT);
            }
        }

        if (dto.getStandardName() != null && !dto.getStandardName().trim().equals(entity.getStandardName())) {
            if (standardRepository.existsByInstituteIdAndStandardNameAndIdNot(organizationId,
                    dto.getStandardName().trim(), id)) {
                throw new ApiException(StandardErrors.INVALID_STANDARD_DATA, "Standard with this name already exists",
                        HttpStatus.CONFLICT);
            }
        }

        if (dto.getStandardName() != null && !dto.getStandardName().isBlank()) {
            entity.setStandardName(dto.getStandardName());
        }
        if (dto.getStandardCode() != null) {
            entity.setStandardCode(dto.getStandardCode());
        }
        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        if (dto.getCampusId() != null
                && (entity.getCampus() == null || !entity.getCampus().getId().equals(dto.getCampusId()))) {
            CampusEntity campus = campusRepository
                    .findByIdAndInstituteId(dto.getCampusId(), organizationId)
                    .orElseThrow(() -> new ApiException(CampusErrors.CAMPUS_NOT_FOUND, HttpStatus.NOT_FOUND));
            entity.setCampus(campus);
        }

        StandardEntity updated = standardRepository.save(entity);
        StandardDTO response = StandardMapper.toResponseDTO(updated);
        log.info("[Service:StandardService] updateStandard() succeeded - id: {}", response.getId());
        return response;
    }

    public List<StandardDTO> searchByKeyword(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StandardErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("[Service:StandardService] searchByKeyword() called - keyword: {}, institute: {}", searchKey,
                organizationId);
        List<StandardEntity> result = standardRepository.searchByKeywordAndInstituteId(searchKey, organizationId);
        List<StandardDTO> response = StandardMapper.toResponseDTOList(result);
        log.info("[Service:StandardService] searchByKeyword() succeeded - Found {} standards", response.size());
        return response;
    }

    @Transactional
    public int sofDeleteByCampusId(Long campusId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StandardErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StandardService] sofDeleteByCampusId() called - campus id: {}, institute: {}", campusId,
                organizationId);
        int rows = standardRepository.softDeleteByCampusIdAndInstituteId(campusId, organizationId);
        log.info("[Service:StandardService] sofDeleteByCampusId() succeeded - Soft deleted {} standards", rows);
        return rows;
    }

    public List<StandardDTO> getStandardByFilter(Long campusId, String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StandardErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("[Service:StandardService] getStandardByFilter() called - campus id: {}, keyword: '{}', institute: {}",
                campusId, searchKey, organizationId);
        List<StandardEntity> result = standardRepository.searchStandardsWithOrg(campusId, organizationId,
                searchKey.isEmpty() ? null : searchKey);
        List<StandardDTO> response = StandardMapper.toResponseDTOList(result);
        log.info("[Service:StandardService] getStandardByFilter() succeeded - Found {} standards", response.size());
        return response;
    }
}
