package com.smartsolutions.eschool.school.service;


import com.smartsolutions.eschool.global.configs.FeeConfig;
import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.discountType.requestDto.DiscountTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.model.DiscountTypeEntity;
import com.smartsolutions.eschool.school.repository.DiscountTypeRepository;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeCatalogDTO;
import com.smartsolutions.eschool.student.model.FeeCatalogEntity;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DiscountTypeService {
    private final DiscountTypeRepository discountTypeRepository;

    private final FeeConfig feeConfig;

    public DiscountTypeService(DiscountTypeRepository discountTypeRepository, FeeConfig feeConfig) {
        this.discountTypeRepository = discountTypeRepository;
        this.feeConfig = feeConfig;
    }

    public DiscountTypeResponseDTO createDiscountType(@Valid DiscountTypeRequestDTO requestDTO) {
        log.info("Creating new Discount Type: {}", requestDTO.getName());
        try {
            DiscountTypeEntity entity = MapperUtil.mapObject(requestDTO, DiscountTypeEntity.class);
            discountTypeRepository.save(entity);
            log.info("Discount Type  saved with id: {}", entity.getId());
            return MapperUtil.mapObject(entity, DiscountTypeResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating Discount Type", dae);
            throw new CustomServiceException("Failed to create Discount Type due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating Discount Type", e);
            throw new CustomServiceException("Failed to create Discount Type");
        }
    }

    public List<DiscountTypeResponseDTO> getAll() {
        try {
            log.info("Fetching all Discount Types from database");
            List<DiscountTypeEntity> result = discountTypeRepository.findAll();
            return result.stream().map(this::toDto).collect(Collectors.toList());
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Discount Types", dae);
            throw new CustomServiceException("Unable to fetch Discount Types from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping DiscountTpe Entity to Discount Types", me);
            throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Discount Types", e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }

    public DiscountTypeResponseDTO getById(Long discountTypeId) {
        log.info("Request to fetch DiscountType with id={}", discountTypeId);
        DiscountTypeEntity entity = discountTypeRepository.findByIdAndDeletedFalse(discountTypeId).orElseThrow(() -> {
            log.warn("DiscountType not found for id={}", discountTypeId);
            return new ResourceNotFoundException("Discount Type not found with id: " + discountTypeId);
        });
        DiscountTypeResponseDTO responseDTO = toDto(entity);
        log.info("Successfully fetched DiscountType with id={}", responseDTO.getId());
        return responseDTO;
    }


    public List<DiscountTypeResponseDTO> getAllActive() {
        try {
            log.info("Fetching all Active Discount Types from database");
            List<DiscountTypeEntity> result = discountTypeRepository.findAllActive();
            List<DiscountTypeResponseDTO> responseDTOS = MapperUtil.mapList(result, DiscountTypeResponseDTO.class);
            log.info("Successfully fetched All Active Discount Types {} ", responseDTOS.size());
            return responseDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Active Discount Types", dae);
            throw new CustomServiceException("Unable to fetch Active Discount Types from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping DiscountTpe Entity to Active Discount Types", me);
            throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Active Discount Types", e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }

    public List<DiscountTypeResponseDTO> getAllInActive() {
        try {
            log.info("Fetching all Inactive Discount Types from database");
            List<DiscountTypeEntity> result = discountTypeRepository.findAllNonActive();
            List<DiscountTypeResponseDTO> responseDTOS = MapperUtil.mapList(result, DiscountTypeResponseDTO.class);
            log.info("Successfully fetched Inactive Discount Types {} ", responseDTOS.size());
            return responseDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Inactive Discount Types", dae);
            throw new CustomServiceException("Unable to fetch Inactive Discount Types from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping DiscountTpe Entity to Inactive Discount Types", me);
            throw new CustomServiceException("Error converting Inactive Discount Types data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Inactive Discount Types", e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }

    public int softDeleteById(Long id) {
        log.info("delete request received for DiscountType ID: {}", id);
        try {
            return discountTypeRepository.softDeleteById(id);
        } catch (DataAccessException dae) {
            log.error("Database error while deleting DiscountType with ID {}", id, dae);
            throw new CustomServiceException("Failed to delete DiscountType due to database error", dae);
        } catch (Exception e) {
            log.error("Unexpected error while deleting DiscountType with ID {}", id, e);
            throw new CustomServiceException("Unexpected error occurred during deletion", e);
        }
    }

    public List<DiscountTypeResponseDTO> searchByKeyword(String keyword) {
        try {
            log.info("Fetching all Discount Types based on search from database");
            List<DiscountTypeEntity> result = discountTypeRepository.searchByKeyword(keyword);
            List<DiscountTypeResponseDTO> responseDTOS = MapperUtil.mapList(result, DiscountTypeResponseDTO.class);
            log.info("Successfully fetched Discount Types based on search {} ", responseDTOS.size());
            return responseDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Discount Types based on search", dae);
            throw new CustomServiceException("Unable to fetch Discount Types based on search from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping DiscountTpe Entity to Discount Types based on search", me);
            throw new CustomServiceException("Error converting  Discount Types data based on search", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Discount Types based on search", e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }


    public DiscountTypeResponseDTO updateDiscountType(Long discountTypeId, @Valid DiscountTypeRequestDTO requestDTO) {
        log.info("Update request received for DiscountType ID: {}", discountTypeId);

        try {
            // Fetch existing entity
            DiscountTypeEntity existingEntity = discountTypeRepository.findByIdAndDeletedFalse(discountTypeId).orElseThrow(() -> {
                log.warn("DiscountType not found with ID: {}", discountTypeId);
                return new ResourceNotFoundException("Discount Type not found with id: " + discountTypeId);
            });

            existingEntity.setName(requestDTO.getName());
            existingEntity.setDescription(requestDTO.getDescription());
            existingEntity.setActive(requestDTO.getActive());
            existingEntity.setChargeType(requestDTO.getChargeType());
            existingEntity.setRecurrenceRule(requestDTO.getRecurrenceRule());

            // Save the updated entity
            discountTypeRepository.save(existingEntity);
            log.info("DiscountType updated successfully with ID: {}", existingEntity.getId());

            // Map to Response DTO
            return MapperUtil.mapObject(existingEntity, DiscountTypeResponseDTO.class);

        } catch (DataAccessException dae) {
            log.error("Database error while updating DiscountType with ID: {}", discountTypeId, dae);
            throw new CustomServiceException("Failed to update Discount Type due to database error", dae);
        } catch (Exception e) {
            log.error("Unexpected error while updating DiscountType with ID: {}", discountTypeId, e);
            throw new CustomServiceException("Unexpected error occurred while updating Discount Type", e);
        }
    }


    private DiscountTypeResponseDTO toDto(DiscountTypeEntity entity) {
        DiscountTypeResponseDTO dto = new DiscountTypeResponseDTO();

        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.getActive());

        dto.setChargeType(entity.getChargeType());
        dto.setChargeTypeLabel(getChargeTypeLabel(entity.getChargeType()));

        dto.setRecurrenceRule(entity.getRecurrenceRule());
        dto.setRecurrenceRuleLabel(getRecurrenceRuleLabel(entity.getRecurrenceRule()));

        return dto;
    }

    private String getChargeTypeLabel(String chargeType) {
        return feeConfig.getChargeTypes().getOrDefault(chargeType, chargeType);
    }

    private String getRecurrenceRuleLabel(String recurrenceRule) {
        return feeConfig.getRecurrenceRules().getOrDefault(recurrenceRule, recurrenceRule);
    }

}

