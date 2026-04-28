package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.lookups.dtos.language.requestDto.LanguageRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.language.responseDto.LanguageResponseDTO;
import com.smartsolutions.eschool.lookups.facade.LanguageFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lookups/languages/v1")
@Slf4j
public class LanguageController {

    private final LanguageFacade languageFacade;

    public LanguageController(LanguageFacade languageFacade) {
        this.languageFacade = languageFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LanguageResponseDTO>> getAll() {
        log.info("[Controller:LanguageController] getAll() called - Request to get all languages");
        List<LanguageResponseDTO> resources = languageFacade.getAll();
        log.info("[Controller:LanguageController] getAll() succeeded - Found {} languages", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LanguageResponseDTO>> getAllActive() {
        log.info("[Controller:LanguageController] getAllActive() called - Request to get all active languages");
        List<LanguageResponseDTO> resources = languageFacade.getAllActive();
        log.info("[Controller:LanguageController] getAllActive() succeeded - Found {} active languages", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:LanguageController] getById() called - Request to fetch language with id: {}", id);
        LanguageResponseDTO language = languageFacade.getById(id);
        log.info("[Controller:LanguageController] getById() succeeded - Found language: {}", id);
        return ResponseEntity.ok(language);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LanguageResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:LanguageController] search() called - Request to search languages with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<LanguageResponseDTO> responseDTOs = languageFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:LanguageController] search() succeeded - Found {} languages matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:LanguageController] delete() called - Request to delete language: {}", id);
        languageFacade.softDeleteById(id);
        log.info("[Controller:LanguageController] delete() succeeded - Language: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Language deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageResponseDTO> create(@Valid @RequestBody LanguageRequestDTO requestDTO) {
        log.info("[Controller:LanguageController] create() called - Request to create language: {}", requestDTO.getName());
        LanguageResponseDTO responseDTO = languageFacade.createLanguage(requestDTO);
        log.info("[Controller:LanguageController] create() succeeded - Language created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageResponseDTO> update(@PathVariable Long id, @Valid @RequestBody LanguageRequestDTO requestDTO) {
        log.info("[Controller:LanguageController] update() called - Request to update language: {}", id);
        LanguageResponseDTO responseDTO = languageFacade.updateLanguage(id, requestDTO);
        log.info("[Controller:LanguageController] update() succeeded - Language: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:LanguageController] getStatistics() called");
        Map<String, Long> statistics = languageFacade.getStatistics();
        log.info("[Controller:LanguageController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
