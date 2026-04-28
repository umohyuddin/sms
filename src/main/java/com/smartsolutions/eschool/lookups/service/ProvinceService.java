package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.CountryErrors;
import com.smartsolutions.eschool.institute.error.ProvinceErrors;
import com.smartsolutions.eschool.lookups.dtos.province.requestDto.ProvinceRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.mapper.ProvinceMapper;
import com.smartsolutions.eschool.lookups.model.CountryEntity;
import com.smartsolutions.eschool.lookups.model.ProvinceEntity;
import com.smartsolutions.eschool.lookups.repository.CountryRepository;
import com.smartsolutions.eschool.lookups.repository.ProvinceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ProvinceService {
    private final ProvinceRepository provinceRepository;
    private final CountryRepository countryRepository;

    public ProvinceService(ProvinceRepository provinceRepository, CountryRepository countryRepository) {
        this.provinceRepository = provinceRepository;
        this.countryRepository = countryRepository;
    }

    public List<ProvinceResponseDTO> getAll() {
        log.info("[Service:ProvinceService] getAll() called - Fetching all provinces");
        List<ProvinceEntity> result = provinceRepository.findAllNotDeleted();
        List<ProvinceResponseDTO> responseDTOs = ProvinceMapper.toResponseDTOList(result);
        log.info("[Service:ProvinceService] getAll() succeeded - Found {} provinces", responseDTOs.size());
        return responseDTOs;
    }

    public List<ProvinceResponseDTO> getAllActive() {
        log.info("[Service:ProvinceService] getAllActive() called - Fetching active provinces");
        List<ProvinceEntity> result = provinceRepository.findAllActive();
        List<ProvinceResponseDTO> responseDTOs = ProvinceMapper.toResponseDTOList(result);
        log.info("[Service:ProvinceService] getAllActive() succeeded - Found {} active provinces", responseDTOs.size());
        return responseDTOs;
    }

    public List<ProvinceResponseDTO> getByCountryId(Long countryId) {
        log.info("[Service:ProvinceService] getByCountryId() called - countryId: {}", countryId);
        List<ProvinceEntity> result = provinceRepository.findByCountryId(countryId);
        List<ProvinceResponseDTO> responseDTOs = ProvinceMapper.toResponseDTOList(result);
        log.info("[Service:ProvinceService] getByCountryId() succeeded - Found {} provinces", responseDTOs.size());
        return responseDTOs;
    }

    public ProvinceResponseDTO getById(Long id) {
        log.info("[Service:ProvinceService] getById() called - id: {}", id);
        ProvinceEntity entity = provinceRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(ProvinceErrors.PROVINCE_NOT_FOUND, HttpStatus.NOT_FOUND));

        ProvinceResponseDTO responseDTO = ProvinceMapper.toResponseDTO(entity);
        log.info("[Service:ProvinceService] getById() succeeded - Found province: {}", id);
        return responseDTO;
    }

    public List<ProvinceResponseDTO> searchByKeyword(String keyword) {
        log.info("[Service:ProvinceService] searchByKeyword() called - keyword: {}", keyword);
        List<ProvinceEntity> result = provinceRepository.searchByKeyword(keyword);
        List<ProvinceResponseDTO> responseDTOs = ProvinceMapper.toResponseDTOList(result);
        log.info("[Service:ProvinceService] searchByKeyword() succeeded - Found {} provinces", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        log.info("[Service:ProvinceService] softDeleteById() called - id: {}", id);

        int result = provinceRepository.softDeleteById(id);
        if (result == 0) {
            throw new ApiException(ProvinceErrors.PROVINCE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:ProvinceService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public ProvinceResponseDTO create(ProvinceRequestDTO requestDTO) {
        log.info("[Service:ProvinceService] create() called - Creating province: {} for countryId: {}", requestDTO.getName(), requestDTO.getCountryId());

        CountryEntity country = countryRepository.findByIdAndDeletedFalse(requestDTO.getCountryId())
                .orElseThrow(() -> new ApiException(CountryErrors.COUNTRY_NOT_FOUND, "Associated country not found", HttpStatus.BAD_REQUEST));

        if (requestDTO.getName() != null && !requestDTO.getName().trim().isEmpty()) {
            if (provinceRepository.existsByCountryIdAndName(country.getId(), requestDTO.getName().trim())) {
                throw new ApiException(ProvinceErrors.DUPLICATE_PROVINCE_NAME, "Province name already exists for this country", HttpStatus.CONFLICT);
            }
        }

        ProvinceEntity entity = ProvinceMapper.toEntity(requestDTO, country);
        ProvinceEntity saved = provinceRepository.save(entity);

        log.info("[Service:ProvinceService] create() succeeded - Created with id: {}", saved.getId());
        return ProvinceMapper.toResponseDTO(saved);
    }

    @Transactional
    public ProvinceResponseDTO update(Long id, ProvinceRequestDTO requestDTO) {
        log.info("[Service:ProvinceService] update() called - id: {}", id);

        ProvinceEntity existing = provinceRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(ProvinceErrors.PROVINCE_NOT_FOUND, HttpStatus.NOT_FOUND));

        CountryEntity newCountry = null;
        Long targetCountryId = existing.getCountry().getId();
        
        // Handle potential country reassignment
        if (requestDTO.getCountryId() != null && !requestDTO.getCountryId().equals(targetCountryId)) {
            newCountry = countryRepository.findByIdAndDeletedFalse(requestDTO.getCountryId())
                    .orElseThrow(() -> new ApiException(CountryErrors.COUNTRY_NOT_FOUND, "Associated target country not found", HttpStatus.BAD_REQUEST));
            targetCountryId = newCountry.getId();
        }

        if (requestDTO.getName() != null && !requestDTO.getName().trim().equals(existing.getName())) {
            if (provinceRepository.existsByCountryIdAndNameAndIdNot(targetCountryId, requestDTO.getName().trim(), id)) {
                throw new ApiException(ProvinceErrors.DUPLICATE_PROVINCE_NAME, "Province name already exists for this country", HttpStatus.CONFLICT);
            }
        }

        ProvinceMapper.updateEntityFromDTO(existing, requestDTO, newCountry);
        ProvinceEntity updated = provinceRepository.save(existing);

        log.info("[Service:ProvinceService] update() succeeded - id: {}", id);
        return ProvinceMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Service:ProvinceService] getStatistics() called");

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalProvinces", provinceRepository.countAllNotDeleted());
        stats.put("activeProvinces", provinceRepository.countByActiveTrue());
        stats.put("inactiveProvinces", provinceRepository.countByActiveFalse());

        log.info("[Service:ProvinceService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
