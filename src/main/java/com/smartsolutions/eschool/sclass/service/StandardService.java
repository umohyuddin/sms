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

import java.util.ArrayList;
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
        log.info("Fetching all Standards from database");
        try {
            List<StandardEntity> result = standardRepository.findByDeletedFalse();
            List<StandardDTO> response = MapperUtil.mapList(result, StandardDTO.class);
            log.info("Successfully fetched {} Standards", response.size());
            return response;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Standards", e);
            throw new CustomServiceException("Failed to fetch all Standards");
        }
    }

    public StandardDTO getById(Long id) {
        log.info("Fetching Standard with id {} from database", id);
        try {
            StandardEntity standardEntity = standardRepository.findByIdAndDeletedFalse(id)
                    .orElseThrow(() -> {
                        log.warn("Standard not found with id: {}", id);
                        return new ResourceNotFoundException("Standard not found with id: " + id);
                    });
            StandardDTO response = MapperUtil.mapObject(standardEntity, StandardDTO.class);
            log.info("Successfully fetched Standard: id={}", response.getId());
            return response;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Standard ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch Standard by ID");
        }
    }

    public List<StandardDTO> findByCampusId(Long id) {
        log.info("Fetching Standards with campus ID {} from database", id);
        try {
            if (id == null) {
                log.error("Campus ID is null");
                throw new IllegalArgumentException("Campus ID must not be null");
            }
            List<StandardEntity> results = standardRepository.findByCampusId(id);
            List<StandardDTO> response = MapperUtil.mapList(results, StandardDTO.class);
            log.info("Successfully fetched {} Standards for campus ID: {}", response.size(), id);
            return response;
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Standards for campus ID: {}", id, e);
            throw new CustomServiceException("Failed to fetch Standards by campus ID");
        }
    }

    @Transactional
    public StandardCreateRequestDTO create(StandardCreateRequestDTO standardDTO) {
        log.info("Creating new Standard: {} in database", standardDTO.getStandardName());
        try {
            StandardEntity entity = MapperUtil.mapObject(standardDTO, StandardEntity.class);
            entity.setId(null);
            
            if (standardDTO.getCampusId() != null) {
                CampusEntity campus = campusRepository.findById(standardDTO.getCampusId())
                        .orElseThrow(() -> new ResourceNotFoundException("Campus not found with id: " + standardDTO.getCampusId()));
                entity.setCampus(campus);
            }

            StandardEntity saved = standardRepository.save(entity);
            StandardCreateRequestDTO responseDTO = MapperUtil.mapObject(saved, StandardCreateRequestDTO.class);
            log.info("Standard created successfully with id: {}", responseDTO.getId());
            return responseDTO;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception ex) {
            log.error("Unexpected error while creating Standard: {}", standardDTO.getStandardName(), ex);
            throw new CustomServiceException("Failed to create Standard");
        }
    }

    @Transactional
    public int softDeleteById(Long id) {
        log.info("Soft deleting Standard with id {} from database", id);
        try {
            if (standardRepository.findByIdAndDeletedFalse(id).isEmpty()) {
                log.warn("Standard not found for soft deletion with id: {}", id);
                throw new ResourceNotFoundException("Standard not found with id: " + id);
            }
            int result = standardRepository.softDeleteById(id);
            log.info("Standard soft deleted successfully: id={}, rows updated={}", id, result);
            return result;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while soft deleting Standard ID: {}", id, e);
            throw new CustomServiceException("Failed to soft delete Standard");
        }
    }

    @Transactional
    public StandardDTO updateStandard(Long id, StandardCreateRequestDTO dto) {
        log.info("Updating Standard with id {} in database", id);
        try {
            StandardEntity entity = standardRepository.findByIdAndDeletedFalse(id)
                    .orElseThrow(() -> {
                        log.warn("Standard not found for update with id: {}", id);
                        return new ResourceNotFoundException("Standard not found with id: " + id);
                    });

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
            log.info("Standard updated successfully: id={}", response.getId());
            return response;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception ex) {
            log.error("Unexpected error while updating Standard id: {}", id, ex);
            throw new CustomServiceException("Failed to update Standard");
        }
    }

    public List<StandardDTO> searchByKeyword(String keyword) {
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("Searching Standards with keyword: '{}' in database", searchKey);
        try {
            List<StandardEntity> result = standardRepository.searchByKeyword(searchKey);
            List<StandardDTO> response = MapperUtil.mapList(result, StandardDTO.class);
            log.info("Successfully fetched {} Standards based on search", response.size());
            return response;
        } catch (Exception e) {
            log.error("Unexpected error while searching Standards", e);
            throw new CustomServiceException("Failed to search Standards");
        }
    }

    @Transactional
    public int sofDeleteByCampusId(Long campusId) {
        log.info("Soft deleting Standards for campus ID {} from database", campusId);
        try {
            int rows = standardRepository.softDeleteByCampusId(campusId);
            log.info("Soft deleted {} Standards for campus ID: {}", rows, campusId);
            return rows;
        } catch (Exception e) {
            log.error("Unexpected error while soft deleting Standards for campus ID: {}", campusId, e);
            throw new CustomServiceException("Failed to soft delete Standards by campus ID");
        }
    }

    public List<StandardDTO> getStandardByFilter(Long campusId, String keyword) {
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("Searching Standards with campus ID {} and keyword '{}' in database", campusId, searchKey);
        try {
            List<StandardEntity> result = standardRepository.searchStandards(campusId, searchKey.isEmpty() ? null : searchKey);
            List<StandardDTO> response = MapperUtil.mapList(result, StandardDTO.class);
            log.info("Successfully fetched {} Standards by filter", response.size());
            return response;
        } catch (Exception e) {
            log.error("Unexpected error while searching Standards by filter", e);
            throw new CustomServiceException("Failed to search Standards by filter");
        }
    }
}
