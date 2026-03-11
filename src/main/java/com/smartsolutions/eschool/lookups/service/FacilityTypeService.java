package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.FacilityTypeErrors;
import com.smartsolutions.eschool.lookups.dtos.facilityType.requestDto.FacilityTypeRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.facilityType.responseDto.FacilityTypeResponseDTO;
import com.smartsolutions.eschool.lookups.mapper.FacilityTypeMapper;
import com.smartsolutions.eschool.lookups.model.FacilityTypeEntity;
import com.smartsolutions.eschool.lookups.repository.FacilityTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class FacilityTypeService {
    private final FacilityTypeRepository facilityTypeRepository;

    public FacilityTypeService(FacilityTypeRepository facilityTypeRepository) {
        this.facilityTypeRepository = facilityTypeRepository;
    }

    public List<FacilityTypeResponseDTO> getAll() {
        log.info("[Service:FacilityTypeService] getAll() called - Fetching all facility types");
        List<FacilityTypeEntity> result = facilityTypeRepository.findAllNotDeleted();
        List<FacilityTypeResponseDTO> responseDTOs = FacilityTypeMapper.toResponseDTOList(result);
        log.info("[Service:FacilityTypeService] getAll() succeeded - Found {} facility types", responseDTOs.size());
        return responseDTOs;
    }

    public List<FacilityTypeResponseDTO> getAllActive() {
        log.info("[Service:FacilityTypeService] getAllActive() called - Fetching active facility types");
        List<FacilityTypeEntity> result = facilityTypeRepository.findAllActive();
        List<FacilityTypeResponseDTO> responseDTOs = FacilityTypeMapper.toResponseDTOList(result);
        log.info("[Service:FacilityTypeService] getAllActive() succeeded - Found {} active facility types", responseDTOs.size());
        return responseDTOs;
    }

    public FacilityTypeResponseDTO getById(Long id) {
        log.info("[Service:FacilityTypeService] getById() called - id: {}", id);
        FacilityTypeEntity entity = facilityTypeRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(FacilityTypeErrors.FACILITY_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));

        FacilityTypeResponseDTO responseDTO = FacilityTypeMapper.toResponseDTO(entity);
        log.info("[Service:FacilityTypeService] getById() succeeded - Found facility type: {}", id);
        return responseDTO;
    }

    public List<FacilityTypeResponseDTO> searchByKeyword(String keyword) {
        log.info("[Service:FacilityTypeService] searchByKeyword() called - keyword: {}", keyword);
        List<FacilityTypeEntity> result = facilityTypeRepository.searchByKeyword(keyword);
        List<FacilityTypeResponseDTO> responseDTOs = FacilityTypeMapper.toResponseDTOList(result);
        log.info("[Service:FacilityTypeService] searchByKeyword() succeeded - Found {} facility types", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        log.info("[Service:FacilityTypeService] softDeleteById() called - id: {}", id);

        int result = facilityTypeRepository.softDeleteById(id);
        if (result == 0) {
            throw new ApiException(FacilityTypeErrors.FACILITY_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:FacilityTypeService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public FacilityTypeResponseDTO create(FacilityTypeRequestDTO requestDTO) {
        log.info("[Service:FacilityTypeService] create() called - Creating: {}", requestDTO.getName());

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().isEmpty()) {
            if (facilityTypeRepository.existsByCode(requestDTO.getCode().trim())) {
                throw new ApiException(FacilityTypeErrors.DUPLICATE_FACILITY_TYPE_CODE, "Facility type code already exists", HttpStatus.CONFLICT);
            }
        }

        FacilityTypeEntity entity = FacilityTypeMapper.toEntity(requestDTO);
        FacilityTypeEntity saved = facilityTypeRepository.save(entity);

        log.info("[Service:FacilityTypeService] create() succeeded - Created with id: {}", saved.getId());
        return FacilityTypeMapper.toResponseDTO(saved);
    }

    @Transactional
    public FacilityTypeResponseDTO update(Long id, FacilityTypeRequestDTO requestDTO) {
        log.info("[Service:FacilityTypeService] update() called - id: {}", id);

        FacilityTypeEntity existing = facilityTypeRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(FacilityTypeErrors.FACILITY_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().equals(existing.getCode())) {
            if (facilityTypeRepository.existsByCodeAndIdNot(requestDTO.getCode().trim(), id)) {
                throw new ApiException(FacilityTypeErrors.DUPLICATE_FACILITY_TYPE_CODE, "Facility type code already exists", HttpStatus.CONFLICT);
            }
        }

        FacilityTypeMapper.updateEntityFromDTO(existing, requestDTO);
        FacilityTypeEntity updated = facilityTypeRepository.save(existing);

        log.info("[Service:FacilityTypeService] update() succeeded - id: {}", id);
        return FacilityTypeMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Service:FacilityTypeService] getStatistics() called");

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalFacilityTypes", facilityTypeRepository.countAllNotDeleted());
        stats.put("activeFacilityTypes", facilityTypeRepository.countByIsActiveTrue());
        stats.put("inactiveFacilityTypes", facilityTypeRepository.countByIsActiveFalse());

        log.info("[Service:FacilityTypeService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
