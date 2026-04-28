package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.sclass.dtos.requestDto.SectionCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.error.SectionErrors;
import com.smartsolutions.eschool.sclass.error.StandardErrors;
import com.smartsolutions.eschool.sclass.mapper.SectionMapper;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.SectionRepository;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class SectionService {
    private final SectionRepository sectionRepository;
    private final StandardRepository standardRepository;

    public SectionService(SectionRepository sectionRepository, StandardRepository standardRepository) {
        this.sectionRepository = sectionRepository;
        this.standardRepository = standardRepository;
    }

    public List<SectionDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(SectionErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:SectionService] getAll() called - Fetching all sections for organization: {}",
                organizationId);
        List<SectionEntity> result = sectionRepository.findByInstituteIdAndDeletedFalse(organizationId);
        List<SectionDTO> sectionDTO = SectionMapper.toResponseDTOList(result);
        log.info("[Service:SectionService] getAll() succeeded - Found {} sections for organization: {}",
                sectionDTO.size(), organizationId);
        return sectionDTO;
    }

    public SectionDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(SectionErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:SectionService] getById() called - id: {}, organization: {}", id, organizationId);
        SectionEntity sectionEntity = sectionRepository.findByIdAndInstituteIdAndDeletedFalse(id, organizationId)
                .orElseThrow(() -> {
                    log.warn("Section not found with id: {} for organization: {}", id, organizationId);
                    return new ApiException(SectionErrors.SECTION_NOT_FOUND, HttpStatus.NOT_FOUND);
                });
        SectionDTO sectionDTO = SectionMapper.toResponseDTO(sectionEntity);
        log.info("[Service:SectionService] getById() succeeded - Found Section: id={} for organization: {}",
                sectionDTO.getId(), organizationId);
        return sectionDTO;
    }

    public List<SectionDTO> getByStandardId(Long standardId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(SectionErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:SectionService] getByStandardId() called - standardId: {}, organization: {}", standardId,
                organizationId);
        List<SectionEntity> result = sectionRepository.findByStandardIdAndInstituteIdAndDeletedFalse(standardId,
                organizationId);
        List<SectionDTO> sectionDTO = SectionMapper.toResponseDTOList(result);
        log.info(
                "[Service:SectionService] getByStandardId() succeeded - Found {} sections for standardId: {} and organization: {}",
                sectionDTO.size(), standardId, organizationId);
        return sectionDTO;
    }

    @Transactional
    public int softDeleteById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(SectionErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:SectionService] softDeleteById() called - id: {}, organization: {}", id, organizationId);

        if (sectionRepository.findByIdAndInstituteIdAndDeletedFalse(id, organizationId).isEmpty()) {
            throw new ApiException(SectionErrors.SECTION_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        int result = sectionRepository.softDeleteByIdAndInstituteId(id, organizationId);
        log.info("[Service:SectionService] softDeleteById() succeeded - id: {}", id);
        return result;
    }

    @Transactional
    public int softDeleteByStandardId(Long standardId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(SectionErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:SectionService] softDeleteByStandardId() called - standardId: {}, organization: {}",
                standardId, organizationId);
        int rows = sectionRepository.softDeleteByStandardIdAndInstituteId(standardId, organizationId);
        log.info("[Service:SectionService] softDeleteByStandardId() succeeded - Deleted {} sections", rows);
        return rows;
    }

    @Transactional
    public int softDeleteAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(SectionErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:SectionService] softDeleteAll() called - organization: {}", organizationId);
        int rows = sectionRepository.softDeleteByInstituteId(organizationId);
        log.info("[Service:SectionService] softDeleteAll() succeeded - Deleted {} sections", rows);
        return rows;
    }

    public List<SectionDTO> searchSections(Long campusId, Long standardId, String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(SectionErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info(
                "[Service:SectionService] searchSections() called - campusId={}, standardId={}, keyword='{}', organization={}",
                campusId, standardId, searchKey, organizationId);
        List<SectionEntity> result = sectionRepository.searchSectionsWithOrg(campusId, standardId, organizationId,
                searchKey.isEmpty() ? null : searchKey);
        List<SectionDTO> sectionDTO = SectionMapper.toResponseDTOList(result);
        log.info(
                "[Service:SectionService] searchSections() succeeded - Found {} sections based on search for organization: {}",
                sectionDTO.size(), organizationId);
        return sectionDTO;
    }

    @Transactional
    public SectionCreateRequestDTO createSection(SectionCreateRequestDTO sectionDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(SectionErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:SectionService] createSection() called - Creating new Section for organization: {}",
                organizationId);

        if (sectionDTO.getStandardId() == null) {
            throw new ApiException(SectionErrors.INVALID_SECTION_DATA, "Standard ID is required",
                    HttpStatus.BAD_REQUEST);
        }

        if (sectionDTO.getSectionCode() != null && !sectionDTO.getSectionCode().trim().isEmpty()) {
            if (sectionRepository.existsByInstituteIdAndStandardIdAndSectionCode(organizationId,
                    sectionDTO.getStandardId(),
                    sectionDTO.getSectionCode().trim())) {
                throw new ApiException(SectionErrors.DUPLICATE_SECTION_CODE, HttpStatus.CONFLICT);
            }
        }

        if (sectionDTO.getSectionName() != null && !sectionDTO.getSectionName().trim().isEmpty()) {
            if (sectionRepository.existsByInstituteIdAndStandardIdAndSectionName(organizationId,
                    sectionDTO.getStandardId(),
                    sectionDTO.getSectionName().trim())) {
                throw new ApiException(SectionErrors.INVALID_SECTION_DATA, "Section with this name already exists",
                        HttpStatus.CONFLICT);
            }
        }

        SectionEntity entity = SectionMapper.toEntity(sectionDTO);

        StandardEntity standardEntity = standardRepository
                .findByIdAndInstituteIdAndDeletedFalse(sectionDTO.getStandardId(), organizationId)
                .orElseThrow(() -> new ApiException(StandardErrors.STANDARD_NOT_FOUND, HttpStatus.NOT_FOUND));
        entity.setStandard(standardEntity);

        SectionEntity saved = sectionRepository.save(entity);

        SectionCreateRequestDTO responseDTO = new SectionCreateRequestDTO();
        responseDTO.setId(saved.getId());
        responseDTO.setSectionName(saved.getSectionName());
        responseDTO.setSectionCode(saved.getSectionCode());
        responseDTO.setStandardId(saved.getStandard().getId());
        responseDTO.setCampusId(saved.getStandard().getCampus().getId());

        log.info(
                "[Service:SectionService] createSection() succeeded - Section created successfully with ID: {} for organization: {}",
                responseDTO.getId(), organizationId);
        return responseDTO;
    }

    @Transactional
    public SectionDTO updateSection(Long id, @Valid SectionCreateRequestDTO dto) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(SectionErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:SectionService] updateSection() called - id: {}, organization: {}", id, organizationId);

        SectionEntity entity = sectionRepository.findByIdAndInstituteIdAndDeletedFalse(id, organizationId)
                .orElseThrow(() -> {
                    log.warn("Section not found with id: {} for organization: {}", id, organizationId);
                    return new ApiException(SectionErrors.SECTION_NOT_FOUND, HttpStatus.NOT_FOUND);
                });

        Long targetStandardId = dto.getStandardId() != null ? dto.getStandardId() : entity.getStandard().getId();

        if (dto.getSectionCode() != null && !dto.getSectionCode().trim().equals(entity.getSectionCode())) {
            if (sectionRepository.existsByInstituteIdAndStandardIdAndSectionCodeAndIdNot(organizationId,
                    targetStandardId,
                    dto.getSectionCode().trim(), id)) {
                throw new ApiException(SectionErrors.DUPLICATE_SECTION_CODE, HttpStatus.CONFLICT);
            }
        }

        if (dto.getSectionName() != null && !dto.getSectionName().trim().equals(entity.getSectionName())) {
            if (sectionRepository.existsByInstituteIdAndStandardIdAndSectionNameAndIdNot(organizationId,
                    targetStandardId,
                    dto.getSectionName().trim(), id)) {
                throw new ApiException(SectionErrors.INVALID_SECTION_DATA, "Section with this name already exists",
                        HttpStatus.CONFLICT);
            }
        }

        SectionMapper.updateEntityFromDTO(entity, dto);

        if (dto.getStandardId() != null
                && (entity.getStandard() == null || !entity.getStandard().getId().equals(dto.getStandardId()))) {
            StandardEntity standardEntity = standardRepository
                    .findByIdAndInstituteIdAndDeletedFalse(dto.getStandardId(), organizationId)
                    .orElseThrow(() -> new ApiException(StandardErrors.STANDARD_NOT_FOUND, HttpStatus.NOT_FOUND));
            entity.setStandard(standardEntity);
        }

        SectionEntity updated = sectionRepository.save(entity);
        SectionDTO response = SectionMapper.toResponseDTO(updated);

        log.info("[Service:SectionService] updateSection() succeeded - id={} for organization: {}", response.getId(),
                organizationId);
        return response;
    }
}
