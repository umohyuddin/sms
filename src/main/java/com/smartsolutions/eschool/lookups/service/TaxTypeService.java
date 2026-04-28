package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.TaxTypeErrors;
import com.smartsolutions.eschool.lookups.dtos.taxType.requestDto.TaxTypeRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.taxType.responseDto.TaxTypeResponseDTO;
import com.smartsolutions.eschool.lookups.mapper.TaxTypeMapper;
import com.smartsolutions.eschool.lookups.model.CountryEntity;
import com.smartsolutions.eschool.lookups.model.TaxTypeEntity;
import com.smartsolutions.eschool.lookups.repository.CountryRepository;
import com.smartsolutions.eschool.lookups.repository.TaxTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TaxTypeService {

    private final TaxTypeRepository taxTypeRepository;
    private final CountryRepository countryRepository;

    public TaxTypeService(TaxTypeRepository taxTypeRepository, CountryRepository countryRepository) {
        this.taxTypeRepository = taxTypeRepository;
        this.countryRepository = countryRepository;
    }

    public List<TaxTypeResponseDTO> getAll() {
        log.info("[Service:TaxTypeService] getAll() called - Fetching all tax types");
        List<TaxTypeEntity> result = taxTypeRepository.findAllNotDeleted();
        List<TaxTypeResponseDTO> responseDTOs = TaxTypeMapper.toResponseDTOList(result);
        log.info("[Service:TaxTypeService] getAll() succeeded - Found {} tax types", responseDTOs.size());
        return responseDTOs;
    }

    public List<TaxTypeResponseDTO> getAllActive() {
        log.info("[Service:TaxTypeService] getAllActive() called - Fetching active tax types");
        List<TaxTypeEntity> result = taxTypeRepository.findAllActive();
        List<TaxTypeResponseDTO> responseDTOs = TaxTypeMapper.toResponseDTOList(result);
        log.info("[Service:TaxTypeService] getAllActive() succeeded - Found {} active tax types", responseDTOs.size());
        return responseDTOs;
    }

    public TaxTypeResponseDTO getById(Long id) {
        log.info("[Service:TaxTypeService] getById() called - id: {}", id);
        TaxTypeEntity entity = taxTypeRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(TaxTypeErrors.TAX_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));

        TaxTypeResponseDTO responseDTO = TaxTypeMapper.toResponseDTO(entity);
        log.info("[Service:TaxTypeService] getById() succeeded - Found tax type: {}", id);
        return responseDTO;
    }

    public List<TaxTypeResponseDTO> getByCountryId(Long countryId) {
        log.info("[Service:TaxTypeService] getByCountryId() called - countryId: {}", countryId);
        List<TaxTypeEntity> result = taxTypeRepository.findByCountryId(countryId);
        List<TaxTypeResponseDTO> responseDTOs = TaxTypeMapper.toResponseDTOList(result);
        log.info("[Service:TaxTypeService] getByCountryId() succeeded - Found {} tax types for country: {}",
                responseDTOs.size(), countryId);
        return responseDTOs;
    }

    public List<TaxTypeResponseDTO> searchByKeyword(String keyword) {
        log.info("[Service:TaxTypeService] searchByKeyword() called - keyword: {}", keyword);
        List<TaxTypeEntity> result = taxTypeRepository.searchByKeyword(keyword);
        List<TaxTypeResponseDTO> responseDTOs = TaxTypeMapper.toResponseDTOList(result);
        log.info("[Service:TaxTypeService] searchByKeyword() succeeded - Found {} tax types", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        log.info("[Service:TaxTypeService] softDeleteById() called - id: {}", id);

        int result = taxTypeRepository.softDeleteById(id);
        if (result == 0) {
            throw new ApiException(TaxTypeErrors.TAX_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:TaxTypeService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public TaxTypeResponseDTO createTaxType(TaxTypeRequestDTO requestDTO) {
        log.info("[Service:TaxTypeService] createTaxType() called - Creating: {}", requestDTO.getCode());

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().isEmpty()) {
            if (taxTypeRepository.existsByCode(requestDTO.getCode().trim())) {
                throw new ApiException(TaxTypeErrors.DUPLICATE_TAX_TYPE_CODE, HttpStatus.CONFLICT);
            }
        }

        TaxTypeEntity entity = TaxTypeMapper.toEntity(requestDTO);

        if (requestDTO.getCountryId() != null) {
            CountryEntity country = countryRepository.findById(requestDTO.getCountryId())
                    .orElseThrow(() -> new ApiException(TaxTypeErrors.COUNTRY_NOT_FOUND, HttpStatus.NOT_FOUND));
            entity.setCountry(country);
        }

        TaxTypeEntity saved = taxTypeRepository.save(entity);

        log.info("[Service:TaxTypeService] createTaxType() succeeded - Created with id: {}", saved.getId());
        return TaxTypeMapper.toResponseDTO(saved);
    }

    @Transactional
    public TaxTypeResponseDTO updateTaxType(Long id, TaxTypeRequestDTO requestDTO) {
        log.info("[Service:TaxTypeService] updateTaxType() called - id: {}", id);

        TaxTypeEntity existing = taxTypeRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(TaxTypeErrors.TAX_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().equals(existing.getCode())) {
            if (taxTypeRepository.existsByCodeAndIdNot(requestDTO.getCode().trim(), id)) {
                throw new ApiException(TaxTypeErrors.DUPLICATE_TAX_TYPE_CODE, HttpStatus.CONFLICT);
            }
        }

        TaxTypeMapper.updateEntityFromDTO(existing, requestDTO);

        if (requestDTO.getCountryId() != null) {
            CountryEntity country = countryRepository.findById(requestDTO.getCountryId())
                    .orElseThrow(() -> new ApiException(TaxTypeErrors.COUNTRY_NOT_FOUND, HttpStatus.NOT_FOUND));
            existing.setCountry(country);
        }

        TaxTypeEntity updated = taxTypeRepository.save(existing);

        log.info("[Service:TaxTypeService] updateTaxType() succeeded - id: {}", id);
        return TaxTypeMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Service:TaxTypeService] getStatistics() called");

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalTaxTypes", taxTypeRepository.countAllNotDeleted());
        stats.put("activeTaxTypes", taxTypeRepository.countByIsActiveTrue());
        stats.put("inactiveTaxTypes", taxTypeRepository.countByIsActiveFalse());

        log.info("[Service:TaxTypeService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
