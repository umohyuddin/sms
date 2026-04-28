package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.EducationBoardErrors;
import com.smartsolutions.eschool.school.dtos.educationBoards.requestDto.EducationBoardRequestDTO;
import com.smartsolutions.eschool.school.dtos.educationBoards.responseDto.EducationBoardResponseDTO;
import com.smartsolutions.eschool.school.mapper.EducationBoardMapper;
import com.smartsolutions.eschool.school.model.EducationBoardEntity;
import com.smartsolutions.eschool.school.repository.EducationBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class EducationBoardService {

    private final EducationBoardRepository educationBoardRepository;

    public EducationBoardService(EducationBoardRepository educationBoardRepository) {
        this.educationBoardRepository = educationBoardRepository;
    }

    public List<EducationBoardResponseDTO> getAll() {
        log.info("[Service:EducationBoardService] getAll() called - Fetching all education boards");
        List<EducationBoardEntity> result = educationBoardRepository.findAllNotDeleted();
        List<EducationBoardResponseDTO> responseDTOs = EducationBoardMapper.toResponseDTOList(result);
        log.info("[Service:EducationBoardService] getAll() succeeded - Found {} education boards", responseDTOs.size());
        return responseDTOs;
    }

    public List<EducationBoardResponseDTO> getAllActive() {
        log.info("[Service:EducationBoardService] getAllActive() called - Fetching active education boards");
        List<EducationBoardEntity> result = educationBoardRepository.findAllActive();
        List<EducationBoardResponseDTO> responseDTOs = EducationBoardMapper.toResponseDTOList(result);
        log.info("[Service:EducationBoardService] getAllActive() succeeded - Found {} active education boards", responseDTOs.size());
        return responseDTOs;
    }

    public EducationBoardResponseDTO getById(Long id) {
        log.info("[Service:EducationBoardService] getById() called - id: {}", id);
        EducationBoardEntity entity = educationBoardRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(EducationBoardErrors.EDUCATION_BOARD_NOT_FOUND, HttpStatus.NOT_FOUND));

        EducationBoardResponseDTO responseDTO = EducationBoardMapper.toResponseDTO(entity);
        log.info("[Service:EducationBoardService] getById() succeeded - Found education board: {}", id);
        return responseDTO;
    }

    public List<EducationBoardResponseDTO> searchByKeyword(String keyword) {
        log.info("[Service:EducationBoardService] searchByKeyword() called - keyword: {}", keyword);
        List<EducationBoardEntity> result = educationBoardRepository.searchByKeyword(keyword);
        List<EducationBoardResponseDTO> responseDTOs = EducationBoardMapper.toResponseDTOList(result);
        log.info("[Service:EducationBoardService] searchByKeyword() succeeded - Found {} education boards", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        log.info("[Service:EducationBoardService] softDeleteById() called - id: {}", id);

        int result = educationBoardRepository.softDeleteById(id);
        if (result == 0) {
            throw new ApiException(EducationBoardErrors.EDUCATION_BOARD_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:EducationBoardService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public EducationBoardResponseDTO createEducationBoard(EducationBoardRequestDTO requestDTO) {
        log.info("[Service:EducationBoardService] createEducationBoard() called - Creating: {}", requestDTO.getName());

        if (requestDTO.getName() != null && !requestDTO.getName().trim().isEmpty()) {
            if (educationBoardRepository.existsByName(requestDTO.getName().trim())) {
                throw new ApiException(EducationBoardErrors.DUPLICATE_EDUCATION_BOARD_CODE, "Education board name already exists", HttpStatus.CONFLICT);
            }
        }

        EducationBoardEntity entity = EducationBoardMapper.toEntity(requestDTO);
        EducationBoardEntity saved = educationBoardRepository.save(entity);

        log.info("[Service:EducationBoardService] createEducationBoard() succeeded - Created with id: {}", saved.getId());
        return EducationBoardMapper.toResponseDTO(saved);
    }

    @Transactional
    public EducationBoardResponseDTO updateEducationBoard(Long id, EducationBoardRequestDTO requestDTO) {
        log.info("[Service:EducationBoardService] updateEducationBoard() called - id: {}", id);

        EducationBoardEntity existing = educationBoardRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(EducationBoardErrors.EDUCATION_BOARD_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getName() != null && !requestDTO.getName().trim().equals(existing.getName())) {
            if (educationBoardRepository.existsByNameAndIdNot(requestDTO.getName().trim(), id)) {
                throw new ApiException(EducationBoardErrors.DUPLICATE_EDUCATION_BOARD_CODE, "Education board name already exists", HttpStatus.CONFLICT);
            }
        }

        EducationBoardMapper.updateEntityFromDTO(existing, requestDTO);
        EducationBoardEntity updated = educationBoardRepository.save(existing);

        log.info("[Service:EducationBoardService] updateEducationBoard() succeeded - id: {}", id);
        return EducationBoardMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Service:EducationBoardService] getStatistics() called");

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalEducationBoards", educationBoardRepository.countAllNotDeleted());
        stats.put("activeEducationBoards", educationBoardRepository.countByIsActiveTrue());
        stats.put("inactiveEducationBoards", educationBoardRepository.countByIsActiveFalse());

        log.info("[Service:EducationBoardService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
