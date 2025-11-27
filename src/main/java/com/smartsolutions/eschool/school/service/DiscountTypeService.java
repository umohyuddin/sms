package com.smartsolutions.eschool.school.service;


import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.discountType.requestDto.DiscountTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.model.DiscountTypeEntity;
import com.smartsolutions.eschool.school.repository.DiscountTypeRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DiscountTypeService {
    private final DiscountTypeRepository discountTypeRepository;

    public DiscountTypeService(DiscountTypeRepository discountTypeRepository) {
        this.discountTypeRepository = discountTypeRepository;
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
            List<DiscountTypeResponseDTO> responseDTOS = MapperUtil.mapList(result, DiscountTypeResponseDTO.class);
            log.info("Successfully fetched {} Discount Types", responseDTOS.size());
            return responseDTOS;
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
        log.info("Fetching DiscountType with id: {}", discountTypeId);
        DiscountTypeEntity discountTypeEntity = discountTypeRepository.findByIdAndDeletedFalse(discountTypeId).orElseThrow(() -> {
            log.info("Fetching Discount Type with id: {}", discountTypeId);
            return new ResourceNotFoundException("Discount Type not found with id: " + discountTypeId);
        });
        DiscountTypeResponseDTO responseDTO;
        try {
            responseDTO = MapperUtil.mapObject(discountTypeEntity, DiscountTypeResponseDTO.class);
        } catch (Exception e) {
            log.error("Error mapping DiscountType entity to DTO for id={}", discountTypeId, e);
            throw new CustomServiceException("Failed to map Discount Type");
        }

        log.info("Successfully fetched DiscountType: id={}", responseDTO.getId());
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
}

