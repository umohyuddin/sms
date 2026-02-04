package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.language.requestDto.LanguageRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.language.responseDto.LanguageResponseDTO;
import com.smartsolutions.eschool.lookups.service.LanguageService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LanguageFacade {
    private final LanguageService languageService;

    public LanguageFacade(LanguageService languageService) {
        this.languageService = languageService;
    }

    public LanguageResponseDTO createLanguage(@Valid LanguageRequestDTO dto) {
        return languageService.createLanguage(dto);
    }

    public List<LanguageResponseDTO> getAllActive() {
        return languageService.getAllActive();
    }

    public LanguageResponseDTO getById(Long id) {
        return languageService.getById(id);
    }

    public LanguageResponseDTO updateLanguage(Long id, @Valid LanguageRequestDTO dto) {
        return languageService.updateLanguage(id, dto);
    }

    public int softDeleteById(Long id) {
        return languageService.softDeleteById(id);
    }
}
