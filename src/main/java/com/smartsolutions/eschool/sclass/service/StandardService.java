package com.smartsolutions.eschool.sclass.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.sclass.dtos.requestDto.StandardCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        try {
            log.info("Fetching all Standards from database");
            //List<CampusEntity> result = campusDao.findAll();
            List<StandardEntity> result = standardRepository.findByDeletedFalse();
            log.info("Successfully fetched {} Standards", result.size());
            List<StandardDTO> campusDTOList = MapperUtil.mapList(result, StandardDTO.class);
            log.info("Successfully fetched {} Standards", campusDTOList);
            return campusDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Standards", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to Standards", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Standards", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }

    public StandardDTO getById(Long id) {
        log.info("Fetching Standard with id: {}", id);
        StandardEntity standardEntity = standardRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
            log.info("Fetching Standard with id: {}", id);
            return new ResourceNotFoundException("Standard not found with id: " + id);
        });
        StandardDTO standardDTO = MapperUtil.mapObject(standardEntity, StandardDTO.class);
        log.info("Successfully fetched Standard: id={}", standardDTO.getId());
        return standardDTO;
    }

    public List<StandardDTO> findByCampusId(Long id) {
        log.info("Fetching Standard by campus ID: {}", id);
        if (id == null) {
            log.error("Campus ID is null");
            throw new IllegalArgumentException("Campus ID must not be null");
        }

        List<StandardEntity> standardEntities = standardRepository.findByCampusId(id);
        if (standardEntities.isEmpty()) {
            log.warn("No Standard found for Campus ID: {}", id);
            return List.of(); // safe empty list
        }
        List<StandardDTO> standardDTOList = MapperUtil.mapList(standardEntities, StandardDTO.class);
        log.info("Found {} standards for campus ID: {}", standardDTOList.size(), id);
        return standardDTOList;
    }

    public StandardCreateRequestDTO create(StandardCreateRequestDTO standardDTO) {
        log.info("Creating new Standard: {}", standardDTO);
        try {
            StandardEntity entity = MapperUtil.mapObject(standardDTO, StandardEntity.class);
            entity.setId(null);
            entity.getCampus().setId(standardDTO.getCampusId());
            entity.setDeleted(false);
            entity.setDeletedAt(null);

            StandardEntity saved = standardRepository.save(entity);
            StandardCreateRequestDTO responseDTO = MapperUtil.mapObject(saved, StandardCreateRequestDTO.class);

            log.info("Standard created successfully with ID: {}", responseDTO.getId());

            return responseDTO;

        } catch (DataAccessException dae) {
            log.error("Database error while creating standard", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating standard", ex);
            throw ex;
        }
    }

    public int softDeleteById(Long id) {
        log.info("Soft delete request received for Standard ID: {}", id);
        try {
            return standardRepository.softDeleteById(id);
        } catch (Exception e) {
            log.error("Error while soft deleting Standard with ID {}", id, e);
            throw e;
        }
    }

    @Transactional
    public StandardDTO updateStandard(Long id, StandardCreateRequestDTO dto) {
        log.info("Updating Standard with id {} using DTO {}", id, dto);

        StandardEntity entity = standardRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Standard not found with id: " + id));

        if (dto.getStandardName() != null && !dto.getStandardName().isBlank()) {
            entity.setStandardName(dto.getStandardName());
        }
        if (dto.getStandardCode() != null) {
            entity.setStandardCode(dto.getStandardCode());
        }
        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        if (dto.getCampusId() != null && (entity.getCampus() == null || !entity.getCampus().getId().equals(dto.getCampusId()))) {
            CampusEntity campus = campusRepository.findById(dto.getCampusId())
                    .orElseThrow(() -> new ResourceNotFoundException("Campus not found with id: " + dto.getCampusId()));
            entity.setCampus(campus);
        }

        StandardEntity updated = standardRepository.save(entity);

        StandardDTO response = MapperUtil.mapObject(updated, StandardDTO.class);

        log.info("Standard updated successfully: {}", response.getId());
        return response;
    }

    public List<StandardDTO> searchByKeyword(String keyword) {
        log.info("Fetching all Standard by keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            log.error("Keyword is null or empty");
            throw new ValidationException("Keyword must not be empty");
        }
        List<StandardEntity> result = standardRepository.searchByKeyword(keyword);
        if (result.isEmpty()) {
            log.warn("No Standard found for keyword: {}", keyword);
            throw new ResourceNotFoundException("No Standard found matching: " + keyword);
        }
        List<StandardDTO> standardDTOS = MapperUtil.mapList(result, StandardDTO.class);
        log.info("Successfully fetched {} Standard", standardDTOS.size());
        return standardDTOS;
    }

    public int sofDeleteByCampusId(Long campusId) {
            log.info("Delete requested for Standard under Campus ID: {}", campusId);
            try {
                int rows = standardRepository.softDeleteByCampusId(campusId);
                if (rows == 0) {
                    log.warn("No Standard found for Campus ID {}. Nothing was updated.", campusId);
                } else {
                    log.info("delete succeeded. {} Standards deleted for Campus ID {}", rows, campusId);
                }
                return rows;
            } catch (Exception e) {
                log.error("Error while deleting Standards for Campus ID {}", campusId, e);
                throw e;
            }
    }

    public List<StandardDTO> getStandardByFilter(Long campusId, String keyword) {
        log.info("Fetching Standards for campusId={} with keyword='{}'", campusId, keyword);

        try {
            String search = (keyword != null && !keyword.trim().isEmpty()) ? keyword.trim() : null;
            List<StandardEntity> result = standardRepository.searchStandards(campusId, search);
            if (result.isEmpty()) {
                log.warn("No Standards found for campusId={} with keyword='{}'", campusId, keyword);
                throw new ResourceNotFoundException("No Standards found matching the criteria");
            }
            List<StandardDTO> standardDTOS = MapperUtil.mapList(result, StandardDTO.class);
            log.info("Successfully fetched {} Standards", standardDTOS.size());
            return standardDTOS;

        } catch (Exception e) {
            log.error("Error fetching Standards for campusId={} with keyword='{}'", campusId, keyword, e);
            throw new CustomServiceException("Failed to fetch Standards", e);
        }
    }
}
