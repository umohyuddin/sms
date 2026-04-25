package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.lookups.repository.CityRepository;
import com.smartsolutions.eschool.lookups.repository.CountryRepository;
import com.smartsolutions.eschool.lookups.repository.ProvinceRepository;
import com.smartsolutions.eschool.school.dtos.institute.request.InstituteRequestDTO;
import com.smartsolutions.eschool.school.dtos.institute.response.InstituteResponseDTO;
import com.smartsolutions.eschool.school.mapper.InstituteMapper;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class InstituteService {

    private final InstituteRepository instituteRepository;
    private final CountryRepository countryRepository;
    private final ProvinceRepository provinceRepository;
    private final CityRepository cityRepository;
    private final com.smartsolutions.eschool.school.repository.CampusRepository campusRepository;

    public InstituteService(InstituteRepository instituteRepository, CountryRepository countryRepository,
                           ProvinceRepository provinceRepository, CityRepository cityRepository,
                           com.smartsolutions.eschool.school.repository.CampusRepository campusRepository) {
        this.instituteRepository = instituteRepository;
        this.countryRepository = countryRepository;
        this.provinceRepository = provinceRepository;
        this.cityRepository = cityRepository;
        this.campusRepository = campusRepository;
    }

    @Transactional(readOnly = true)
    public InstituteResponseDTO getInstitute() {
        log.info("[Service:InstituteService] getInstitute() called");
        InstituteEntity instituteEntity = instituteRepository.getSingletonInstitute()
                .orElseThrow(() -> new com.smartsolutions.eschool.global.error.ApiException(
                        com.smartsolutions.eschool.institute.error.InstituteErrors.INSTITUTE_NOT_FOUND,
                        org.springframework.http.HttpStatus.NOT_FOUND));
        
        InstituteResponseDTO responseDTO = InstituteMapper.toResponseDTO(instituteEntity);
        log.info("[Service:InstituteService] getInstitute() succeeded - Institute: {}", responseDTO.getName());
        return responseDTO;
    }

    @Transactional(readOnly = true)
    public InstituteResponseDTO getById(Long id) {
        log.info("[Service:InstituteService] getById() called - id: {}", id);
        InstituteEntity instituteEntity = instituteRepository.findById(id)
                .orElseThrow(() -> new com.smartsolutions.eschool.global.error.ApiException(
                        com.smartsolutions.eschool.institute.error.InstituteErrors.INSTITUTE_NOT_FOUND,
                        org.springframework.http.HttpStatus.NOT_FOUND));

        InstituteResponseDTO responseDTO = InstituteMapper.toResponseDTO(instituteEntity);
        log.info("[Service:InstituteService] getById() succeeded - id: {}", id);
        return responseDTO;
    }

    @Transactional
    public InstituteResponseDTO updateInstitute(InstituteRequestDTO dto) {
        log.info("[Service:InstituteService] updateInstitute() called - id: {}", 1L);
        InstituteEntity institute = instituteRepository.getSingletonInstitute()
                .orElseGet(() -> {
                    InstituteEntity newEntity = new InstituteEntity();
                    newEntity.setId(1L);
                    return newEntity;
                });

        InstituteMapper.updateEntityFromDTO(institute, dto);

        if (dto.getCountryId() != null) {
            institute.setCountry(countryRepository.findById(dto.getCountryId())
                    .orElseThrow(() -> new com.smartsolutions.eschool.global.error.ApiException(
                            com.smartsolutions.eschool.institute.error.InstituteErrors.INVALID_INSTITUTE_DATA,
                            "Invalid country ID", org.springframework.http.HttpStatus.BAD_REQUEST)));
        }
        if (dto.getProvinceId() != null) {
            institute.setProvince(provinceRepository.findById(dto.getProvinceId())
                    .orElseThrow(() -> new com.smartsolutions.eschool.global.error.ApiException(
                            com.smartsolutions.eschool.institute.error.InstituteErrors.INVALID_INSTITUTE_DATA,
                            "Invalid province ID", org.springframework.http.HttpStatus.BAD_REQUEST)));
        }
        if (dto.getCityId() != null) {
            institute.setCity(cityRepository.findById(dto.getCityId())
                    .orElseThrow(() -> new com.smartsolutions.eschool.global.error.ApiException(
                            com.smartsolutions.eschool.institute.error.InstituteErrors.INVALID_INSTITUTE_DATA,
                            "Invalid city ID", org.springframework.http.HttpStatus.BAD_REQUEST)));
        }

        InstituteEntity saved = instituteRepository.save(institute);
        log.info("[Service:InstituteService] updateInstitute() succeeded - id: {}", saved.getId());
        return InstituteMapper.toResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public Map<String, Long> getStatistics() {
        log.info("[Service:InstituteService] getStatistics() called");
        Map<String, Long> stats = new HashMap<>();
        
        Long instituteId = 1L; // Singleton focus
        stats.put("totalCampuses", campusRepository.countByInstituteId(instituteId));
        stats.put("activeCampuses", campusRepository.countByInstituteIdAndActiveTrue(instituteId));
        stats.put("inactiveCampuses", campusRepository.countByInstituteIdAndActiveFalse(instituteId));
        
        log.info("[Service:InstituteService] getStatistics() succeeded");
        return stats;
    }
}
