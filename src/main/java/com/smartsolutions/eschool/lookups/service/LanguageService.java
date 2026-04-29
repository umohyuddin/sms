package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.LanguageErrors;
import com.smartsolutions.eschool.lookups.dtos.language.requestDto.LanguageRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.language.responseDto.LanguageResponseDTO;
import com.smartsolutions.eschool.lookups.mapper.LanguageMapper;
import com.smartsolutions.eschool.lookups.model.LanguageEntity;
import com.smartsolutions.eschool.lookups.repository.LanguageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<LanguageResponseDTO> getAll() {
        log.info("[Service:LanguageService] getAll() called - Fetching all languages");
        List<LanguageEntity> result = languageRepository.findAllNotDeleted();
        List<LanguageResponseDTO> responseDTOs = LanguageMapper.toResponseDTOList(result);
        log.info("[Service:LanguageService] getAll() succeeded - Found {} languages", responseDTOs.size());
        return responseDTOs;
    }

    public List<LanguageResponseDTO> getAllActive() {
        log.info("[Service:LanguageService] getAllActive() called - Fetching active languages");
        List<LanguageEntity> result = languageRepository.findAllActive();
        List<LanguageResponseDTO> responseDTOs = LanguageMapper.toResponseDTOList(result);
        log.info("[Service:LanguageService] getAllActive() succeeded - Found {} active languages", responseDTOs.size());
        return responseDTOs;
    }

    public LanguageResponseDTO getById(Long id) {
        log.info("[Service:LanguageService] getById() called - id: {}", id);
        LanguageEntity entity = languageRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(LanguageErrors.LANGUAGE_NOT_FOUND, HttpStatus.NOT_FOUND));

        LanguageResponseDTO responseDTO = LanguageMapper.toResponseDTO(entity);
        log.info("[Service:LanguageService] getById() succeeded - Found language: {}", id);
        return responseDTO;
    }

    public List<LanguageResponseDTO> searchByKeyword(String keyword) {
        log.info("[Service:LanguageService] searchByKeyword() called - keyword: {}", keyword);
        List<LanguageEntity> result = languageRepository.searchByKeyword(keyword);
        List<LanguageResponseDTO> responseDTOs = LanguageMapper.toResponseDTOList(result);
        log.info("[Service:LanguageService] searchByKeyword() succeeded - Found {} languages", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Long id) {
        log.info("[Service:LanguageService] softDeleteById() called - id: {}", id);

        int result = languageRepository.softDeleteById(id);
        if (result == 0) {
            throw new ApiException(LanguageErrors.LANGUAGE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:LanguageService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public LanguageResponseDTO createLanguage(LanguageRequestDTO requestDTO) {
        log.info("[Service:LanguageService] createLanguage() called - Creating structure for: {}", requestDTO.getName());

        if (requestDTO.getIsoCode() != null && !requestDTO.getIsoCode().trim().isEmpty()) {
            if (languageRepository.existsByIsoCode(requestDTO.getIsoCode().trim())) {
                throw new ApiException(LanguageErrors.DUPLICATE_LANGUAGE_CODE, "ISO code already exists", HttpStatus.CONFLICT);
            }
        }

        LanguageEntity entity = LanguageMapper.toEntity(requestDTO);
        LanguageEntity saved = languageRepository.save(entity);

        log.info("[Service:LanguageService] createLanguage() succeeded - Created with id: {}", saved.getId());
        return LanguageMapper.toResponseDTO(saved);
    }

    @Transactional
    public LanguageResponseDTO updateLanguage(Long id, LanguageRequestDTO requestDTO) {
        log.info("[Service:LanguageService] updateLanguage() called - id: {}", id);

        LanguageEntity existing = languageRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(LanguageErrors.LANGUAGE_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getIsoCode() != null && !requestDTO.getIsoCode().trim().equals(existing.getIsoCode())) {
            if (languageRepository.existsByIsoCodeAndIdNot(requestDTO.getIsoCode().trim(), id)) {
                throw new ApiException(LanguageErrors.DUPLICATE_LANGUAGE_CODE, "ISO code already exists", HttpStatus.CONFLICT);
            }
        }

        LanguageMapper.updateEntityFromDTO(existing, requestDTO);
        LanguageEntity updated = languageRepository.save(existing);

        log.info("[Service:LanguageService] updateLanguage() succeeded - id: {}", id);
        return LanguageMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Service:LanguageService] getStatistics() called");

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalLanguages", languageRepository.countAllNotDeleted());
        stats.put("activeLanguages", languageRepository.countByIsActiveTrue());
        stats.put("inactiveLanguages", languageRepository.countByIsActiveFalse());

        log.info("[Service:LanguageService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
