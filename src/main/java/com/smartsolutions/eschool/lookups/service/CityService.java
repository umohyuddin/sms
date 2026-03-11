package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.ProvinceErrors;
import com.smartsolutions.eschool.institute.error.CityErrors;
import com.smartsolutions.eschool.lookups.dtos.city.requestDto.CityRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.mapper.CityMapper;
import com.smartsolutions.eschool.lookups.model.CityEntity;
import com.smartsolutions.eschool.lookups.model.ProvinceEntity;
import com.smartsolutions.eschool.lookups.repository.CityRepository;
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
public class CityService {
    private final CityRepository cityRepository;
    private final ProvinceRepository provinceRepository;

    public CityService(CityRepository cityRepository, ProvinceRepository provinceRepository) {
        this.cityRepository = cityRepository;
        this.provinceRepository = provinceRepository;
    }

    public List<CityResponseDTO> getAll() {
        log.info("[Service:CityService] getAll() called - Fetching all cities");
        List<CityEntity> result = cityRepository.findAllNotDeleted();
        List<CityResponseDTO> responseDTOs = CityMapper.toResponseDTOList(result);
        log.info("[Service:CityService] getAll() succeeded - Found {} cities", responseDTOs.size());
        return responseDTOs;
    }

    public List<CityResponseDTO> getAllActive() {
        log.info("[Service:CityService] getAllActive() called - Fetching active cities");
        List<CityEntity> result = cityRepository.findAllActive();
        List<CityResponseDTO> responseDTOs = CityMapper.toResponseDTOList(result);
        log.info("[Service:CityService] getAllActive() succeeded - Found {} active cities", responseDTOs.size());
        return responseDTOs;
    }

    public List<CityResponseDTO> getByProvinceId(Long provinceId) {
        log.info("[Service:CityService] getByProvinceId() called - provinceId: {}", provinceId);
        List<CityEntity> result = cityRepository.findByProvinceId(provinceId);
        List<CityResponseDTO> responseDTOs = CityMapper.toResponseDTOList(result);
        log.info("[Service:CityService] getByProvinceId() succeeded - Found {} cities", responseDTOs.size());
        return responseDTOs;
    }

    public CityResponseDTO getById(Long id) {
        log.info("[Service:CityService] getById() called - id: {}", id);
        CityEntity entity = cityRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(CityErrors.CITY_NOT_FOUND, HttpStatus.NOT_FOUND));

        CityResponseDTO responseDTO = CityMapper.toResponseDTO(entity);
        log.info("[Service:CityService] getById() succeeded - Found city: {}", id);
        return responseDTO;
    }

    public List<CityResponseDTO> searchByKeyword(String keyword) {
        log.info("[Service:CityService] searchByKeyword() called - keyword: {}", keyword);
        List<CityEntity> result = cityRepository.searchByKeyword(keyword);
        List<CityResponseDTO> responseDTOs = CityMapper.toResponseDTOList(result);
        log.info("[Service:CityService] searchByKeyword() succeeded - Found {} cities", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        log.info("[Service:CityService] softDeleteById() called - id: {}", id);

        int result = cityRepository.softDeleteById(id);
        if (result == 0) {
            throw new ApiException(CityErrors.CITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:CityService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public CityResponseDTO create(CityRequestDTO requestDTO) {
        log.info("[Service:CityService] create() called - Creating city: {} for provinceId: {}", requestDTO.getName(), requestDTO.getProvinceId());

        ProvinceEntity province = provinceRepository.findByIdAndDeletedFalse(requestDTO.getProvinceId())
                .orElseThrow(() -> new ApiException(ProvinceErrors.PROVINCE_NOT_FOUND, "Associated province not found", HttpStatus.BAD_REQUEST));

        if (requestDTO.getName() != null && !requestDTO.getName().trim().isEmpty()) {
            if (cityRepository.existsByProvinceIdAndName(province.getId(), requestDTO.getName().trim())) {
                throw new ApiException(CityErrors.DUPLICATE_CITY_NAME, "City name already exists for this province", HttpStatus.CONFLICT);
            }
        }

        CityEntity entity = CityMapper.toEntity(requestDTO, province);
        CityEntity saved = cityRepository.save(entity);

        log.info("[Service:CityService] create() succeeded - Created with id: {}", saved.getId());
        return CityMapper.toResponseDTO(saved);
    }

    @Transactional
    public CityResponseDTO update(Long id, CityRequestDTO requestDTO) {
        log.info("[Service:CityService] update() called - id: {}", id);

        CityEntity existing = cityRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(CityErrors.CITY_NOT_FOUND, HttpStatus.NOT_FOUND));

        ProvinceEntity newProvince = null;
        Long targetProvinceId = existing.getProvince().getId();
        
        if (requestDTO.getProvinceId() != null && !requestDTO.getProvinceId().equals(targetProvinceId)) {
            newProvince = provinceRepository.findByIdAndDeletedFalse(requestDTO.getProvinceId())
                    .orElseThrow(() -> new ApiException(ProvinceErrors.PROVINCE_NOT_FOUND, "Associated target province not found", HttpStatus.BAD_REQUEST));
            targetProvinceId = newProvince.getId();
        }

        if (requestDTO.getName() != null && !requestDTO.getName().trim().equals(existing.getName())) {
            if (cityRepository.existsByProvinceIdAndNameAndIdNot(targetProvinceId, requestDTO.getName().trim(), id)) {
                throw new ApiException(CityErrors.DUPLICATE_CITY_NAME, "City name already exists for this province", HttpStatus.CONFLICT);
            }
        }

        CityMapper.updateEntityFromDTO(existing, requestDTO, newProvince);
        CityEntity updated = cityRepository.save(existing);

        log.info("[Service:CityService] update() succeeded - id: {}", id);
        return CityMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Service:CityService] getStatistics() called");

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalCities", cityRepository.countAllNotDeleted());
        stats.put("activeCities", cityRepository.countByActiveTrue());
        stats.put("inactiveCities", cityRepository.countByActiveFalse());

        log.info("[Service:CityService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
