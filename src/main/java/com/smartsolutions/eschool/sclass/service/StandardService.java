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

    public List<StandardDTO> getAll(Long organizationId) {
        log.info("Fetching all Standards from database for organization: {}", organizationId);
        try {
            List<StandardEntity> result = standardRepository.findByInstituteIdAndDeletedFalse(organizationId);
            List<StandardDTO> response = MapperUtil.mapList(result, StandardDTO.class);
            log.info("Successfully fetched {} Standards for organization: {}", response.size(), organizationId);
            return response;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Standards for organization: {}", organizationId, e);
            throw new CustomServiceException("Failed to fetch all Standards");
        }
    }

    public StandardDTO getById(Long id, Long organizationId) {
        log.info("Fetching Standard with id {} for organization {} from database", id, organizationId);
        try {
            StandardEntity standardEntity = standardRepository.findByIdAndInstituteIdAndDeletedFalse(id, organizationId)
                    .orElseThrow(() -> {
                        log.warn("Standard not found with id: {} for organization: {}", id, organizationId);
                        return new ResourceNotFoundException("Standard not found with id: " + id);
                    });
            StandardDTO response = MapperUtil.mapObject(standardEntity, StandardDTO.class);
            log.info("Successfully fetched Standard: id={} for organization: {}", response.getId(), organizationId);
            return response;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Standard ID: {} for organization: {}", id, organizationId, e);
            throw new CustomServiceException("Failed to fetch Standard by ID");
        }
    }

    public List<StandardDTO> findByCampusId(Long id, Long organizationId) {
        log.info("Fetching Standards with campus ID {} for organization {} from database", id, organizationId);
        try {
            if (id == null) {
                log.error("Campus ID is null");
                throw new IllegalArgumentException("Campus ID must not be null");
            }
            List<StandardEntity> results = standardRepository.findByCampusIdAndInstituteId(id, organizationId);
            List<StandardDTO> response = MapperUtil.mapList(results, StandardDTO.class);
            log.info("Successfully fetched {} Standards for campus ID: {} and organization: {}", response.size(), id,
                    organizationId);
            return response;
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Standards for campus ID: {} for organization: {}", id,
                    organizationId, e);
            throw new CustomServiceException("Failed to fetch Standards by campus ID");
        }
    }

    @Transactional
    public StandardCreateRequestDTO create(StandardCreateRequestDTO standardDTO, Long organizationId) {
        log.info("Creating new Standard: {} for organization: {} in database", standardDTO.getStandardName(),
                organizationId);
        try {
            StandardEntity entity = MapperUtil.mapObject(standardDTO, StandardEntity.class);
            entity.setId(null);

            if (standardDTO.getCampusId() != null) {
                // Verify that the campus belongs to the organization
                CampusEntity campus = campusRepository
                        .findByIdAndInstituteIdAndDeletedFalse(standardDTO.getCampusId(), organizationId)
                        .orElseThrow(() -> new ResourceNotFoundException("Campus not found with id: "
                                + standardDTO.getCampusId() + " for current organization"));
                entity.setCampus(campus);
            }

            StandardEntity saved = standardRepository.save(entity);
            StandardCreateRequestDTO responseDTO = MapperUtil.mapObject(saved, StandardCreateRequestDTO.class);
            log.info("Standard created successfully with id: {} for organization: {}", responseDTO.getId(),
                    organizationId);
            return responseDTO;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception ex) {
            log.error("Unexpected error while creating Standard: {} for organization: {}",
                    standardDTO.getStandardName(), organizationId, ex);
            throw new CustomServiceException("Failed to create Standard");
        }
    }

    @Transactional
    public int softDeleteById(Long id, Long organizationId) {
        log.info("Soft deleting Standard with id {} for organization {} from database", id, organizationId);
        try {
            if (standardRepository.findByIdAndInstituteIdAndDeletedFalse(id, organizationId).isEmpty()) {
                log.warn("Standard not found for soft deletion with id: {} for organization: {}", id, organizationId);
                throw new ResourceNotFoundException("Standard not found with id: " + id);
            }
            int result = standardRepository.softDeleteByIdAndInstituteId(id, organizationId);
            log.info("Standard soft deleted successfully: id={}, organization={}, rows updated={}", id, organizationId,
                    result);
            return result;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while soft deleting Standard ID: {} for organization: {}", id, organizationId,
                    e);
            throw new CustomServiceException("Failed to soft delete Standard");
        }
    }

    @Transactional
    public StandardDTO updateStandard(Long id, StandardCreateRequestDTO dto, Long organizationId) {
        log.info("Updating Standard with id {} for organization {} in database", id, organizationId);
        try {
            StandardEntity entity = standardRepository.findByIdAndInstituteIdAndDeletedFalse(id, organizationId)
                    .orElseThrow(() -> {
                        log.warn("Standard not found for update with id: {} for organization: {}", id, organizationId);
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

            if (dto.getCampusId() != null
                    && (entity.getCampus() == null || !entity.getCampus().getId().equals(dto.getCampusId()))) {
                CampusEntity campus = campusRepository
                        .findByIdAndInstituteIdAndDeletedFalse(dto.getCampusId(), organizationId)
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Campus not found with id: " + dto.getCampusId() + " for current organization"));
                entity.setCampus(campus);
            }

            StandardEntity updated = standardRepository.save(entity);
            StandardDTO response = MapperUtil.mapObject(updated, StandardDTO.class);
            log.info("Standard updated successfully: id={} for organization: {}", response.getId(), organizationId);
            return response;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception ex) {
            log.error("Unexpected error while updating Standard id: {} for organization: {}", id, organizationId, ex);
            throw new CustomServiceException("Failed to update Standard");
        }
    }

    public List<StandardDTO> searchByKeyword(String keyword, Long organizationId) {
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("Searching Standards with keyword: '{}' and organization: {} in database", searchKey, organizationId);
        try {
            List<StandardEntity> result = standardRepository.searchByKeywordAndInstituteId(searchKey, organizationId);
            List<StandardDTO> response = MapperUtil.mapList(result, StandardDTO.class);
            log.info("Successfully fetched {} Standards based on search for organization: {}", response.size(),
                    organizationId);
            return response;
        } catch (Exception e) {
            log.error("Unexpected error while searching Standards for organization: {}", organizationId, e);
            throw new CustomServiceException("Failed to search Standards");
        }
    }

    @Transactional
    public int sofDeleteByCampusId(Long campusId, Long organizationId) {
        log.info("Soft deleting Standards for campus ID {} and organization {} from database", campusId,
                organizationId);
        try {
            int rows = standardRepository.softDeleteByCampusIdAndInstituteId(campusId, organizationId);
            log.info("Soft deleted {} Standards for campus ID: {} and organization: {}", rows, campusId,
                    organizationId);
            return rows;
        } catch (Exception e) {
            log.error("Unexpected error while soft deleting Standards for campus ID: {} and organization: {}", campusId,
                    organizationId, e);
            throw new CustomServiceException("Failed to soft delete Standards by campus ID");
        }
    }

    public List<StandardDTO> getStandardByFilter(Long campusId, String keyword, Long organizationId) {
        String searchKey = keyword == null ? "" : keyword.trim();
        log.info("Searching Standards with campus ID {}, keyword '{}' and organization {} in database", campusId,
                searchKey, organizationId);
        try {
            List<StandardEntity> result = standardRepository.searchStandardsWithOrg(campusId, organizationId,
                    searchKey.isEmpty() ? null : searchKey);
            List<StandardDTO> response = MapperUtil.mapList(result, StandardDTO.class);
            log.info("Successfully fetched {} Standards by filter for organization: {}", response.size(),
                    organizationId);
            return response;
        } catch (Exception e) {
            log.error("Unexpected error while searching Standards by filter for organization: {}", organizationId, e);
            throw new CustomServiceException("Failed to search Standards by filter");
        }
    }
}
