package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.lookups.dtos.language.requestDto.LanguageRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.language.responseDto.LanguageResponseDTO;
import com.smartsolutions.eschool.lookups.model.LanguageEntity;
import com.smartsolutions.eschool.lookups.repository.LanguageRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Transactional
    public LanguageResponseDTO createLanguage(@Valid LanguageRequestDTO requestDTO) {
        log.info("Creating new Language: {}", requestDTO.getName());
        try {
            LanguageEntity entity = MapperUtil.mapObject(requestDTO, LanguageEntity.class);
            languageRepository.save(entity);
            return MapperUtil.mapObject(entity, LanguageResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating Language", dae);
            throw new CustomServiceException("Failed to create Language due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating Language", e);
            throw new CustomServiceException("Failed to create Language");
        }
    }

    public List<LanguageResponseDTO> getAllActive() {
        try {
            log.info("Fetching active Languages");
            List<LanguageEntity> result = languageRepository.findAllActive();
            return MapperUtil.mapList(result, LanguageResponseDTO.class);
        } catch (Exception e) {
            log.error("Error fetching active languages", e);
            throw new CustomServiceException("Failed to fetch active Languages", e);
        }
    }

    public LanguageResponseDTO getById(Long id) {
        log.info("Fetching Language with id={}", id);
        LanguageEntity entity = languageRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id=" + id));
        return MapperUtil.mapObject(entity, LanguageResponseDTO.class);
    }

    @Transactional
    public LanguageResponseDTO updateLanguage(Long id, @Valid LanguageRequestDTO requestDTO) {
        log.info("Updating Language id={}", id);
        LanguageEntity entity = languageRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id=" + id));
        
        entity.setName(requestDTO.getName());
        entity.setIsoCode(requestDTO.getIsoCode());
        entity.setIsActive(requestDTO.getIsActive());
        
        languageRepository.save(entity);
        return MapperUtil.mapObject(entity, LanguageResponseDTO.class);
    }

    @Transactional
    public int softDeleteById(Long id) {
        log.info("Soft delete request for Language id={}", id);
        return languageRepository.softDeleteById(id);
    }
}
