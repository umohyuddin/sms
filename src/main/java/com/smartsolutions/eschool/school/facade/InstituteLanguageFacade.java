package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteLanguages.requestDto.InstituteLanguageCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteLanguages.responseDto.InstituteLanguageResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteLanguageService;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class InstituteLanguageFacade {

    private final InstituteLanguageService instituteLanguageService;

    public InstituteLanguageFacade(InstituteLanguageService instituteLanguageService) {
        this.instituteLanguageService = instituteLanguageService;
    }

    public InstituteLanguageResponseDTO addLanguage(InstituteLanguageCreateRequestDTO requestDTO) {
        return instituteLanguageService.addLanguage(requestDTO);
    }

    public InstituteLanguageResponseDTO getById(Long instituteId, Long languageId) {
        return instituteLanguageService.getById(instituteId, languageId);
    }

    public Page<InstituteLanguageResponseDTO> getByInstituteId(Long instituteId, Pageable pageable) {
        return instituteLanguageService.getByInstituteId(instituteId, pageable);
    }

    public void delete(Long instituteId, Long languageId) {
        instituteLanguageService.delete(instituteId, languageId);
    }
}
