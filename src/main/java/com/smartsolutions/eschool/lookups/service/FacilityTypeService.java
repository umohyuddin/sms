package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.lookups.dtos.facilityType.requestDto.FacilityTypeRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.facilityType.responseDto.FacilityTypeResponseDTO;
import com.smartsolutions.eschool.lookups.model.FacilityTypeEntity;
import com.smartsolutions.eschool.lookups.repository.FacilityTypeRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class FacilityTypeService {
    private final FacilityTypeRepository facilityTypeRepository;

    public FacilityTypeService(FacilityTypeRepository facilityTypeRepository) {
        this.facilityTypeRepository = facilityTypeRepository;
    }

    @Transactional
    public FacilityTypeResponseDTO create(@Valid FacilityTypeRequestDTO requestDTO) {
        log.info("Creating new FacilityType: {}", requestDTO.getName());
        try {
            FacilityTypeEntity entity = MapperUtil.mapObject(requestDTO, FacilityTypeEntity.class);
            facilityTypeRepository.save(entity);
            return MapperUtil.mapObject(entity, FacilityTypeResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating FacilityType", dae);
            throw new CustomServiceException("Failed to create FacilityType due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating FacilityType", e);
            throw new CustomServiceException("Failed to create FacilityType");
        }
    }

    public List<FacilityTypeResponseDTO> getAllActive() {
        try {
            log.info("Fetching active FacilityTypes");
            List<FacilityTypeEntity> result = facilityTypeRepository.findAllActive();
            return MapperUtil.mapList(result, FacilityTypeResponseDTO.class);
        } catch (Exception e) {
            log.error("Error fetching active facility types", e);
            throw new CustomServiceException("Failed to fetch active FacilityTypes", e);
        }
    }

    public FacilityTypeResponseDTO getById(Long id) {
        log.info("Fetching FacilityType with id={}", id);
        FacilityTypeEntity entity = facilityTypeRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("FacilityType not found with id=" + id));
        return MapperUtil.mapObject(entity, FacilityTypeResponseDTO.class);
    }

    @Transactional
    public FacilityTypeResponseDTO update(Long id, @Valid FacilityTypeRequestDTO requestDTO) {
        log.info("Updating FacilityType id={}", id);
        FacilityTypeEntity entity = facilityTypeRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("FacilityType not found with id=" + id));
        
        entity.setName(requestDTO.getName());
        entity.setCode(requestDTO.getCode());
        entity.setDescription(requestDTO.getDescription());
        entity.setIsActive(requestDTO.getIsActive());
        
        facilityTypeRepository.save(entity);
        return MapperUtil.mapObject(entity, FacilityTypeResponseDTO.class);
    }

    @Transactional
    public int softDeleteById(Long id) {
        log.info("Soft delete request for FacilityType id={}", id);
        return facilityTypeRepository.softDeleteById(id);
    }
}
