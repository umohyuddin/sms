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

@RestController
@RequestMapping("/api/lookups/languages/v1")
@Slf4j
public class LanguageController {

    private final LanguageFacade languageFacade;

    public LanguageController(LanguageFacade languageFacade) {
        this.languageFacade = languageFacade;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageResponseDTO> create(@Valid @RequestBody LanguageRequestDTO dto) {
        log.info("POST /api/lookups/languages called");
        return ResponseEntity.status(HttpStatus.CREATED).body(languageFacade.createLanguage(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LanguageResponseDTO>> getAllActive() {
        log.info("GET /api/lookups/languages called");
        return ResponseEntity.ok(languageFacade.getAllActive());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageResponseDTO> getById(@PathVariable Long id) {
        log.info("GET /api/lookups/languages/{} called", id);
        return ResponseEntity.ok(languageFacade.getById(id));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageResponseDTO> update(@PathVariable Long id, @Valid @RequestBody LanguageRequestDTO dto) {
        log.info("PUT /api/lookups/languages/{} called", id);
        return ResponseEntity.ok(languageFacade.updateLanguage(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("DELETE /api/lookups/languages/{} called", id);
        languageFacade.softDeleteById(id);
        return ResponseEntity.ok("Language deleted successfully");
    }
}
