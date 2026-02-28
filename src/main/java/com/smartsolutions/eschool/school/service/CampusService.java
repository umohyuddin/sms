package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.CampusErrors;
import com.smartsolutions.eschool.lookups.repository.CityRepository;
import com.smartsolutions.eschool.lookups.repository.ProvinceRepository;
import com.smartsolutions.eschool.school.dtos.campuses.requestDto.CampusCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import com.smartsolutions.eschool.school.mapper.CampusMapper;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class CampusService {

    private final CampusRepository campusRepository;
    private final InstituteRepository instituteRepository;
    private final ProvinceRepository provinceRepository;
    private final CityRepository cityRepository;

    public CampusService(CampusRepository campusRepository,
            InstituteRepository instituteRepository,
            ProvinceRepository provinceRepository,
            CityRepository cityRepository) {
        this.campusRepository = campusRepository;
        this.instituteRepository = instituteRepository;
        this.provinceRepository = provinceRepository;
        this.cityRepository = cityRepository;
    }

    public List<CampusResponseDTO> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(CampusErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:CampusService] getAll() called - Fetching all for institute: {}", organizationId);
        List<CampusEntity> result = campusRepository.findByInstituteId(organizationId);
        List<CampusResponseDTO> responseDTOs = CampusMapper.toResponseDTOList(result);
        log.info("[Service:CampusService] getAll() succeeded - Found {} campuses", responseDTOs.size());
        return responseDTOs;
    }

    public CampusResponseDTO getById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(CampusErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:CampusService] getById() called - id: {}, institute: {}", id, organizationId);
        CampusEntity campusEntity = campusRepository.findByIdAndInstituteId(id, organizationId)
                .orElseThrow(() -> new ApiException(CampusErrors.CAMPUS_NOT_FOUND, HttpStatus.NOT_FOUND));

        CampusResponseDTO responseDTO = CampusMapper.toResponseDTO(campusEntity);
        log.info("[Service:CampusService] getById() succeeded - Found campus: {}", id);
        return responseDTO;
    }

    public List<CampusResponseDTO> findByInstituteId(Long instituteId) {
        log.info("[Service:CampusService] findByInstituteId() called - Fetching for institute: {}", instituteId);
        List<CampusEntity> campusEntities = campusRepository.findByInstituteId(instituteId);
        return CampusMapper.toResponseDTOList(campusEntities);
    }

    public List<CampusResponseDTO> findByCampusNameContaining(String name) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(CampusErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:CampusService] findByCampusNameContaining() called - name: {}, institute: {}", name,
                organizationId);
        List<CampusEntity> campusEntities = campusRepository.findByCampusNameContaining(name);
        List<CampusEntity> filtered = campusEntities.stream()
                .filter(c -> c.getInstitute() != null && c.getInstitute().getId().equals(organizationId))
                .toList();
        return CampusMapper.toResponseDTOList(filtered);
    }

    @Transactional
    public void softDeleteById(Long id) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(CampusErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:CampusService] softDeleteById() called - id: {}, institute: {}", id, organizationId);

        int result = campusRepository.softDeleteByIdAndInstituteId(id, organizationId);
        if (result == 0) {
            throw new ApiException(CampusErrors.CAMPUS_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:CampusService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public CampusResponseDTO createCampus(CampusCreateRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(CampusErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:CampusService] createCampus() called - Creating for institute: {}", organizationId);

        if (requestDTO.getCampusCode() != null && !requestDTO.getCampusCode().trim().isEmpty()) {
            if (campusRepository.existsByInstituteIdAndCampusCode(organizationId,
                    requestDTO.getCampusCode().trim())) {
                throw new ApiException(CampusErrors.DUPLICATE_CAMPUS_CODE, HttpStatus.CONFLICT);
            }
        }

        InstituteEntity institute = instituteRepository.findById(organizationId)
                .orElseThrow(() -> new ApiException(CampusErrors.INSTITUTE_NOT_FOUND, HttpStatus.NOT_FOUND));

        CampusEntity entity = CampusMapper.toEntity(requestDTO);
        entity.setInstitute(institute);

        if (requestDTO.getProvinceId() != null) {
            entity.setProvince(provinceRepository.findById(requestDTO.getProvinceId()).orElse(null));
        }
        if (requestDTO.getCityId() != null) {
            entity.setCity(cityRepository.findById(requestDTO.getCityId()).orElse(null));
        }

        CampusEntity saved = campusRepository.save(entity);

        log.info("[Service:CampusService] createCampus() succeeded - Campus created with id: {}", saved.getId());
        return CampusMapper.toResponseDTO(saved);
    }

    @Transactional
    public CampusResponseDTO updateCampus(Long id, CampusCreateRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(CampusErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:CampusService] updateCampus() called - id: {}, institute: {}", id, organizationId);

        CampusEntity existing = campusRepository.findByIdAndInstituteId(id, organizationId)
                .orElseThrow(() -> new ApiException(CampusErrors.CAMPUS_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getCampusCode() != null && !requestDTO.getCampusCode().trim().equals(existing.getCampusCode())) {
            if (campusRepository.existsByInstituteIdAndCampusCodeAndIdNot(organizationId,
                    requestDTO.getCampusCode().trim(), id)) {
                throw new ApiException(CampusErrors.DUPLICATE_CAMPUS_CODE, HttpStatus.CONFLICT);
            }
        }

        CampusMapper.updateEntityFromDTO(existing, requestDTO);

        if (requestDTO.getProvinceId() != null) {
            existing.setProvince(provinceRepository.findById(requestDTO.getProvinceId()).orElse(null));
        }
        if (requestDTO.getCityId() != null) {
            existing.setCity(cityRepository.findById(requestDTO.getCityId()).orElse(null));
        }

        CampusEntity updated = campusRepository.save(existing);

        log.info("[Service:CampusService] updateCampus() succeeded - id: {}", id);
        return CampusMapper.toResponseDTO(updated);
    }

    public List<CampusResponseDTO> searchByKeyword(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(CampusErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:CampusService] searchByKeyword() called - keyword: {}, institute: {}", keyword,
                organizationId);
        List<CampusEntity> result = campusRepository.searchByKeywordAndInstituteId(keyword, organizationId);
        List<CampusResponseDTO> responseDTOs = CampusMapper.toResponseDTOList(result);
        log.info("[Service:CampusService] searchByKeyword() succeeded - Found {} campuses", responseDTOs.size());
        return responseDTOs;
    }

    public Long getCampusCountByInstituteId(Long instituteId) {
        log.info("[Service:CampusService] getCampusCountByInstituteId() called - institute: {}", instituteId);
        return campusRepository.countByInstituteId(instituteId);
    }

    public java.util.Map<String, Long> getStatistics() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(CampusErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:CampusService] getStatistics() called - institute: {}", organizationId);

        java.util.Map<String, Long> stats = new java.util.HashMap<>();
        stats.put("totalCampuses", campusRepository.countByInstituteId(organizationId));
        stats.put("activeCampuses", campusRepository.countByInstituteIdAndActiveTrue(organizationId));
        stats.put("inactiveCampuses", campusRepository.countByInstituteIdAndActiveFalse(organizationId));

        log.info("[Service:CampusService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
