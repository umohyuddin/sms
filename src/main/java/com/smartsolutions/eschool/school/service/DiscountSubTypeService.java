package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.discountSubType.requestDto.DiscountSubTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountSubType.responseDto.DiscountSubTypeResponseDTO;
import com.smartsolutions.eschool.school.mapper.DiscountSubTypeMapper;
import com.smartsolutions.eschool.school.model.DiscountSubTypeEntity;
import com.smartsolutions.eschool.school.model.DiscountTypeEntity;
import com.smartsolutions.eschool.school.repository.DiscountSubTypeRepository;
import com.smartsolutions.eschool.school.repository.DiscountTypeRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class DiscountSubTypeService {
    private final DiscountSubTypeRepository discountSubTypeRepository;
    private final DiscountTypeRepository discountTypeRepository;

    public DiscountSubTypeService(DiscountSubTypeRepository discountSubTypeRepository,
            DiscountTypeRepository discountTypeRepository) {
        this.discountSubTypeRepository = discountSubTypeRepository;
        this.discountTypeRepository = discountTypeRepository;
    }

    @Transactional
    public DiscountSubTypeResponseDTO create(@Valid DiscountSubTypeRequestDTO requestDTO) {
        log.info("Creating new Discount Sub Type: {}", requestDTO.getName());
        try {
            DiscountTypeEntity discountType = discountTypeRepository
                    .findByIdAndDeletedFalse(requestDTO.getDiscountTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Discount Type not found with id: " + requestDTO.getDiscountTypeId()));

            DiscountSubTypeEntity entity = DiscountSubTypeMapper.toEntity(requestDTO);
            entity.setDiscountType(discountType);

            discountSubTypeRepository.save(entity);
            log.info("Discount Sub Type saved with id: {}", entity.getId());
            return DiscountSubTypeMapper.toDto(entity);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (DataAccessException dae) {
            log.error("Database error while creating Discount Sub Type", dae);
            throw new CustomServiceException("Failed to create Discount Sub Type due to database error", dae);
        } catch (Exception e) {
            log.error("Unexpected error while creating Discount Sub Type", e);
            throw new CustomServiceException("Failed to create Discount Sub Type", e);
        }
    }

    @Transactional(readOnly = true)
    public List<DiscountSubTypeResponseDTO> getAll() {
        log.info("Fetching all Discount Sub Types");
        try {
            return DiscountSubTypeMapper.toDtoList(discountSubTypeRepository.findAllDeletedFalse());
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Discount Sub Types", dae);
            throw new CustomServiceException("Unable to fetch Discount Sub Types from database", dae);
        }
    }

    @Transactional(readOnly = true)
    public DiscountSubTypeResponseDTO getById(Long id) {
        log.info("Fetching DiscountSubType with id={}", id);
        DiscountSubTypeEntity entity = discountSubTypeRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
            log.warn("DiscountSubType not found for id={}", id);
            return new ResourceNotFoundException("Discount Sub Type not found with id: " + id);
        });
        return DiscountSubTypeMapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public List<DiscountSubTypeResponseDTO> getAllActive() {
        log.info("Fetching all Active Discount Sub Types");
        try {
            return DiscountSubTypeMapper.toDtoList(discountSubTypeRepository.findAllActive());
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Active Discount Sub Types", dae);
            throw new CustomServiceException("Unable to fetch Active Discount Sub Types", dae);
        }
    }

    @Transactional(readOnly = true)
    public List<DiscountSubTypeResponseDTO> getAllInActive() {
        log.info("Fetching all Inactive Discount Sub Types");
        try {
            return DiscountSubTypeMapper.toDtoList(discountSubTypeRepository.findAllNonActive());
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Inactive Discount Sub Types", dae);
            throw new CustomServiceException("Unable to fetch Inactive Discount Sub Types", dae);
        }
    }

    @Transactional(readOnly = true)
    public List<DiscountSubTypeResponseDTO> searchByKeyword(String keyword) {
        log.info("Searching Discount Sub Types with keyword={}", keyword);
        try {
            return DiscountSubTypeMapper.toDtoList(discountSubTypeRepository.searchByKeyword(keyword));
        } catch (DataAccessException dae) {
            log.error("Database error while searching Discount Sub Types", dae);
            throw new CustomServiceException("Unable to search Discount Sub Types", dae);
        }
    }

    @Transactional(readOnly = true)
    public List<DiscountSubTypeResponseDTO> searchDiscountComponents(Long discountTypeId, String keyword) {
        log.info("Searching Discount Sub Types for discountTypeId={} with keyword='{}'", discountTypeId, keyword);
        try {
            String search = (keyword != null && !keyword.trim().isEmpty()) ? keyword.trim() : null;
            List<DiscountSubTypeEntity> result = discountSubTypeRepository.searchDiscountComponents(discountTypeId,
                    search);
            if (result.isEmpty()) {
                log.warn("No Discount Sub Types found for discountTypeId={} with keyword='{}'", discountTypeId,
                        keyword);
                return Collections.emptyList();
            }
            return DiscountSubTypeMapper.toDtoList(result);
        } catch (Exception e) {
            log.error("Error fetching Discount Sub Types for discountTypeId={} with keyword='{}'", discountTypeId,
                    keyword, e);
            throw new CustomServiceException("Failed to fetch Discount Sub Types", e);
        }
    }

    @Transactional(readOnly = true)
    public List<DiscountSubTypeResponseDTO> getActiveByDiscountTypeId(Long discountTypeId) {
        log.info("Fetching active Discount Sub Types for DiscountTypeId={}", discountTypeId);
        try {
            List<DiscountSubTypeEntity> entities = discountSubTypeRepository.findActiveByDiscountTypeId(discountTypeId);
            if (entities.isEmpty()) {
                log.warn("No active Discount Sub Types found for DiscountTypeId={}", discountTypeId);
                return Collections.emptyList();
            }
            return DiscountSubTypeMapper.toDtoList(entities);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Discount Sub Types for DiscountTypeId={}", discountTypeId, dae);
            throw new CustomServiceException("Unable to fetch Discount Sub Types for given Discount Type", dae);
        }
    }

    @Transactional
    public DiscountSubTypeResponseDTO update(Long id, @Valid DiscountSubTypeRequestDTO requestDTO) {
        log.info("Updating DiscountSubType with ID: {}", id);
        try {
            DiscountSubTypeEntity existing = discountSubTypeRepository.findByIdAndDeletedFalse(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Discount SubType not found with id: " + id));

            DiscountSubTypeMapper.updateEntityFromDto(existing, requestDTO);

            DiscountTypeEntity discountType = discountTypeRepository
                    .findByIdAndDeletedFalse(requestDTO.getDiscountTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "DiscountType not found with id: " + requestDTO.getDiscountTypeId()));
            existing.setDiscountType(discountType);

            discountSubTypeRepository.save(existing);
            log.info("DiscountSubType updated successfully with ID: {}", existing.getId());
            return DiscountSubTypeMapper.toDto(existing);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (DataAccessException dae) {
            log.error("Database error while updating DiscountSubType with ID {}", id, dae);
            throw new CustomServiceException("Failed to update Discount SubType due to database error", dae);
        } catch (Exception e) {
            log.error("Unexpected error while updating DiscountSubType with ID {}", id, e);
            throw new CustomServiceException("Unexpected error occurred while updating Discount SubType", e);
        }
    }

    @Transactional
    public int softDeleteById(Long id) {
        log.info("Delete request received for DiscountSubType ID: {}", id);
        try {
            return discountSubTypeRepository.softDeleteById(id);
        } catch (DataAccessException dae) {
            log.error("Database error while deleting DiscountSubType with ID {}", id, dae);
            throw new CustomServiceException("Failed to delete DiscountSubType due to database error", dae);
        } catch (Exception e) {
            log.error("Unexpected error while deleting DiscountSubType with ID {}", id, e);
            throw new CustomServiceException("Unexpected error occurred during deletion", e);
        }
    }

    @Transactional
    public int softDeleteAll() {
        log.info("Delete ALL Discount Sub Types requested.");
        try {
            int rows = discountSubTypeRepository.softDeleteAll();
            log.info("Successfully soft deleted {} Discount Sub Types.", rows);
            return rows;
        } catch (Exception e) {
            log.error("Error occurred while soft deleting all Discount Sub Types", e);
            throw new CustomServiceException("Failed to soft delete all Discount Sub Types", e);
        }
    }

    @Transactional
    public int markAsActive(Long id) {
        log.info("Marking DiscountSubType as active with id: {}", id);
        try {
            int updated = discountSubTypeRepository.markAsActive(id);
            if (updated == 0)
                throw new ResourceNotFoundException("DiscountSubType not found with id: " + id);
            log.info("Successfully marked DiscountSubType as active: {}", id);
            return updated;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Error marking DiscountSubType as active with id: {}", id, e);
            throw new CustomServiceException("Failed to mark DiscountSubType as active", e);
        }
    }

    @Transactional
    public int markAsInactive(Long id) {
        log.info("Marking DiscountSubType as inactive with id: {}", id);
        try {
            int updated = discountSubTypeRepository.markAsInactive(id);
            if (updated == 0)
                throw new ResourceNotFoundException("DiscountSubType not found with id: " + id);
            log.info("Successfully marked DiscountSubType as inactive: {}", id);
            return updated;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Error marking DiscountSubType as inactive with id: {}", id, e);
            throw new CustomServiceException("Failed to mark DiscountSubType as inactive", e);
        }
    }
}
