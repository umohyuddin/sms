package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.dtos.instituteLanguages.requestDto.InstituteLanguageCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteLanguages.responseDto.InstituteLanguageResponseDTO;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.model.InstituteLanguageEntity;
import com.smartsolutions.eschool.school.model.InstituteLanguageId;
import com.smartsolutions.eschool.school.model.LanguageEntity;
import com.smartsolutions.eschool.school.repository.InstituteLanguageRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.school.repository.LanguageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InstituteLanguageServiceImpl implements InstituteLanguageService {

    private final InstituteLanguageRepository instituteLanguageRepository;
    private final InstituteRepository instituteRepository;
    private final LanguageRepository languageRepository;

    public InstituteLanguageServiceImpl(InstituteLanguageRepository instituteLanguageRepository, InstituteRepository instituteRepository, LanguageRepository languageRepository) {
        this.instituteLanguageRepository = instituteLanguageRepository;
        this.instituteRepository = instituteRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public InstituteLanguageResponseDTO addLanguage(InstituteLanguageCreateRequestDTO requestDTO) {
        InstituteEntity institute = instituteRepository.findById(requestDTO.getInstituteId())
                .orElseThrow(() -> new ResourceNotFoundException("Institute not found with id: " + requestDTO.getInstituteId()));
        LanguageEntity language = languageRepository.findById(requestDTO.getLanguageId())
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + requestDTO.getLanguageId()));

        InstituteLanguageEntity entity = new InstituteLanguageEntity();
        entity.setId(new InstituteLanguageId(institute.getId(), language.getId()));
        entity.setInstitute(institute);
        entity.setLanguage(language);
        InstituteLanguageEntity saved = instituteLanguageRepository.save(entity);

        InstituteLanguageResponseDTO dto = new InstituteLanguageResponseDTO();
        dto.setInstituteId(saved.getInstitute().getId());
        dto.setLanguageId(saved.getLanguage().getId());
        dto.setLanguageName(saved.getLanguage().getName());
        return dto;
    }

    @Override
    public InstituteLanguageResponseDTO getById(Long instituteId, Long languageId) {
        InstituteLanguageEntity entity = instituteLanguageRepository.findByIdJpql(instituteId, languageId)
                .orElseThrow(() -> new ResourceNotFoundException("InstituteLanguage not found"));
        InstituteLanguageResponseDTO dto = new InstituteLanguageResponseDTO();
        dto.setInstituteId(entity.getInstitute().getId());
        dto.setLanguageId(entity.getLanguage().getId());
        dto.setLanguageName(entity.getLanguage().getName());
        return dto;
    }

    @Override
    public Page<InstituteLanguageResponseDTO> getByInstituteId(Long instituteId, Pageable pageable) {
        return instituteLanguageRepository.findByInstituteId(instituteId, pageable)
                .map(entity -> new InstituteLanguageResponseDTO(entity.getInstitute().getId(), entity.getLanguage().getId(), entity.getLanguage().getName()));
    }

    @Override
    public void delete(Long instituteId, Long languageId) {
        InstituteLanguageId id = new InstituteLanguageId(instituteId, languageId);
        if (!instituteLanguageRepository.existsById(id)) {
            throw new ResourceNotFoundException("InstituteLanguage not found");
        }
        instituteLanguageRepository.deleteById(id);
    }
}
