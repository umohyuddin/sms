package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.languages.requestDto.LanguageCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.languages.requestDto.LanguageUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.languages.responseDto.LanguageResponseDTO;
import com.smartsolutions.eschool.school.service.LanguageService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class LanguageFacade {

    private final LanguageService languageService;

    public LanguageFacade(LanguageService languageService) {
        this.languageService = languageService;
    }

    public LanguageResponseDTO createLanguage(LanguageCreateRequestDTO requestDTO) {
        return languageService.createLanguage(requestDTO);
    }

    public List<LanguageResponseDTO> getAll() {
        return languageService.getAll();
    }

    public LanguageResponseDTO getById(Long id) {
        return languageService.getById(id);
    }

    public LanguageResponseDTO updateLanguage(Long id, LanguageUpdateRequestDTO requestDTO) {
        return languageService.updateLanguage(id, requestDTO);
    }

    public void deleteById(Long id) {
        languageService.deleteById(id);
    }

    public List<LanguageResponseDTO> searchByKeyword(String keyword) {
        return languageService.searchByKeyword(keyword);
    }
}
