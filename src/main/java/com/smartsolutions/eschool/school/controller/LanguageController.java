package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.languages.requestDto.LanguageCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.languages.requestDto.LanguageUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.languages.responseDto.LanguageResponseDTO;
import com.smartsolutions.eschool.school.facade.LanguageFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/languages")
@Slf4j
public class LanguageController {

    private final LanguageFacade languageFacade;

    public LanguageController(LanguageFacade languageFacade) {
        this.languageFacade = languageFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageResponseDTO> createLanguage(@Valid @RequestBody LanguageCreateRequestDTO requestDTO) {
        LanguageResponseDTO responseDTO = languageFacade.createLanguage(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<LanguageResponseDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(languageFacade.getAll(pageable));
    }

    @GetMapping(value = "/{languageId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageResponseDTO> getById(@PathVariable Long languageId) {
        return ResponseEntity.ok(languageFacade.getById(languageId));
    }

    @PutMapping(value = "/{languageId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageResponseDTO> updateLanguage(@PathVariable Long languageId, @Valid @RequestBody LanguageUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(languageFacade.updateLanguage(languageId, requestDTO));
    }

    @DeleteMapping("/{languageId}")
    public ResponseEntity<String> deleteLanguage(@PathVariable Long languageId) {
        languageFacade.deleteById(languageId);
        return ResponseEntity.ok("Language deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LanguageResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(languageFacade.searchByKeyword(keyword.trim()));
    }
}
