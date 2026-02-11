package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.sclass.dtos.requestDto.SectionCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.SectionRepository;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SectionService {
    private final SectionRepository sectionRepository;
    private final StandardRepository standardRepository;

    public SectionService(SectionRepository sectionRepository, StandardRepository standardRepository) {
        this.sectionRepository = sectionRepository;
        this.standardRepository = standardRepository;
    }

    public List<SectionDTO> getAll(Long organizationId) {
        log.info("Fetching all sections from database for organization: {}", organizationId);
        try {
            List<SectionEntity> result = sectionRepository.findByInstituteIdAndDeletedFalse(organizationId);
            List<SectionDTO> sectionDTO = MapperUtil.mapList(result, SectionDTO.class);
            log.info("Successfully fetched {} sections for organization: {}", sectionDTO.size(), organizationId);
            return sectionDTO;
        } catch (Exception e) {
            log.error("Unexpected error while fetching all sections for organization: {}", organizationId, e);
            throw new CustomServiceException("Failed to fetch all sections");
        }
    }

    public SectionDTO getById(Long id, Long organizationId) {
        log.info("Fetching Section with id: {} for organization: {} from database", id, organizationId);
        try {
            SectionEntity sectionEntity = sectionRepository.findByIdAndInstituteIdAndDeletedFalse(id, organizationId)
                    .orElseThrow(() -> {
                        log.warn("Section not found with id: {} for organization: {}", id, organizationId);
                        return new ResourceNotFoundException("Section not found with id: " + id);
                    });
            SectionDTO sectionDTO = MapperUtil.mapObject(sectionEntity, SectionDTO.class);
            log.info("Successfully fetched Section: id={} for organization: {}", sectionDTO.getId(), organizationId);
            return sectionDTO;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Section ID: {} for organization: {}", id, organizationId, e);
            throw new CustomServiceException("Failed to fetch Section by ID");
        }
    }

    public List<SectionDTO> getByStandardId(Long standardId, Long organizationId) {
        log.info("Fetching all sections by standard id {} and organization {} from database", standardId,
                organizationId);
        try {
            List<SectionEntity> result = sectionRepository.findByStandardIdAndInstituteIdAndDeletedFalse(standardId,
                    organizationId);
            List<SectionDTO> sectionDTO = MapperUtil.mapList(result, SectionDTO.class);
            log.info("Successfully fetched {} sections for standard id {} and organization {}", sectionDTO.size(),
                    standardId, organizationId);
            return sectionDTO;
        } catch (Exception e) {
            log.error("Unexpected error while fetching sections for standard id: {} and organization: {}", standardId,
                    organizationId, e);
            throw new CustomServiceException("Failed to fetch sections by standardId");
        }
    }

    public int softDeleteById(Long id, Long organizationId) {
        log.info("Soft deleting Section with ID: {} and organization: {} from database", id, organizationId);
        try {
            int result = sectionRepository.softDeleteByIdAndInstituteId(id, organizationId);
            if (result == 1) {
                log.info("Section deleted successfully with ID: {} and organization: {}", id, organizationId);
            } else {
                log.warn("Failed to delete Section ID: {} for organization: {}", id, organizationId);
            }
            return result;
        } catch (Exception e) {
            log.error("Error while soft deleting section with ID {} and organization: {}", id, organizationId, e);
            throw new CustomServiceException("Failed to soft delete Section");
        }
    }

    public int softDeleteByStandardId(Long standardId, Long organizationId) {
        log.info("Soft deleting sections under Standard ID: {} and organization: {} from database", standardId,
                organizationId);
        try {
            int rows = sectionRepository.softDeleteByStandardIdAndInstituteId(standardId, organizationId);
            if (rows == 0) {
                log.warn("No sections found for Standard ID {} and organization: {}. Nothing was updated.", standardId,
                        organizationId);
            } else {
                log.info("Soft delete succeeded. {} sections deleted for Standard ID {} and organization: {}", rows,
                        standardId, organizationId);
            }
            return rows;
        } catch (Exception e) {
            log.error("Error while soft deleting sections for Standard ID {} and organization: {}", standardId,
                    organizationId, e);
            throw new CustomServiceException("Failed to soft delete sections by standard");
        }
    }

    public int softDeleteAll(Long organizationId) {
        log.info("Soft deleting ALL sections from database for organization: {}", organizationId);
        try {
            int rows = sectionRepository.softDeleteByInstituteId(organizationId);
            log.info("Successfully soft deleted ALL sections for organization: {}. Total affected: {}", organizationId,
                    rows);
            return rows;
        } catch (Exception e) {
            log.error("Error occurred while soft deleting ALL sections for organization: {}", organizationId, e);
            throw new CustomServiceException("Failed to soft delete all sections");
        }
    }

    public List<SectionDTO> searchSections(Long campusId, Long standardId, String keyword, Long organizationId) {
        log.info("Searching sections with campusId={}, standardId={}, keyword='{}' and organization={} from database",
                campusId, standardId, keyword, organizationId);
        try {
            List<SectionEntity> result = sectionRepository.searchSectionsWithOrg(campusId, standardId, organizationId,
                    keyword);
            List<SectionDTO> sectionDTO = MapperUtil.mapList(result, SectionDTO.class);
            log.info("Successfully fetched {} sections based on search for organization: {}", sectionDTO.size(),
                    organizationId);
            return sectionDTO;
        } catch (Exception e) {
            log.error("Unexpected error while searching sections for organization: {}", organizationId, e);
            throw new CustomServiceException("Failed to search sections");
        }
    }

    public SectionCreateRequestDTO createSection(SectionCreateRequestDTO standardDTO, Long organizationId) {
        log.info("Creating new Section for organization {} in database: {}", organizationId,
                standardDTO.getSectionName());
        try {
            SectionEntity entity = MapperUtil.mapObject(standardDTO, SectionEntity.class);
            entity.setId(null);

            // Verify and set standard
            if (standardDTO.getStandardId() != null) {
                StandardEntity standardEntity = standardRepository
                        .findByIdAndInstituteIdAndDeletedFalse(standardDTO.getStandardId(), organizationId)
                        .orElseThrow(() -> new ResourceNotFoundException("Standard not found with id: "
                                + standardDTO.getStandardId() + " for current organization"));
                entity.setStandard(standardEntity);
            }

            entity.setDeleted(false);
            entity.setDeletedAt(null);

            SectionEntity saved = sectionRepository.save(entity);
            SectionCreateRequestDTO responseDTO = MapperUtil.mapObject(saved, SectionCreateRequestDTO.class);

            log.info("Section created successfully with ID: {} for organization: {}", responseDTO.getId(),
                    organizationId);
            return responseDTO;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception ex) {
            log.error("Unexpected error creating Section for organization: {}", organizationId, ex);
            throw new CustomServiceException("Failed to create Section");
        }
    }

    public SectionDTO updateSection(Long id, @Valid SectionCreateRequestDTO dto, Long organizationId) {
        log.info("Updating Section with id: {} for organization: {} in database", id, organizationId);
        try {
            SectionEntity entity = sectionRepository.findByIdAndInstituteIdAndDeletedFalse(id, organizationId)
                    .orElseThrow(() -> {
                        log.warn("Section not found with id: {} for organization: {}", id, organizationId);
                        return new ResourceNotFoundException("Section not found with id: " + id);
                    });

            if (dto.getSectionName() != null && !dto.getSectionName().isBlank()) {
                entity.setSectionName(dto.getSectionName());
            }
            if (dto.getSectionCode() != null) {
                entity.setSectionCode(dto.getSectionCode());
            }

            if (dto.getStandardId() != null
                    && (entity.getStandard() == null || !entity.getStandard().getId().equals(dto.getStandardId()))) {
                StandardEntity standardEntity = standardRepository
                        .findByIdAndInstituteIdAndDeletedFalse(dto.getStandardId(), organizationId)
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Standard not found with id: " + dto.getStandardId() + " for current organization"));
                entity.setStandard(standardEntity);
            }

            SectionEntity updated = sectionRepository.save(entity);
            SectionDTO response = MapperUtil.mapObject(updated, SectionDTO.class);

            log.info("Section updated successfully: id={} for organization: {}", response.getId(), organizationId);
            return response;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception ex) {
            log.error("Unexpected error while updating Section id: {} for organization: {}", id, organizationId, ex);
            throw new CustomServiceException("Failed to update Section");
        }
    }
}
