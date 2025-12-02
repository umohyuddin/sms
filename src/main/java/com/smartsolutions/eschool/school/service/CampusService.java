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
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.model.DiscountTypeEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.CampusDao;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.school.repository.InstituteDaoImp;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CampusService {


    private final CampusRepository campusRepository;
    private final InstituteDaoImp instituteDaoImp;
    private final ProvinceRepository provinceRepository;
    private final CityRepository cityRepository;

    public CampusService(CampusRepository campusRepository, InstituteDaoImp instituteDaoImp, ProvinceRepository provinceRepository, CityRepository cityRepository) {
        this.campusRepository = campusRepository;
        this.instituteDaoImp = instituteDaoImp;
        this.provinceRepository = provinceRepository;
        this.cityRepository = cityRepository;
    }

    public List<CampusResponseDTO> getAll() {
        try {
            log.info("Fetching all Campuses from database");
            //List<CampusEntity> result = campusDao.findAll();
            List<CampusEntity> result = campusRepository.findByDeletedFalse();
            log.info("Successfully fetched {} Campuses", result.size());
            List<CampusResponseDTO> campusResponseDTOList = MapperUtil.mapList(result, CampusResponseDTO.class);
            log.info("Successfully fetched {} Campuses", campusResponseDTOList);
            return campusResponseDTOList;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Campuses", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to Campuses", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Campuses", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }

    public CampusResponseDTO getById(Long id) {
        log.info("Fetching Campus with id: {}", id);
        CampusEntity campusEntity = campusRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> {
            log.info("Fetching Campus with id: {}", id);
            return new ResourceNotFoundException("Campus not found with id: " + id);
        });

        ProvinceEntity provinceEntity = provinceRepository.findByIdAndDeletedFalse(campusEntity.getProvinceId()).orElseThrow(() -> {
            log.info("Fetching Province with id: {}", campusEntity.getProvinceId());
            return new ResourceNotFoundException("Province not found with id: " + id);
        });
        CityEntity cityEntity = cityRepository.findByIdAndDeletedFalse(campusEntity.getCityId()).orElseThrow(() -> {
            log.info("Fetching City with id: {}", campusEntity.getCityId());
            return new ResourceNotFoundException("City not found with id: " + id);
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


    public List<CampusResponseDTO> findByCampusNameContaining(String name) {
        log.info("Fetching campuses containing name: '{}'", name);
        if (name == null || name.trim().isEmpty()) {
            log.error("Campus name is null or empty");
            throw new IllegalArgumentException("Campus name must not be null or empty");
        }

        List<CampusEntity> campusEntities = campusRepository.findByCampusNameContainingAndDeletedFalse(name);
        if (campusEntities.isEmpty()) {
            log.warn("No campuses found for institute name: {}", name);
            return List.of(); // safe empty list
        }
        List<CampusResponseDTO> campusResponseDTOList = MapperUtil.mapList(campusEntities, CampusResponseDTO.class);
        log.info("Found {} campuses containing name: '{}'", campusResponseDTOList.size(), name);
        return campusResponseDTOList;
    }

    public int softDeleteById(Long id) {
        log.info("Soft delete request received for Campus ID: {}", id);
        try {
            return campusRepository.softDeleteById(id);
        } catch (Exception e) {
            log.error("Error while soft deleting Campus with ID {}", id, e);
            throw e;
        }
    }

    public CampusCreateRequestDTO createCampus(CampusCreateRequestDTO requestDTO) {
        log.info("Creating new Campus: {}", requestDTO);
        try {
//            Province province = EnumValidatorUtil.getEnumByName(Province.class, requestDTO.getProvinceName());
//            Cities city = EnumValidatorUtil.getEnumByName(Cities.class, requestDTO.getCityName());
            InstituteEntity instituteEntity = instituteDaoImp.findById(1L);
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


    public CampusResponseDTO updateSection(Long id, @Valid CampusCreateRequestDTO requestDTO) {
        log.info("Updating Campus with id {} using DTO {}", id, requestDTO);

        CampusEntity entity = campusRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campus not found with id: " + id));

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

//        // Province (String)
//        if (requestDTO.getProvinceName() != null) {
//            entity.setProvince(requestDTO.getProvinceName());
//        }
//
//        // City (String)
//        if (requestDTO.getCityName() != null) {
//            entity.setCity(requestDTO.getCityName());
//        }

        // Province Id
        if (requestDTO.getProvinceId() != null) {
            entity.setProvinceId(requestDTO.getProvinceId());
        }

        // City Id
        if (requestDTO.getCityId() != null) {
            entity.setCityId(requestDTO.getCityId());
        }
        // Update Logo (byte[])
        if (requestDTO.getLogo() != null) {
            entity.setLogo(requestDTO.getLogo());
        }


        if (requestDTO.getInstituteId() != null &&
                (entity.getInstitute() == null || !entity.getInstitute().getId().equals(requestDTO.getInstituteId()))) {

            InstituteEntity institute = instituteDaoImp.findById(requestDTO.getInstituteId());
//                    .orElseThrow(() -> new ResourceNotFoundException("Institute not found with id: " + requestDTO.getInstituteId()));

            entity.setInstitute(institute);
        }

        CampusEntity updated = campusRepository.save(entity);
        CampusResponseDTO response = MapperUtil.mapObject(updated, CampusResponseDTO.class);
        log.info("Campus updated successfully: {}", response.getId());
        return response;
    }

    public List<CampusResponseDTO> searchByKeyword(String keyword) {
        try {
            log.info("Fetching all Campuses based on search from database");
            List<CampusEntity> result = campusRepository.searchByKeyword(keyword);
            List<CampusResponseDTO> responseDTOS = MapperUtil.mapList(result, CampusResponseDTO.class);
            log.info("Successfully fetched Campuses based on search {} ", responseDTOS.size());
            return responseDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Discount Types based on search", dae);
            throw new CustomServiceException("Unable to fetch Discount Types based on search from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping DiscountTpe Entity to Discount Types based on search", me);
            throw new CustomServiceException("Error converting  Discount Types data based on search", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Discount Types based on search", e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }
}


