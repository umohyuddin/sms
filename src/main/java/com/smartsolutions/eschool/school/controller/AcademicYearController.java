package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.academicYear.requestDto.AcademicYearRequestDTO;
import com.smartsolutions.eschool.school.dtos.academicYear.responseDto.AcademicYearResponseDTO;
import com.smartsolutions.eschool.school.facade.AcademicYearFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Transactional
@RestController
@RequestMapping("/api/school/academic")
@Slf4j
public class AcademicYearController {
    private final AcademicYearFacade academicYearFacade;

    public AcademicYearController(AcademicYearFacade academicYearFacade) {
        this.academicYearFacade = academicYearFacade;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AcademicYearResponseDTO> createAcademicYear(
            @RequestBody @Valid AcademicYearRequestDTO requestDTO) {
        log.info("POST /api/school/academic called for year: {}", requestDTO.getName());
        AcademicYearResponseDTO result = academicYearFacade.createAcademicYear(requestDTO);
        log.info("POST /api/school/academic succeeded, created academic year with id: {}", result.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AcademicYearResponseDTO>> getAll() throws Exception {
        log.info("GET /api/school/academic called");
        List<AcademicYearResponseDTO> resources = academicYearFacade.getAll();
        log.info("GET /api/school/academic succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/current", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AcademicYearResponseDTO> getCurrentAcademicYear() throws Exception {
        log.info("GET /api/school/academic/current called");
        AcademicYearResponseDTO resources = academicYearFacade.getCurrentAcademicYear();
        log.info("GET /api/school/academic/current succeeded, returned academic year id: {}", resources.getId());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AcademicYearResponseDTO>> searchAcademicYears(
            @RequestParam(name = "keyword", required = false) String keyword) {
        log.info("GET /api/school/academic/search called with keyword: {}", keyword);
        List<AcademicYearResponseDTO> resources = academicYearFacade.searchAcademicYears(keyword);
        log.info("GET /api/school/academic/search succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AcademicYearResponseDTO> getAcademicYearById(@PathVariable("id") Long id) {
        log.info("GET /api/school/academic/{} called", id);
        AcademicYearResponseDTO response = academicYearFacade.getAcademicYearById(id);
        log.info("GET /api/school/academic/{} succeeded", id);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AcademicYearResponseDTO> updateAcademicYear(
            @PathVariable("id") Long id,
            @RequestBody @Valid AcademicYearRequestDTO requestDTO) {
        log.info("PUT /api/school/academic/{} called", id);
        AcademicYearResponseDTO response = academicYearFacade.updateAcademicYear(id, requestDTO);
        log.info("PUT /api/school/academic/{} succeeded", id);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{id}/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> activateAcademicYear(@PathVariable("id") Long id) {
        log.info("PUT /api/school/academic/{}/activate called", id);
        academicYearFacade.makeAcademicYearCurrent(id);
        log.info("PUT /api/school/academic/{}/activate succeeded", id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteAcademicYear(@PathVariable("id") Long id) {
        log.info("DELETE /api/school/academic/{} called", id);
        academicYearFacade.deleteAcademicYear(id);
        log.info("DELETE /api/school/academic/{} succeeded", id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/lock")
    public ResponseEntity<Void> lockAcademicYear(
            @PathVariable("id") Long id,
            @RequestBody AcademicYearRequestDTO request) {
        log.info("PUT /api/school/academic/{}/lock called", id);
        academicYearFacade.lockAcademicYear(id, request);
        log.info("PUT /api/school/academic/{}/lock succeeded", id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/archive")
    public ResponseEntity<Void> archiveAcademicYear(
            @PathVariable("id") Long id,
            @RequestBody AcademicYearRequestDTO request) {
        log.info("PUT /api/school/academic/{}/archive called", id);
        academicYearFacade.archiveAcademicYear(id, request);
        log.info("PUT /api/school/academic/{}/archive succeeded", id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/close")
    public ResponseEntity<?> closeAcademicYear(
            @PathVariable("id") Long id,
            @RequestBody AcademicYearRequestDTO request) {
        log.info("PUT /api/school/academic/{}/close called", id);
        academicYearFacade.closeAcademicYear(id, request);
        log.info("PUT /api/school/academic/{}/close succeeded", id);
        return ResponseEntity.ok(Map.of(
                "message", "Academic Year closed successfully",
                "academicYearId", id));
    }

    @PutMapping("/default")
    public ResponseEntity<?> createDefaultAcademicYear() {
        log.info("PUT /api/school/academic/default called");
        AcademicYearResponseDTO response = academicYearFacade.createDefaultAcademicYear();
        if (response == null) {
            log.info("PUT /api/school/academic/default: Academic year already exists, no default created");
            return ResponseEntity.ok(Map.of("message", "Academic Year(s) already exist"));
        }
        log.info("PUT /api/school/academic/default succeeded, default year created with id: {}", response.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
