package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.lookups.dtos.curriculum.requestDto.CurriculumRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.curriculum.responseDto.CurriculumResponseDTO;
import com.smartsolutions.eschool.lookups.facade.CurriculumFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lookups/curricula")
@Slf4j
public class CurriculumController {

    private final CurriculumFacade curriculumFacade;

    public CurriculumController(CurriculumFacade curriculumFacade) {
        this.curriculumFacade = curriculumFacade;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurriculumResponseDTO> create(@Valid @RequestBody CurriculumRequestDTO dto) {
        log.info("POST /api/lookups/curricula called");
        return ResponseEntity.status(HttpStatus.CREATED).body(curriculumFacade.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CurriculumResponseDTO>> getAllActive() {
        log.info("GET /api/lookups/curricula called");
        return ResponseEntity.ok(curriculumFacade.getAllActive());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurriculumResponseDTO> getById(@PathVariable Long id) {
        log.info("GET /api/lookups/curricula/{} called", id);
        return ResponseEntity.ok(curriculumFacade.getById(id));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurriculumResponseDTO> update(@PathVariable Long id, @Valid @RequestBody CurriculumRequestDTO dto) {
        log.info("PUT /api/lookups/curricula/{} called", id);
        return ResponseEntity.ok(curriculumFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("DELETE /api/lookups/curricula/{} called", id);
        curriculumFacade.softDeleteById(id);
        return ResponseEntity.ok("Curriculum deleted successfully");
    }
}
