package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.lookups.dtos.educationLevel.requestDto.EducationLevelRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.educationLevel.responseDto.EducationLevelResponseDTO;
import com.smartsolutions.eschool.lookups.facade.EducationLevelFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lookups/education-levels")
@Slf4j
public class EducationLevelController {

    private final EducationLevelFacade educationLevelFacade;

    public EducationLevelController(EducationLevelFacade educationLevelFacade) {
        this.educationLevelFacade = educationLevelFacade;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationLevelResponseDTO> create(@Valid @RequestBody EducationLevelRequestDTO dto) {
        log.info("POST /api/lookups/education-levels called");
        return ResponseEntity.status(HttpStatus.CREATED).body(educationLevelFacade.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EducationLevelResponseDTO>> getAllActive() {
        log.info("GET /api/lookups/education-levels called");
        return ResponseEntity.ok(educationLevelFacade.getAllActive());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationLevelResponseDTO> getById(@PathVariable Long id) {
        log.info("GET /api/lookups/education-levels/{} called", id);
        return ResponseEntity.ok(educationLevelFacade.getById(id));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationLevelResponseDTO> update(@PathVariable Long id, @Valid @RequestBody EducationLevelRequestDTO dto) {
        log.info("PUT /api/lookups/education-levels/{} called", id);
        return ResponseEntity.ok(educationLevelFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("DELETE /api/lookups/education-levels/{} called", id);
        educationLevelFacade.softDeleteById(id);
        return ResponseEntity.ok("Education level deleted successfully");
    }
}
