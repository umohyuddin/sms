package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.model.CityEntity;
import com.smartsolutions.eschool.lookups.model.ProvinceEntity;
import com.smartsolutions.eschool.lookups.repository.CityRepository;
import com.smartsolutions.eschool.lookups.repository.ProvinceRepository;
import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import com.smartsolutions.eschool.school.dtos.campuses.requestDto.CampusCreateRequestDTO;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.school.repository.InstituteDaoImp;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class CampusService {

    private final CampusRepository campusRepository;
    private final InstituteDaoImp instituteDaoImp;
    private final ProvinceRepository provinceRepository;
    private final CityRepository cityRepository;

    public CampusService(CampusRepository campusRepository, InstituteDaoImp instituteDaoImp,
            ProvinceRepository provinceRepository, CityRepository cityRepository) {
        this.campusRepository = campusRepository;
        this.instituteDaoImp = instituteDaoImp;
        this.provinceRepository = provinceRepository;
        this.cityRepository = cityRepository;
    }

    public List<CampusResponseDTO> getAll(Long organizationId) {
        try {
            log.info("Fetching all Campuses from database for organization: {}", organizationId);
            List<CampusEntity> result = campusRepository.findByInstituteIdAndDeletedFalse(organizationId);
            log.info("Successfully fetched {} Campuses", result.size());
            List<CampusResponseDTO> campusResponseDTOList = MapperUtil.mapList(result, CampusResponseDTO.class);
            return campusResponseDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Campuses", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to Campuses", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Campuses", e);
        }
        return Collections.emptyList();
    }

    public CampusResponseDTO getById(Long id, Long organizationId) {
        log.info("Fetching Campus with id: {} for organization: {}", id, organizationId);
        CampusEntity campusEntity = campusRepository.findByIdAndInstituteIdAndDeletedFalse(id, organizationId)
                .orElseThrow(() -> {
                    log.warn("Campus not found with id: {} for organization: {}", id, organizationId);
                    return new ResourceNotFoundException("Campus not found with id: " + id);
                });

        ProvinceEntity provinceEntity = provinceRepository.findByIdAndDeletedFalse(campusEntity.getProvinceId())
                .orElseThrow(() -> {
                    log.info("Fetching Province with id: {}", campusEntity.getProvinceId());
                    return new ResourceNotFoundException("Province not found with id: " + campusEntity.getProvinceId());
                });
        CityEntity cityEntity = cityRepository.findByIdAndDeletedFalse(campusEntity.getCityId()).orElseThrow(() -> {
            log.info("Fetching City with id: {}", campusEntity.getCityId());
            return new ResourceNotFoundException("City not found with id: " + campusEntity.getCityId());
        });

        CampusResponseDTO campusResponseDTO = MapperUtil.mapObject(campusEntity, CampusResponseDTO.class);
        campusResponseDTO.setProvince(MapperUtil.mapObject(provinceEntity, ProvinceResponseDTO.class));
        campusResponseDTO.setCity(MapperUtil.mapObject(cityEntity, CityResponseDTO.class));
        log.info("Successfully fetched Campus: id={}", campusResponseDTO.getId());
        return campusResponseDTO;
    }

    public List<CampusResponseDTO> findByInstituteId(Long id) {
        log.info("Fetching campuses for institute ID: {}", id);
        if (id == null) {
            log.error("Institute ID is null");
            throw new IllegalArgumentException("Institute ID must not be null");
        }

        List<CampusEntity> campusEntities = campusRepository.findByInstituteIdAndDeletedFalse(id);
        if (campusEntities.isEmpty()) {
            log.warn("No campuses found for institute ID: {}", id);
            return List.of(); // safe empty list
        }
        List<CampusResponseDTO> campusResponseDTOList = MapperUtil.mapList(campusEntities, CampusResponseDTO.class);
        log.info("Found {} campuses for institute ID: {}", campusResponseDTOList.size(), id);
        return campusResponseDTOList;
    }

    public List<CampusResponseDTO> findByCampusNameContaining(String name, Long organizationId) {
        log.info("Fetching campuses containing name: '{}' for organization: {}", name, organizationId);
        if (name == null || name.trim().isEmpty()) {
            log.error("Campus name is null or empty");
            throw new IllegalArgumentException("Campus name must not be null or empty");
        }

        List<CampusEntity> campusEntities = campusRepository.findByCampusNameContainingAndDeletedFalse(name);
        // We might want to filter by institute ID as well if the repository method
        // doesn't support it yet
        // For now, let's assume we want to keep it simple but filter the results
        List<CampusResponseDTO> campusResponseDTOList = MapperUtil.mapList(
                campusEntities.stream()
                        .filter(c -> c.getInstitute() != null && c.getInstitute().getId().equals(organizationId))
                        .toList(),
                CampusResponseDTO.class);
        log.info("Found {} campuses containing name: '{}' for organization: {}", campusResponseDTOList.size(), name,
                organizationId);
        return campusResponseDTOList;
    }

    public int softDeleteById(Long id, Long organizationId) {
        log.info("Soft delete request received for Campus ID: {} for organization: {}", id, organizationId);
        try {
            return campusRepository.softDeleteByIdAndInstituteId(id, organizationId);
        } catch (Exception e) {
            log.error("Error while soft deleting Campus with ID {} for organization {}", id, organizationId, e);
            throw e;
        }
    }

    public CampusCreateRequestDTO createCampus(CampusCreateRequestDTO requestDTO, Long organizationId) {
        log.info("Creating new Campus: {} for organization: {}", requestDTO, organizationId);
        try {
            InstituteEntity instituteEntity = instituteDaoImp.findById(organizationId);
            if (instituteEntity == null) {
                throw new ResourceNotFoundException("Institute not found with id: " + organizationId);
            }
            CampusEntity entity = MapperUtil.mapObject(requestDTO, CampusEntity.class);
            entity.setId(null);
            entity.setInstitute(instituteEntity);
            CampusEntity campusEntity = campusRepository.save(entity);

            CampusCreateRequestDTO response = MapperUtil.mapObject(campusEntity, CampusCreateRequestDTO.class);
            log.info("Campus created successfully with ID: {}", response.getId());
            return response;

        } catch (DataAccessException dae) {
            log.error("Database error while creating Campus", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating Campus");
            throw ex;
        }
    }

    public CampusResponseDTO updateCampus(Long id, @Valid CampusCreateRequestDTO requestDTO, Long organizationId) {
        log.info("Updating Campus with id {} for organization {} using DTO {}", id, organizationId, requestDTO);

        CampusEntity entity = campusRepository.findByIdAndInstituteIdAndDeletedFalse(id, organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Campus not found with id: " + id));

        entity.setActive(requestDTO.isActive());
        if (requestDTO.getCampusName() != null && !requestDTO.getCampusName().isBlank()) {
            entity.setCampusName(requestDTO.getCampusName());
        }

        if (requestDTO.getContactNumber() != null) {
            entity.setContactNumber(requestDTO.getContactNumber());
        }

        if (requestDTO.getEmail() != null) {
            entity.setEmail(requestDTO.getEmail());
        }

        if (requestDTO.getWebsite() != null) {
            entity.setWebsite(requestDTO.getWebsite());
        }

        if (requestDTO.getAddress() != null) {
            entity.setAddress(requestDTO.getAddress());
        }

        if (requestDTO.getProvinceId() != null) {
            entity.setProvinceId(requestDTO.getProvinceId());
        }

        if (requestDTO.getCityId() != null) {
            entity.setCityId(requestDTO.getCityId());
        }
        // Update Logo (byte[])
        if (requestDTO.getLogo() != null) {
            entity.setLogo(requestDTO.getLogo());
        }

        if (requestDTO.getInstituteId() != null && (entity.getInstitute() == null
                || !entity.getInstitute().getId().equals(requestDTO.getInstituteId()))) {
            InstituteEntity institute = instituteDaoImp.findById(requestDTO.getInstituteId());
            // .orElseThrow(() -> new ResourceNotFoundException("Institute not found with
            // id: " + requestDTO.getInstituteId()));
            entity.setInstitute(institute);
        }

        CampusEntity updated = campusRepository.save(entity);
        CampusResponseDTO response = MapperUtil.mapObject(updated, CampusResponseDTO.class);
        log.info("Campus updated successfully: {}", response.getId());
        return response;
    }

    public List<CampusResponseDTO> searchByKeyword(String keyword, Long organizationId) {
        try {
            log.info("Fetching all Campuses based on search from database for organization: {}", organizationId);
            List<CampusEntity> result = campusRepository.searchByKeywordAndInstituteId(keyword, organizationId);
            List<CampusResponseDTO> responseDTOS = MapperUtil.mapList(result, CampusResponseDTO.class);
            log.info("Successfully fetched Campuses based on search {} ", responseDTOS.size());
            return responseDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Campuses based on search", dae);
            throw new CustomServiceException("Unable to fetch Campuses based on search from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping Campus Entity to Campuses based on search", me);
            throw new CustomServiceException("Error converting Campuses data based on search", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Campuses based on search", e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }

    public Long getCampusCountByInstituteId(Long instituteId) {
        if (instituteId == null) {
            log.error("Institute ID is null");
            throw new IllegalArgumentException("Institute ID must not be null");
        }
        Long count = campusRepository.countByInstituteId(instituteId);
        log.info("Found {} campuses for institute ID {}", count, instituteId);
        return count;
    }
}
