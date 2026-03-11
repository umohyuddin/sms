package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.language.requestDto.LanguageRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.language.responseDto.LanguageResponseDTO;
import com.smartsolutions.eschool.lookups.service.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class LanguageFacade {
    private final LanguageService languageService;

    public LanguageFacade(LanguageService languageService) {
        this.languageService = languageService;
    }

    public List<LanguageResponseDTO> getAll() {
        log.info("[Facade:LanguageFacade] getAll() called");
        return languageService.getAll();
    }

    public List<LanguageResponseDTO> getAllActive() {
        log.info("[Facade:LanguageFacade] getAllActive() called");
        return languageService.getAllActive();
    }

    public LanguageResponseDTO getById(Long id) {
        log.info("[Facade:LanguageFacade] getById() called - id: {}", id);
        return languageService.getById(id);
    }

    public List<LanguageResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:LanguageFacade] searchByKeyword() called - keyword: {}", keyword);
        return languageService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:LanguageFacade] softDeleteById() called - id: {}", id);
        languageService.softDeleteById(id);
    }

    public LanguageResponseDTO createLanguage(LanguageRequestDTO dto) {
        log.info("[Facade:LanguageFacade] createLanguage() called");
        return languageService.createLanguage(dto);
    }

    public LanguageResponseDTO updateLanguage(Long id, LanguageRequestDTO dto) {
        log.info("[Facade:LanguageFacade] updateLanguage() called - id: {}", id);
        return languageService.updateLanguage(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:LanguageFacade] getStatistics() called");
        return languageService.getStatistics();
    }
}
