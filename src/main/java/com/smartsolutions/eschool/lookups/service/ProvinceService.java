package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.lookups.dtos.province.requestDto.ProvinceRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.model.ProvinceEntity;
import com.smartsolutions.eschool.lookups.repository.ProvinceRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProvinceService {
    private final ProvinceRepository provinceRepository;

    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    // ----------------------------------------
    // CREATE
    // ----------------------------------------
    public ProvinceResponseDTO createProvince(@Valid ProvinceRequestDTO requestDTO) {
        log.info("Creating new Province: {}", requestDTO.getName());
        try {
            ProvinceEntity entity = MapperUtil.mapObject(requestDTO, ProvinceEntity.class);
            provinceRepository.save(entity);

            log.info("Province saved with id={}", entity.getId());
            return MapperUtil.mapObject(entity, ProvinceResponseDTO.class);

        } catch (DataAccessException dae) {
            log.error("Database error while creating Province", dae);
            throw new CustomServiceException("Failed to create Province due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating Province", e);
            throw new CustomServiceException("Failed to create Province");
        }
    }

    // ----------------------------------------
    // GET ALL
    // ----------------------------------------
    public List<ProvinceResponseDTO> getAll() {
        try {
            log.info("Fetching all Provinces");
            List<ProvinceEntity> result = provinceRepository.findAllActive();

            return MapperUtil.mapList(result, ProvinceResponseDTO.class);

        } catch (DataAccessException dae) {
            log.error("Database error while fetching Provinces", dae);
            throw new CustomServiceException("Unable to fetch Provinces", dae);
        } catch (MappingException me) {
            log.error("Error mapping ProvinceEntity to ProvinceResponseDTO", me);
            throw new CustomServiceException("Error converting province data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching provinces", e);
            throw new CustomServiceException("Unexpected error occurred", e);
        }
    }

    // ----------------------------------------
    // GET BY ID
    // ----------------------------------------
    public ProvinceResponseDTO getById(Long id) {
        log.info("Fetching Province with id={}", id);

        ProvinceEntity entity = provinceRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Province not found with id=" + id));

        try {
            return MapperUtil.mapObject(entity, ProvinceResponseDTO.class);

        } catch (Exception e) {
            log.error("Error mapping ProvinceEntity for id={}", id, e);
            throw new CustomServiceException("Failed to map Province data");
        }
    }

    // ----------------------------------------
    // GET ACTIVE PROVINCES
    // ----------------------------------------
    public List<ProvinceResponseDTO> getAllActive() {
        try {
            log.info("Fetching active Provinces");
            List<ProvinceEntity> result = provinceRepository.findAllActive();

            return MapperUtil.mapList(result, ProvinceResponseDTO.class);

        } catch (Exception e) {
            log.error("Error fetching active provinces", e);
            throw new CustomServiceException("Failed to fetch active Provinces", e);
        }
    }

//    // ----------------------------------------
//    // GET INACTIVE PROVINCES
//    // ----------------------------------------
//    public List<ProvinceResponseDTO> getAllInactive() {
//        try {
//            log.info("Fetching inactive Provinces");
//            List<ProvinceEntity> result = provinceRepository.findAllInactive();
//
//            return MapperUtil.mapList(result, ProvinceResponseDTO.class);
//
//        } catch (Exception e) {
//            log.error("Error fetching inactive provinces", e);
//            throw new CustomServiceException("Failed to fetch inactive Provinces", e);
//        }
//    }

    // ----------------------------------------
    // SOFT DELETE BY ID
    // ----------------------------------------
    public int softDeleteById(Long id) {
        log.info("Soft delete request for Province id={}", id);

        try {
            return provinceRepository.softDeleteById(id);

        } catch (Exception e) {
            log.error("Error deleting Province id={}", id, e);
            throw new CustomServiceException("Failed to delete Province", e);
        }
    }

    // ----------------------------------------
    // SEARCH BY KEYWORD
    // ----------------------------------------
    public List<ProvinceResponseDTO> searchByKeyword(String keyword) {
        try {
            log.info("Searching Provinces by keyword: {}", keyword);

            List<ProvinceEntity> result = provinceRepository.searchByKeyword(keyword);

            return MapperUtil.mapList(result, ProvinceResponseDTO.class);

        } catch (Exception e) {
            log.error("Error searching provinces", e);
            throw new CustomServiceException("Failed to search Provinces", e);
        }
    }
}
