package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.instituteLanguages.requestDto.InstituteLanguageCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteLanguages.responseDto.InstituteLanguageResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteLanguageFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/institute/institute-languages")
@Slf4j
public class InstituteLanguageController {

    private final InstituteLanguageFacade instituteLanguageFacade;

    public InstituteLanguageController(InstituteLanguageFacade instituteLanguageFacade) {
        this.instituteLanguageFacade = instituteLanguageFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteLanguageResponseDTO> addLanguage(@Valid @RequestBody InstituteLanguageCreateRequestDTO requestDTO) {
        InstituteLanguageResponseDTO responseDTO = instituteLanguageFacade.addLanguage(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(value = "/institute/{instituteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteLanguageResponseDTO>> getByInstituteId(@PathVariable Long instituteId) {
        return ResponseEntity.ok(instituteLanguageFacade.getByInstituteId(instituteId));
    }

    @GetMapping(value = "/{instituteId}/{languageId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteLanguageResponseDTO> getById(@PathVariable Long instituteId, @PathVariable Long languageId) {
        return ResponseEntity.ok(instituteLanguageFacade.getById(instituteId, languageId));
    }

    @DeleteMapping(value = "/{instituteId}/{languageId}")
    public ResponseEntity<String> delete(@PathVariable Long instituteId, @PathVariable Long languageId) {
        instituteLanguageFacade.delete(instituteId, languageId);
        return ResponseEntity.ok("Institute language deleted successfully");
    }
}
