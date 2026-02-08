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
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
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


    public List<SectionDTO> getAll() {
        log.info("Fetching all sections from database");
        try {
            List<SectionEntity> result = sectionRepository.findByDeletedFalse();
            List<SectionDTO> sectionDTO = MapperUtil.mapList(result, SectionDTO.class);
            log.info("Successfully fetched {} sections", sectionDTO.size());
            return sectionDTO;
        } catch (Exception e) {
            log.error("Unexpected error while fetching all sections", e);
            throw new CustomServiceException("Failed to fetch all sections");
        }
    }

    public SectionDTO getById(Long id) {
        log.info("Fetching Section with id: {} from database", id);
        try {
            SectionEntity sectionEntity = sectionRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
                log.warn("Section not found with id: {}", id);
                return new ResourceNotFoundException("Section not found with id: " + id);
            });
            SectionDTO sectionDTO = MapperUtil.mapObject(sectionEntity, SectionDTO.class);
            log.info("Successfully fetched Section: id={}", sectionDTO.getId());
            return sectionDTO;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Section ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch Section by ID");
        }
    }

    public List<SectionDTO> getByStandardId(Long standardId) {
        log.info("Fetching all sections by standard id {} from database", standardId);
        try {
            List<SectionEntity> result = sectionRepository.findByStandardIdAndDeletedFalse(standardId);
            List<SectionDTO> sectionDTO = MapperUtil.mapList(result, SectionDTO.class);
            log.info("Successfully fetched {} sections for standard id {}", sectionDTO.size(), standardId);
            return sectionDTO;
        } catch (Exception e) {
            log.error("Unexpected error while fetching sections for standard id: {}", standardId, e);
            throw new CustomServiceException("Failed to fetch sections by standardId");
        }
    }

    public int softDeleteById(Long id) {
        log.info("Soft deleting Section with ID: {} from database", id);
        try {
            int result = sectionRepository.softDeleteById(id);
            if (result == 1) {
                log.info("Section deleted successfully with ID: {}", id);
            } else {
                log.warn("Failed to delete Section ID: {}", id);
            }
            return result;
        } catch (Exception e) {
            log.error("Error while soft deleting section with ID {}", id, e);
            throw new CustomServiceException("Failed to soft delete Section");
        }
    }

    public int softDeleteByStandardId(Long standardId) {
        log.info("Soft deleting sections under Standard ID: {} from database", standardId);
        try {
            int rows = sectionRepository.softDeleteByStandardId(standardId);
            if (rows == 0) {
                log.warn("No sections found for Standard ID {}. Nothing was updated.", standardId);
            } else {
                log.info("Soft delete succeeded. {} sections deleted for Standard ID {}", rows, standardId);
            }
            return rows;
        } catch (Exception e) {
            log.error("Error while soft deleting sections for Standard ID {}", standardId, e);
            throw new CustomServiceException("Failed to soft delete sections by standard");
        }
    }

    public int softDeleteAll() {
        log.info("Soft deleting ALL sections from database");
        try {
            int rows = sectionRepository.softDeleteAll();
            log.info("Successfully soft deleted ALL sections. Total affected: {}", rows);
            return rows;
        } catch (Exception e) {
            log.error("Error occurred while soft deleting ALL sections", e);
            throw new CustomServiceException("Failed to soft delete all sections");
        }
    }

    public List<SectionDTO> searchSections(Long campusId, Long standardId, String keyword) {
        log.info("Searching sections with campusId={}, standardId={}, keyword='{}' from database", campusId, standardId, keyword);
        try {
            List<SectionEntity> result = sectionRepository.searchSections(campusId, standardId, keyword);
            List<SectionDTO> sectionDTO = MapperUtil.mapList(result, SectionDTO.class);
            log.info("Successfully fetched {} sections based on search", sectionDTO.size());
            return sectionDTO;
        } catch (Exception e) {
            log.error("Unexpected error while searching sections", e);
            throw new CustomServiceException("Failed to search sections");
        }
    }

    public SectionCreateRequestDTO createSection(SectionCreateRequestDTO standardDTO) {
        log.info("Creating new Section in database: {}", standardDTO.getSectionName());
        try {
            SectionEntity entity = MapperUtil.mapObject(standardDTO, SectionEntity.class);
            entity.setId(null);
            if (entity.getStandard() == null) {
                entity.setStandard(new StandardEntity());
            }
            entity.getStandard().setId(standardDTO.getStandardId());
            entity.setDeleted(false);
            entity.setDeletedAt(null);

            SectionEntity saved = sectionRepository.save(entity);
            SectionCreateRequestDTO responseDTO = MapperUtil.mapObject(saved, SectionCreateRequestDTO.class);

            log.info("Section created successfully with ID: {}", responseDTO.getId());
            return responseDTO;
        } catch (Exception ex) {
            log.error("Unexpected error creating Section", ex);
            throw new CustomServiceException("Failed to create Section");
        }
    }

    public SectionDTO updateSection(Long id, @Valid SectionCreateRequestDTO dto) {
        log.info("Updating Section with id: {} in database", id);
        try {
            SectionEntity entity = sectionRepository.findByIdAndDeletedFalse(id)
                    .orElseThrow(() -> {
                        log.warn("Section not found with id: {}", id);
                        return new ResourceNotFoundException("Section not found with id: " + id);
                    });

            if (dto.getSectionName() != null && !dto.getSectionName().isBlank()) {
                entity.setSectionName(dto.getSectionName());
            }
            if (dto.getSectionCode() != null) {
                entity.setSectionCode(dto.getSectionCode());
            }

            if (dto.getStandardId() != null && (entity.getStandard() == null || !entity.getStandard().getId().equals(dto.getStandardId()))) {
                StandardEntity standardEntity = standardRepository.findByIdAndDeletedFalse(dto.getStandardId())
                        .orElseThrow(() -> new ResourceNotFoundException("Standard not found with id: " + dto.getStandardId()));
                entity.setStandard(standardEntity);
            }

            SectionEntity updated = sectionRepository.save(entity);
            SectionDTO response = MapperUtil.mapObject(updated, SectionDTO.class);

            log.info("Section updated successfully: id={}", response.getId());
            return response;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception ex) {
            log.error("Unexpected error while updating Section id: {}", id, ex);
            throw new CustomServiceException("Failed to update Section");
        }
    }
}

