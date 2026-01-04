package com.smartsolutions.eschool.sclass.service;

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
        List<SectionEntity> result = sectionRepository.findByDeletedFalse();
        List<SectionDTO> sectionDTO = MapperUtil.mapList(result, SectionDTO.class);
        log.info("Successfully fetched sections");
        return sectionDTO;
    }

    public SectionDTO getById(Long id) {
        log.info("Fetching Section with id: {}", id);
        SectionEntity sectionEntity = sectionRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
            log.info("Fetching Section with id: {}", id);
            return new ResourceNotFoundException("Section not found with id: " + id);
        });
        SectionDTO sectionDTO = MapperUtil.mapObject(sectionEntity, SectionDTO.class);
        log.info("Successfully fetched Section: id={}", sectionDTO.getId());
        return sectionDTO;
    }

    public List<SectionDTO> getByStandardId(Long standardId) {
        log.info("Fetching all sections by standard id {} from database", standardId);
        List<SectionEntity> result = sectionRepository.findByStandardIdAndDeletedFalse(standardId);
        List<SectionDTO> sectionDTO = MapperUtil.mapList(result, SectionDTO.class);
        log.info("Successfully fetched sections by standard id {}", standardId);
        return sectionDTO;
    }

    public int softDeleteById(Long id) {
        log.info("Soft delete request received for Section ID: {}", id);
        try {
            return sectionRepository.softDeleteById(id);
        } catch (Exception e) {
            log.error("Error while soft deleting section with ID {}", id, e);
            throw e;
        }
    }

    public int softDeleteByStandardId(Long standardId) {
        log.info("Soft delete requested for sections under Standard ID: {}", standardId);
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
            throw e;
        }
    }

    public int softDeleteAll() {
        log.info("Soft delete ALL sections requested.");
        try {
            int rows = sectionRepository.softDeleteAll();
            if (rows == 0) {
                log.warn("Soft delete completed but no sections were updated.");
            } else {
                log.info("Successfully soft deleted ALL sections. Total affected: {}", rows);
            }
            return rows;
        } catch (Exception e) {
            log.error("Error occurred while soft deleting ALL sections", e);
            throw e;
        }
    }

    public List<SectionDTO> searchSections(Long campusId, Long standardId, String keyword) {
        log.info("Fetching all sections by keyword: {}", keyword);
        List<SectionEntity> result = sectionRepository.searchSections(campusId, standardId, keyword);
        if (result.isEmpty()) {
            log.info("No sections found for the given criteria.");
            return Collections.emptyList(); // Return empty list instead of throwing exception
        }
        List<SectionDTO> sectionDTO = MapperUtil.mapList(result, SectionDTO.class);
        log.info("Successfully fetched {} sections", sectionDTO.size());
        return sectionDTO;
    }

    public SectionCreateRequestDTO createSection(SectionCreateRequestDTO standardDTO) {
        log.info("Creating new Section: {}", standardDTO);
        try {
            SectionEntity entity = MapperUtil.mapObject(standardDTO, SectionEntity.class);
            entity.setId(null);
            entity.getStandard().setId(standardDTO.getStandardId());
            entity.setDeleted(false);
            entity.setDeletedAt(null);

            SectionEntity saved = sectionRepository.save(entity);
            SectionCreateRequestDTO responseDTO = MapperUtil.mapObject(saved, SectionCreateRequestDTO.class);

            log.info("Section created successfully with ID: {}", responseDTO.getId());

            return responseDTO;

        } catch (DataAccessException dae) {
            log.error("Database error while creating Section", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating Section", ex);
            throw ex;
        }
    }

    public SectionDTO updateSection(Long id, @Valid SectionCreateRequestDTO dto) {
        log.info("Updating Section with id {} using DTO {}", id, dto);

        SectionEntity entity = sectionRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Section not found with id: " + id));

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

        log.info("Section updated successfully: {}", response.getId());
        return response;
    }
}

