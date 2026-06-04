package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.CurriculumErrors;
import com.smartsolutions.eschool.lookups.dtos.curriculum.requestDto.CurriculumRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.curriculum.responseDto.CurriculumResponseDTO;
import com.smartsolutions.eschool.lookups.mapper.CurriculumMapper;
import com.smartsolutions.eschool.lookups.model.CurriculumEntity;
import com.smartsolutions.eschool.lookups.repository.CurriculumRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CurriculumService {
    private final CurriculumRepository curriculumRepository;

    public CurriculumService(CurriculumRepository curriculumRepository) {
        this.curriculumRepository = curriculumRepository;
    }

    public List<CurriculumResponseDTO> getAll() {
        log.info("[Service:CurriculumService] getAll() called - Fetching all curricula");
        List<CurriculumEntity> result = curriculumRepository.findAllNotDeleted();
        List<CurriculumResponseDTO> responseDTOs = CurriculumMapper.toResponseDTOList(result);
        log.info("[Service:CurriculumService] getAll() succeeded - Found {} curricula", responseDTOs.size());
        return responseDTOs;
    }

    public List<CurriculumResponseDTO> getAllActive() {
        log.info("[Service:CurriculumService] getAllActive() called - Fetching active curricula");
        List<CurriculumEntity> result = curriculumRepository.findAllActive();
        List<CurriculumResponseDTO> responseDTOs = CurriculumMapper.toResponseDTOList(result);
        log.info("[Service:CurriculumService] getAllActive() succeeded - Found {} active curricula", responseDTOs.size());
        return responseDTOs;
    }

    public CurriculumResponseDTO getById(Long id) {
        log.info("[Service:CurriculumService] getById() called - id: {}", id);
        CurriculumEntity entity = curriculumRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(CurriculumErrors.CURRICULUM_NOT_FOUND, HttpStatus.NOT_FOUND));

        CurriculumResponseDTO responseDTO = CurriculumMapper.toResponseDTO(entity);
        log.info("[Service:CurriculumService] getById() succeeded - Found curriculum: {}", id);
        return responseDTO;
    }

    public List<CurriculumResponseDTO> searchByKeyword(String keyword) {
        log.info("[Service:CurriculumService] searchByKeyword() called - keyword: {}", keyword);
        List<CurriculumEntity> result = curriculumRepository.searchByKeyword(keyword);
        List<CurriculumResponseDTO> responseDTOs = CurriculumMapper.toResponseDTOList(result);
        log.info("[Service:CurriculumService] searchByKeyword() succeeded - Found {} curricula", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        log.info("[Service:CurriculumService] softDeleteById() called - id: {}", id);

        int result = curriculumRepository.softDeleteById(id);
        if (result == 0) {
            throw new ApiException(CurriculumErrors.CURRICULUM_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:CurriculumService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public CurriculumResponseDTO create(CurriculumRequestDTO requestDTO) {
        log.info("[Service:CurriculumService] create() called - Creating: {}", requestDTO.getName());

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().isEmpty()) {
            if (curriculumRepository.existsByCode(requestDTO.getCode().trim())) {
                throw new ApiException(CurriculumErrors.DUPLICATE_CURRICULUM_CODE, "Curriculum code already exists", HttpStatus.CONFLICT);
            }
        }

        CurriculumEntity entity = CurriculumMapper.toEntity(requestDTO);
        CurriculumEntity saved = curriculumRepository.save(entity);

        log.info("[Service:CurriculumService] create() succeeded - Created with id: {}", saved.getId());
        return CurriculumMapper.toResponseDTO(saved);
    }

    @Transactional
    public CurriculumResponseDTO update(Long id, CurriculumRequestDTO requestDTO) {
        log.info("[Service:CurriculumService] update() called - id: {}", id);

        CurriculumEntity existing = curriculumRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(CurriculumErrors.CURRICULUM_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getCode() != null && !requestDTO.getCode().trim().equals(existing.getCode())) {
            if (curriculumRepository.existsByCodeAndIdNot(requestDTO.getCode().trim(), id)) {
                throw new ApiException(CurriculumErrors.DUPLICATE_CURRICULUM_CODE, "Curriculum code already exists", HttpStatus.CONFLICT);
            }
        }

        CurriculumMapper.updateEntityFromDTO(existing, requestDTO);
        CurriculumEntity updated = curriculumRepository.save(existing);

        log.info("[Service:CurriculumService] update() succeeded - id: {}", id);
        return CurriculumMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Service:CurriculumService] getStatistics() called");

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalCurricula", curriculumRepository.countAllNotDeleted());
        stats.put("activeCurricula", curriculumRepository.countByIsActiveTrue());
        stats.put("inactiveCurricula", curriculumRepository.countByIsActiveFalse());

        log.info("[Service:CurriculumService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
