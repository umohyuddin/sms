package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.lookups.dtos.city.requestDto.CityRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.model.CityEntity;
import com.smartsolutions.eschool.lookups.repository.CityRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    // Create a city
    public CityResponseDTO createCity(@Valid CityRequestDTO requestDTO) {
        log.info("Creating new City: {}", requestDTO.getName());
        try {
            CityEntity entity = MapperUtil.mapObject(requestDTO, CityEntity.class);
            cityRepository.save(entity);
            log.info("City saved with id: {}", entity.getId());
            return MapperUtil.mapObject(entity, CityResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating City", dae);
            throw new CustomServiceException("Failed to create City due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating City", e);
            throw new CustomServiceException("Failed to create City");
        }
    }

    // Get all non-deleted cities
    public List<CityResponseDTO> getAllActive() {
        log.info("Fetching all active cities");
        try {
            List<CityEntity> result = cityRepository.findAllActive();
            return MapperUtil.mapList(result, CityResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching cities", dae);
            throw new CustomServiceException("Unable to fetch cities from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping CityEntity to DTO", me);
            throw new CustomServiceException("Error converting city data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching cities", e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }

    // Get city by ID
    public CityResponseDTO getById(Long cityId) {
        log.info("Fetching City with id: {}", cityId);
        CityEntity cityEntity = cityRepository.findByIdAndDeletedFalse(cityId)
                .orElseThrow(() -> {
                    log.warn("City not found with id: {}", cityId);
                    return new ResourceNotFoundException("City not found with id: " + cityId);
                });
        try {
            return MapperUtil.mapObject(cityEntity, CityResponseDTO.class);
        } catch (Exception e) {
            log.error("Error mapping City entity to DTO for id={}", cityId, e);
            throw new CustomServiceException("Failed to map City");
        }
    }

    // Search cities by keyword
    public List<CityResponseDTO> searchByKeyword(String keyword) {
        log.info("Searching cities by keyword: {}", keyword);
        try {
            List<CityEntity> result = cityRepository.searchByKeyword(keyword);
            return MapperUtil.mapList(result, CityResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while searching cities", dae);
            throw new CustomServiceException("Unable to search cities from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping CityEntity to DTO for search", me);
            throw new CustomServiceException("Error converting city data", me);
        } catch (Exception e) {
            log.error("Unexpected error while searching cities", e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }

    // Get cities by province
    public List<CityResponseDTO> getByProvince(Long provinceId) {
        log.info("Fetching cities for provinceId: {}", provinceId);
        try {
            List<CityEntity> result = cityRepository.findByProvinceId(provinceId);
            return MapperUtil.mapList(result, CityResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching cities by province", dae);
            throw new CustomServiceException("Unable to fetch cities by province from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping CityEntity to DTO for province", me);
            throw new CustomServiceException("Error converting city data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching cities by province", e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }

    // Soft delete city by ID
    public int softDeleteById(Long cityId) {
        log.info("Soft delete request for City ID: {}", cityId);
        try {
            return cityRepository.softDeleteById(cityId);
        } catch (DataAccessException dae) {
            log.error("Database error while deleting City with ID {}", cityId, dae);
            throw new CustomServiceException("Failed to delete City due to database error", dae);
        } catch (Exception e) {
            log.error("Unexpected error while deleting City with ID {}", cityId, e);
            throw new CustomServiceException("Unexpected error occurred during deletion", e);
        }
    }

    // Activate / Deactivate city
    public int setActiveStatus(Long cityId, boolean status) {
        log.info("Setting active status={} for City ID: {}", status, cityId);
        try {
            return cityRepository.setActiveStatus(cityId, status);
        } catch (DataAccessException dae) {
            log.error("Database error while updating City active status", dae);
            throw new CustomServiceException("Failed to update City status due to database error", dae);
        } catch (Exception e) {
            log.error("Unexpected error while updating City active status", e);
            throw new CustomServiceException("Unexpected error occurred during status update", e);
        }
    }
}
