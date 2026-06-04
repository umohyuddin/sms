package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.SchoolTypeErrors;
import com.smartsolutions.eschool.school.dtos.schoolTypes.requestDto.SchoolTypeCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.schoolTypes.responseDto.SchoolTypeResponseDTO;
import com.smartsolutions.eschool.school.mapper.SchoolTypeMapper;
import com.smartsolutions.eschool.school.model.SchoolTypeEntity;
import com.smartsolutions.eschool.school.repository.SchoolTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SchoolTypeService {

    private final SchoolTypeRepository schoolTypeRepository;

    public SchoolTypeService(SchoolTypeRepository schoolTypeRepository) {
        this.schoolTypeRepository = schoolTypeRepository;
    }

    public List<SchoolTypeResponseDTO> getAll() {
        log.info("[Service:SchoolTypeService] getAll() called - Fetching all school types");
        List<SchoolTypeEntity> result = schoolTypeRepository.findAllGlobal();
        List<SchoolTypeResponseDTO> responseDTOs = SchoolTypeMapper.toResponseDTOList(result);
        log.info("[Service:SchoolTypeService] getAll() succeeded - Found {} school types", responseDTOs.size());
        return responseDTOs;
    }

    public List<SchoolTypeResponseDTO> getAllActive() {
        log.info("[Service:SchoolTypeService] getAllActive() called");
        List<SchoolTypeEntity> result = schoolTypeRepository.findAllActiveGlobal();
        List<SchoolTypeResponseDTO> responseDTOs = SchoolTypeMapper.toResponseDTOList(result);
        log.info("[Service:SchoolTypeService] getAllActive() succeeded - Found {} active school types", responseDTOs.size());
        return responseDTOs;
    }

    public SchoolTypeResponseDTO getById(Long id) {
        log.info("[Service:SchoolTypeService] getById() called - id: {}", id);
        SchoolTypeEntity entity = schoolTypeRepository.findById(id)
                .orElseThrow(() -> new ApiException(SchoolTypeErrors.SCHOOL_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));
        SchoolTypeResponseDTO responseDTO = SchoolTypeMapper.toResponseDTO(entity);
        log.info("[Service:SchoolTypeService] getById() succeeded - Found school type: {}", id);
        return responseDTO;
    }

    @Transactional
    public SchoolTypeResponseDTO create(SchoolTypeCreateRequestDTO requestDTO) {
        log.info("[Service:SchoolTypeService] create() called - code: {}", requestDTO.getCode());

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().isEmpty()) {
            if (schoolTypeRepository.existsByCode(requestDTO.getCode().trim())) {
                throw new ApiException(SchoolTypeErrors.DUPLICATE_SCHOOL_TYPE_CODE, HttpStatus.CONFLICT);
            }
        }

        SchoolTypeEntity entity = SchoolTypeMapper.toEntity(requestDTO);
        SchoolTypeEntity saved = schoolTypeRepository.save(entity);
        log.info("[Service:SchoolTypeService] create() succeeded - Created school type with id: {}", saved.getId());
        return SchoolTypeMapper.toResponseDTO(saved);
    }

    @Transactional
    public SchoolTypeResponseDTO update(Long id, SchoolTypeCreateRequestDTO requestDTO) {
        log.info("[Service:SchoolTypeService] update() called - id: {}", id);

        SchoolTypeEntity existing = schoolTypeRepository.findById(id)
                .orElseThrow(() -> new ApiException(SchoolTypeErrors.SCHOOL_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().equals(existing.getCode())) {
            if (schoolTypeRepository.existsByCodeAndIdNot(requestDTO.getCode().trim(), id)) {
                throw new ApiException(SchoolTypeErrors.DUPLICATE_SCHOOL_TYPE_CODE, HttpStatus.CONFLICT);
            }
        }

        SchoolTypeMapper.updateEntityFromDTO(existing, requestDTO);
        SchoolTypeEntity updated = schoolTypeRepository.save(existing);
        log.info("[Service:SchoolTypeService] update() succeeded - id: {}", id);
        return SchoolTypeMapper.toResponseDTO(updated);
    }

    @Transactional
    public void softDeleteById(Long id) {
        log.info("[Service:SchoolTypeService] softDeleteById() called - id: {}", id);
        int result = schoolTypeRepository.softDeleteById(id);
        if (result == 0) {
            throw new ApiException(SchoolTypeErrors.SCHOOL_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:SchoolTypeService] softDeleteById() succeeded - id: {}", id);
    }

    public List<SchoolTypeResponseDTO> searchByKeyword(String keyword) {
        log.info("[Service:SchoolTypeService] searchByKeyword() called - keyword: {}", keyword);
        List<SchoolTypeEntity> result = schoolTypeRepository.searchByKeyword(keyword);
        List<SchoolTypeResponseDTO> responseDTOs = SchoolTypeMapper.toResponseDTOList(result);
        log.info("[Service:SchoolTypeService] searchByKeyword() succeeded - Found {} school types", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public SchoolTypeResponseDTO activate(Long id) {
        log.info("[Service:SchoolTypeService] activate() called - id: {}", id);
        SchoolTypeEntity entity = schoolTypeRepository.findById(id)
                .orElseThrow(() -> new ApiException(SchoolTypeErrors.SCHOOL_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));
        entity.setActive(true);
        SchoolTypeEntity saved = schoolTypeRepository.save(entity);
        log.info("[Service:SchoolTypeService] activate() succeeded - id: {}", id);
        return SchoolTypeMapper.toResponseDTO(saved);
    }

    @Transactional
    public SchoolTypeResponseDTO deactivate(Long id) {
        log.info("[Service:SchoolTypeService] deactivate() called - id: {}", id);
        SchoolTypeEntity entity = schoolTypeRepository.findById(id)
                .orElseThrow(() -> new ApiException(SchoolTypeErrors.SCHOOL_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND));
        entity.setActive(false);
        SchoolTypeEntity saved = schoolTypeRepository.save(entity);
        log.info("[Service:SchoolTypeService] deactivate() succeeded - id: {}", id);
        return SchoolTypeMapper.toResponseDTO(saved);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Service:SchoolTypeService] getStatistics() called");
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalSchoolTypes", schoolTypeRepository.countAll());
        stats.put("activeSchoolTypes", schoolTypeRepository.countActive());
        stats.put("inactiveSchoolTypes", schoolTypeRepository.countInactive());
        log.info("[Service:SchoolTypeService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}

