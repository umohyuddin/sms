package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.EducationLevelErrors;
import com.smartsolutions.eschool.lookups.dtos.educationLevel.requestDto.EducationLevelRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.educationLevel.responseDto.EducationLevelResponseDTO;
import com.smartsolutions.eschool.lookups.mapper.EducationLevelMapper;
import com.smartsolutions.eschool.lookups.model.EducationLevelEntity;
import com.smartsolutions.eschool.lookups.repository.EducationLevelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class EducationLevelService {
    private final EducationLevelRepository educationLevelRepository;

    public EducationLevelService(EducationLevelRepository educationLevelRepository) {
        this.educationLevelRepository = educationLevelRepository;
    }

    public List<EducationLevelResponseDTO> getAll() {
        log.info("[Service:EducationLevelService] getAll() called - Fetching all education levels");
        List<EducationLevelEntity> result = educationLevelRepository.findAllNotDeleted();
        List<EducationLevelResponseDTO> responseDTOs = EducationLevelMapper.toResponseDTOList(result);
        log.info("[Service:EducationLevelService] getAll() succeeded - Found {} education levels", responseDTOs.size());
        return responseDTOs;
    }

    public List<EducationLevelResponseDTO> getAllActive() {
        log.info("[Service:EducationLevelService] getAllActive() called - Fetching active education levels");
        List<EducationLevelEntity> result = educationLevelRepository.findAllActive();
        List<EducationLevelResponseDTO> responseDTOs = EducationLevelMapper.toResponseDTOList(result);
        log.info("[Service:EducationLevelService] getAllActive() succeeded - Found {} active education levels", responseDTOs.size());
        return responseDTOs;
    }

    public EducationLevelResponseDTO getById(Long id) {
        log.info("[Service:EducationLevelService] getById() called - id: {}", id);
        EducationLevelEntity entity = educationLevelRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(EducationLevelErrors.EDUCATION_LEVEL_NOT_FOUND, HttpStatus.NOT_FOUND));

        EducationLevelResponseDTO responseDTO = EducationLevelMapper.toResponseDTO(entity);
        log.info("[Service:EducationLevelService] getById() succeeded - Found education level: {}", id);
        return responseDTO;
    }

    public List<EducationLevelResponseDTO> searchByKeyword(String keyword) {
        log.info("[Service:EducationLevelService] searchByKeyword() called - keyword: {}", keyword);
        List<EducationLevelEntity> result = educationLevelRepository.searchByKeyword(keyword);
        List<EducationLevelResponseDTO> responseDTOs = EducationLevelMapper.toResponseDTOList(result);
        log.info("[Service:EducationLevelService] searchByKeyword() succeeded - Found {} education levels", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        log.info("[Service:EducationLevelService] softDeleteById() called - id: {}", id);

        int result = educationLevelRepository.softDeleteById(id);
        if (result == 0) {
            throw new ApiException(EducationLevelErrors.EDUCATION_LEVEL_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:EducationLevelService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public EducationLevelResponseDTO create(EducationLevelRequestDTO requestDTO) {
        log.info("[Service:EducationLevelService] create() called - Creating: {}", requestDTO.getName());

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().isEmpty()) {
            if (educationLevelRepository.existsByCode(requestDTO.getCode().trim())) {
                throw new ApiException(EducationLevelErrors.DUPLICATE_EDUCATION_LEVEL_CODE, "Education level code already exists", HttpStatus.CONFLICT);
            }
        }

        EducationLevelEntity entity = EducationLevelMapper.toEntity(requestDTO);
        EducationLevelEntity saved = educationLevelRepository.save(entity);

        log.info("[Service:EducationLevelService] create() succeeded - Created with id: {}", saved.getId());
        return EducationLevelMapper.toResponseDTO(saved);
    }

    @Transactional
    public EducationLevelResponseDTO update(Long id, EducationLevelRequestDTO requestDTO) {
        log.info("[Service:EducationLevelService] update() called - id: {}", id);

        EducationLevelEntity existing = educationLevelRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(EducationLevelErrors.EDUCATION_LEVEL_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().equals(existing.getCode())) {
            if (educationLevelRepository.existsByCodeAndIdNot(requestDTO.getCode().trim(), id)) {
                throw new ApiException(EducationLevelErrors.DUPLICATE_EDUCATION_LEVEL_CODE, "Education level code already exists", HttpStatus.CONFLICT);
            }
        }

        EducationLevelMapper.updateEntityFromDTO(existing, requestDTO);
        EducationLevelEntity updated = educationLevelRepository.save(existing);

        log.info("[Service:EducationLevelService] update() succeeded - id: {}", id);
        return EducationLevelMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Service:EducationLevelService] getStatistics() called");

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalEducationLevels", educationLevelRepository.countAllNotDeleted());
        stats.put("activeEducationLevels", educationLevelRepository.countByIsActiveTrue());
        stats.put("inactiveEducationLevels", educationLevelRepository.countByIsActiveFalse());

        log.info("[Service:EducationLevelService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
