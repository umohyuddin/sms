package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.lookups.dtos.taxType.requestDto.TaxTypeRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.taxType.responseDto.TaxTypeResponseDTO;
import com.smartsolutions.eschool.lookups.model.CountryEntity;
import com.smartsolutions.eschool.lookups.model.TaxTypeEntity;
import com.smartsolutions.eschool.lookups.repository.CountryRepository;
import com.smartsolutions.eschool.lookups.repository.TaxTypeRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class TaxTypeService {
    private final TaxTypeRepository taxTypeRepository;
    private final CountryRepository countryRepository;

    public TaxTypeService(TaxTypeRepository taxTypeRepository, CountryRepository countryRepository) {
        this.taxTypeRepository = taxTypeRepository;
        this.countryRepository = countryRepository;
    }

    @Transactional
    public TaxTypeResponseDTO create(@Valid TaxTypeRequestDTO requestDTO) {
        log.info("Creating new TaxType: {}", requestDTO.getName());
        try {
            TaxTypeEntity entity = MapperUtil.mapObject(requestDTO, TaxTypeEntity.class);
            if (requestDTO.getCountryId() != null) {
                CountryEntity country = countryRepository.findById(requestDTO.getCountryId())
                        .orElseThrow(() -> new ResourceNotFoundException("Country not found with id=" + requestDTO.getCountryId()));
                entity.setCountry(country);
            }
            taxTypeRepository.save(entity);
            return MapperUtil.mapObject(entity, TaxTypeResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating TaxType", dae);
            throw new CustomServiceException("Failed to create TaxType due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating TaxType", e);
            throw new CustomServiceException("Failed to create TaxType");
        }
    }

    public List<TaxTypeResponseDTO> getAllActive() {
        try {
            log.info("Fetching active TaxTypes");
            List<TaxTypeEntity> result = taxTypeRepository.findAllActive();
            return MapperUtil.mapList(result, TaxTypeResponseDTO.class);
        } catch (Exception e) {
            log.error("Error fetching active tax types", e);
            throw new CustomServiceException("Failed to fetch active TaxTypes", e);
        }
    }

    public TaxTypeResponseDTO getById(Long id) {
        log.info("Fetching TaxType with id={}", id);
        TaxTypeEntity entity = taxTypeRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("TaxType not found with id=" + id));
        return MapperUtil.mapObject(entity, TaxTypeResponseDTO.class);
    }

    @Transactional
    public TaxTypeResponseDTO update(Long id, @Valid TaxTypeRequestDTO requestDTO) {
        log.info("Updating TaxType id={}", id);
        TaxTypeEntity entity = taxTypeRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("TaxType not found with id=" + id));
        
        entity.setName(requestDTO.getName());
        entity.setCode(requestDTO.getCode());
        entity.setIsActive(requestDTO.getIsActive());
        
        if (requestDTO.getCountryId() != null) {
            CountryEntity country = countryRepository.findById(requestDTO.getCountryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Country not found with id=" + requestDTO.getCountryId()));
            entity.setCountry(country);
        } else {
            entity.setCountry(null);
        }
        
        taxTypeRepository.save(entity);
        return MapperUtil.mapObject(entity, TaxTypeResponseDTO.class);
    }

    @Transactional
    public int softDeleteById(Long id) {
        log.info("Soft delete request for TaxType id={}", id);
        return taxTypeRepository.softDeleteById(id);
    }
}
