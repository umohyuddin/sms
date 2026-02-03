package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteLanguages.requestDto.InstituteLanguageCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteLanguages.responseDto.InstituteLanguageResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteLanguageService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<InstituteLanguageResponseDTO> getByInstituteId(Long instituteId) {
        return instituteLanguageService.getByInstituteId(instituteId);
    }

    public void delete(Long instituteId, Long languageId) {
        instituteLanguageService.delete(instituteId, languageId);
    }
}
