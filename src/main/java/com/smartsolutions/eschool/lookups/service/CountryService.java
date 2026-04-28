package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.CountryErrors;
import com.smartsolutions.eschool.lookups.dtos.country.request.CountryRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.country.response.CountryResponseDTO;
import com.smartsolutions.eschool.lookups.mapper.CountryMapper;
import com.smartsolutions.eschool.lookups.model.CountryEntity;
import com.smartsolutions.eschool.lookups.repository.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryResponseDTO> getAll() {
        log.info("[Service:CountryService] getAll() called - Fetching all countries");
        List<CountryEntity> result = countryRepository.findAllNotDeleted();
        List<CountryResponseDTO> responseDTOs = CountryMapper.toResponseDTOList(result);
        log.info("[Service:CountryService] getAll() succeeded - Found {} countries", responseDTOs.size());
        return responseDTOs;
    }

    public CountryResponseDTO getById(Long id) {
        log.info("[Service:CountryService] getById() called - id: {}", id);
        CountryEntity entity = countryRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(CountryErrors.COUNTRY_NOT_FOUND, HttpStatus.NOT_FOUND));

        CountryResponseDTO responseDTO = CountryMapper.toResponseDTO(entity);
        log.info("[Service:CountryService] getById() succeeded - Found country: {}", id);
        return responseDTO;
    }

    public List<CountryResponseDTO> searchByKeyword(String keyword) {
        log.info("[Service:CountryService] searchByKeyword() called - keyword: {}", keyword);
        List<CountryEntity> result = countryRepository.searchByKeyword(keyword);
        List<CountryResponseDTO> responseDTOs = CountryMapper.toResponseDTOList(result);
        log.info("[Service:CountryService] searchByKeyword() succeeded - Found {} countries", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        log.info("[Service:CountryService] softDeleteById() called - id: {}", id);

        int result = countryRepository.softDeleteById(id);
        if (result == 0) {
            throw new ApiException(CountryErrors.COUNTRY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:CountryService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public CountryResponseDTO create(CountryRequestDTO requestDTO) {
        log.info("[Service:CountryService] create() called - Creating: {}", requestDTO.getCountryName());

        if (requestDTO.getCountryCode() != null && !requestDTO.getCountryCode().trim().isEmpty()) {
            if (countryRepository.existsByCountryCode(requestDTO.getCountryCode().trim())) {
                throw new ApiException(CountryErrors.DUPLICATE_COUNTRY_CODE, "Country code already exists",
                        HttpStatus.CONFLICT);
            }
        }

        CountryEntity entity = CountryMapper.toEntity(requestDTO);
        CountryEntity saved = countryRepository.save(entity);

        log.info("[Service:CountryService] create() succeeded - Created with id: {}", saved.getId());
        return CountryMapper.toResponseDTO(saved);
    }

    @Transactional
    public CountryResponseDTO update(Long id, CountryRequestDTO requestDTO) {
        log.info("[Service:CountryService] update() called - id: {}", id);

        CountryEntity existing = countryRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(CountryErrors.COUNTRY_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getCountryCode() != null
                && !requestDTO.getCountryCode().trim().equals(existing.getCountryCode())) {
            if (countryRepository.existsByCountryCodeAndIdNot(requestDTO.getCountryCode().trim(), id)) {
                throw new ApiException(CountryErrors.DUPLICATE_COUNTRY_CODE, "Country code already exists",
                        HttpStatus.CONFLICT);
            }
        }

        CountryMapper.updateEntityFromDTO(existing, requestDTO);
        CountryEntity updated = countryRepository.save(existing);

        log.info("[Service:CountryService] update() succeeded - id: {}", id);
        return CountryMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Service:CountryService] getStatistics() called");

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalCountries", countryRepository.countAllNotDeleted());

        log.info("[Service:CountryService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
