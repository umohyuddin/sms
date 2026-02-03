package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.languages.requestDto.LanguageCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.languages.requestDto.LanguageUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.languages.responseDto.LanguageResponseDTO;
import com.smartsolutions.eschool.school.model.LanguageEntity;
import com.smartsolutions.eschool.school.repository.LanguageRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public LanguageResponseDTO createLanguage(LanguageCreateRequestDTO requestDTO) {
        try {
            LanguageEntity entity = MapperUtil.mapObject(requestDTO, LanguageEntity.class);
            entity.setId(null);
            LanguageEntity saved = languageRepository.save(entity);
            return MapperUtil.mapObject(saved, LanguageResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating Language", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating Language", ex);
            throw ex;
        }
    }

    @Override
    public List<LanguageResponseDTO> getAll() {
        try {
            List<LanguageEntity> result = languageRepository.findAllJpql();
            return MapperUtil.mapList(result, LanguageResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Languages", dae);
        } catch (MappingException me) {
            log.error("Error mapping LanguageEntity to LanguageResponseDTO", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Languages", e);
        }
        return List.of();
    }

    @Override
    public LanguageResponseDTO getById(Long id) {
        LanguageEntity entity = languageRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));
        return MapperUtil.mapObject(entity, LanguageResponseDTO.class);
    }

    @Override
    public LanguageResponseDTO updateLanguage(Long id, LanguageUpdateRequestDTO requestDTO) {
        LanguageEntity existing = languageRepository.findByIdJpql(id)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));

        if (requestDTO.getIsoCode() != null) {
            existing.setIsoCode(requestDTO.getIsoCode());
        }
        if (requestDTO.getName() != null && !requestDTO.getName().isBlank()) {
            existing.setName(requestDTO.getName());
        }

        LanguageEntity updated = languageRepository.save(existing);
        return MapperUtil.mapObject(updated, LanguageResponseDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if (languageRepository.findByIdJpql(id).isEmpty()) {
            throw new ResourceNotFoundException("Language not found with id: " + id);
        }
        languageRepository.deleteById(id);
    }

    @Override
    public List<LanguageResponseDTO> searchByKeyword(String keyword) {
        List<LanguageEntity> result = languageRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return MapperUtil.mapList(result, LanguageResponseDTO.class);
    }
}
