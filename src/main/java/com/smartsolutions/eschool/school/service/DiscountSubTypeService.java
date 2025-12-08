package com.smartsolutions.eschool.school.service;


import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.discountSubType.requestDto.DiscountSubTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountSubType.responseDto.DiscountSubTypeResponseDTO;
import com.smartsolutions.eschool.school.model.DiscountSubTypeEntity;
import com.smartsolutions.eschool.school.model.DiscountTypeEntity;
import com.smartsolutions.eschool.school.repository.DiscountSubTypeRepository;
import com.smartsolutions.eschool.school.repository.DiscountTypeRepository;
import com.smartsolutions.eschool.student.model.FeeComponentEntity;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class DiscountSubTypeService {
    private final DiscountSubTypeRepository discountSubTypeRepository;
    private final DiscountTypeRepository discountTypeRepository;

    public DiscountSubTypeService(DiscountSubTypeRepository discountSubTypeRepository, DiscountTypeRepository discountTypeRepository) {
        this.discountSubTypeRepository = discountSubTypeRepository;
        this.discountTypeRepository = discountTypeRepository;
    }

    public DiscountSubTypeResponseDTO createDiscountSubType(@Valid DiscountSubTypeRequestDTO requestDTO) {
        log.info("Creating new Discount Sub Type: {}", requestDTO.getName());
        try {
            DiscountTypeEntity discountTypeEntity = discountTypeRepository.findByIdAndDeletedFalse(requestDTO.getDiscountTypeId()).orElseThrow(() -> {
                log.info("Fetching Discount Type with id: {}", requestDTO.getDiscountTypeId());
                return new ResourceNotFoundException("Discount Type not found with id: " + requestDTO.getDiscountTypeId());
            });

            DiscountSubTypeEntity entity = MapperUtil.mapObject(requestDTO, DiscountSubTypeEntity.class);
            entity.setDiscountType(discountTypeEntity);
            entity.setId(null);
            discountSubTypeRepository.save(entity);
            log.info("Discount Sub Type  saved with id: {}", entity.getId());
            return MapperUtil.mapObject(entity, DiscountSubTypeResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating Discount Sub Type");
            throw new CustomServiceException("Failed to create Discount Sub Type due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating Discount Sub Type", e);
            throw new CustomServiceException("Failed to create Discount Sub Type");
        }
    }

    public List<DiscountSubTypeResponseDTO> getAll() {
        try {
            log.info("Fetching all Discount Sub Types from database");
            List<DiscountSubTypeEntity> result = discountSubTypeRepository.findAllDeletedFalse();
            List<DiscountSubTypeResponseDTO> responseDTOS = MapperUtil.mapList(result, DiscountSubTypeResponseDTO.class);
            log.info("Successfully fetched {} Discount Sub Types", responseDTOS.size());
            return responseDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Discount Sub Types", dae);
            throw new CustomServiceException("Unable to fetch Discount Sub Types from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping DiscountTpe Entity to Discount Sub Types", me);
            throw new CustomServiceException("Error converting Discount Sub Type data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Discount Sub Types", e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }

    public DiscountSubTypeResponseDTO getById(Long discountSubTypeId) {
        log.info("Fetching DiscountSubType with id: {}", discountSubTypeId);
        DiscountSubTypeEntity entity = discountSubTypeRepository.findByIdAndDeletedFalse(discountSubTypeId).orElseThrow(() -> {
            log.info("Fetching Discount Sub Type with id: {}", discountSubTypeId);
            return new ResourceNotFoundException("Discount Sub Type not found with id: " + discountSubTypeId);
        });
        DiscountSubTypeResponseDTO responseDTO;
        try {
            responseDTO = MapperUtil.mapObject(entity, DiscountSubTypeResponseDTO.class);
        } catch (Exception e) {
            log.error("Error mapping DiscountSubType entity to DTO for id={}", discountSubTypeId, e);
            throw new CustomServiceException("Failed to map Discount Sub Type");
        }

        log.info("Successfully fetched DiscountSubType: id={}", responseDTO.getId());
        return responseDTO;

    }

    public List<DiscountSubTypeResponseDTO> getAllActive() {
        try {
            log.info("Fetching all Active Discount Sub Types from database");
            List<DiscountSubTypeEntity> result = discountSubTypeRepository.findAllActive();
            List<DiscountSubTypeResponseDTO> responseDTOS = MapperUtil.mapList(result, DiscountSubTypeResponseDTO.class);
            log.info("Successfully fetched All Active Discount Sub Types {} ", responseDTOS.size());
            return responseDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Active Discount Sub Types", dae);
            throw new CustomServiceException("Unable to fetch Active Discount Sub Types from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping DiscountTpe Entity to Active Discount Sub Types", me);
            throw new CustomServiceException("Error converting Discount Sub Types data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Active Discount Sub Types", e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }

    public List<DiscountSubTypeResponseDTO> getAllInActive() {
        try {
            log.info("Fetching all Inactive Discount Sub Types from database");
            List<DiscountSubTypeEntity> result = discountSubTypeRepository.findAllNonActive();
            List<DiscountSubTypeResponseDTO> responseDTOS = MapperUtil.mapList(result, DiscountSubTypeResponseDTO.class);
            log.info("Successfully fetched Inactive Discount Sub Types {} ", responseDTOS.size());
            return responseDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Inactive Discount Sub Types", dae);
            throw new CustomServiceException("Unable to fetch Inactive Discount Sub Types from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping DiscountTpe Entity to Inactive Discount Sub Types", me);
            throw new CustomServiceException("Error converting Inactive Discount Sub Types data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Inactive Discount Sub Types", e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }

    public int softDeleteById(Long id) {
        log.info("delete request received for DiscountSubType ID: {}", id);
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

    public List<DiscountSubTypeResponseDTO> searchByKeyword(String keyword) {
        try {
            log.info("Fetching all Discount  Sub Types based on search from database");
            List<DiscountSubTypeEntity> result = discountSubTypeRepository.searchByKeyword(keyword);
            List<DiscountSubTypeResponseDTO> responseDTOS = MapperUtil.mapList(result, DiscountSubTypeResponseDTO.class);
            log.info("Successfully fetched Discount Sub Types based on search {} ", responseDTOS.size());
            return responseDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Discount Sub Types based on search", dae);
            throw new CustomServiceException("Unable to fetch Discount Sub Types based on search from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping DiscountTpe Entity to Discount Sub Types based on search", me);
            throw new CustomServiceException("Error converting  Discount Sub Types data based on search", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Discount Sub Types based on search", e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }

    public int softDeleteAll() {
        log.info("Delete ALL Discount Sub Type requested.");
        try {
            int rows = discountSubTypeRepository.softDeleteAll();
            if (rows == 0) {
                log.warn("Delete completed but no Discount Sub Type were affected.");
            } else {
                log.info("Successfully soft deleted ALL Discount Sub Type. Total affected: {}", rows);
            }
            return rows;
        } catch (Exception e) {
            log.error("Error occurred while soft deleting ALL Discount Sub Type", e);
            throw e;
        }
    }

    public int markAsActive(Long id) {
        log.info("Marking DiscountSubType as active with id: {}", id);
        try {
            int updated = discountSubTypeRepository.markAsActive(id);
            if (updated == 0) {
                log.warn("DiscountSubType not found or already active: {}", id);
                throw new ResourceNotFoundException("DiscountSubType not found with id: " + id);
            }
            log.info("Successfully marked DiscountSubType as active: {}", id);
            return updated;
        } catch (Exception e) {
            log.error("Error marking DiscountSubType as active with id: {}", id, e);
            throw new CustomServiceException("Failed to mark DiscountSubType as active", e);
        }
    }

    public int markAsInactive(Long id) {
        log.info("Marking DiscountSubType as inactive with id: {}", id);
        try {
            int updated = discountSubTypeRepository.markAsInactive(id);
            if (updated == 0) {
                log.warn("DiscountSubType not found or already inactive: {}", id);
                throw new ResourceNotFoundException("DiscountSubType not found with id: " + id);
            }
            log.info("Successfully marked DiscountSubType as inactive: {}", id);
            return updated;
        } catch (Exception e) {
            log.error("Error marking DiscountSubType as inactive with id: {}", id, e);
            throw new CustomServiceException("Failed to mark DiscountSubType as inactive", e);
        }
    }

    public List<DiscountSubTypeResponseDTO> searchDiscountComponents(Long discountTypeId, String keyword) {
        log.info("Fetching Standards for campusId={} with keyword='{}'", discountTypeId, keyword);
        try {
            String search = (keyword != null && !keyword.trim().isEmpty()) ? keyword.trim() : null;
            List<DiscountSubTypeEntity> result = discountSubTypeRepository.searchDiscountComponents(discountTypeId, search);
            if (result.isEmpty()) {
                log.warn("No Standards found for campusId={} with keyword='{}'", discountTypeId, keyword);
//                throw new ResourceNotFoundException("No Standards found matching the criteria");
                return Collections.emptyList();
            }
            List<DiscountSubTypeResponseDTO> responseDTOS = MapperUtil.mapList(result, DiscountSubTypeResponseDTO.class);
            log.info("Successfully fetched {} Standards by filter", responseDTOS.size());
            return responseDTOS;

        } catch (Exception e) {
            log.error("Error fetching Standards for campusId={} with keyword='{}'", discountTypeId  , keyword, e);
            throw new CustomServiceException("Failed to fetch Standards", e);
        }
    }
}


