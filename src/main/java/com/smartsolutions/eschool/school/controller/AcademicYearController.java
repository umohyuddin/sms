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
    public ResponseEntity<?> createAcademicYear(@RequestBody @Valid AcademicYearRequestDTO requestDTO) {
        log.info("Received request to create academic year");
        AcademicYearResponseDTO academicYearRequestDTO = academicYearFacade.createAcademicYear(requestDTO);
        log.info("Academic year created successfully with id");
        return ResponseEntity.status(HttpStatus.CREATED).body(academicYearRequestDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/school/academic called");
        List<AcademicYearResponseDTO> resources = academicYearFacade.getAll();
        log.info("GET /api/school/academic succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/current", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCurrentAcademicYear() throws Exception {
        log.info("GET /api/school/academic/current called");
        AcademicYearResponseDTO resources = academicYearFacade.getCurrentAcademicYear();
        log.info("GET /api/school/academic/current succeeded, returned {} resources", resources.getId());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchAcademicYears(@RequestParam(required = false) String keyword) {
        log.info("GET /api/school/academic/search called with keyword: {}", keyword);
        List<AcademicYearResponseDTO> resources = academicYearFacade.searchAcademicYears(keyword);
        log.info("Search completed, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AcademicYearResponseDTO> getAcademicYearById(@PathVariable Long id) {
        log.info("GET /api/school/academic/{} called", id);
        AcademicYearResponseDTO response = academicYearFacade.getAcademicYearById(id);
        log.info("GET by id succeeded for academic year id: {}", id);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AcademicYearResponseDTO> updateAcademicYear(
            @PathVariable Long id,
            @RequestBody @Valid AcademicYearRequestDTO requestDTO) {
        log.info("Received request to update academic year with id: {}", id);
        AcademicYearResponseDTO response = academicYearFacade.updateAcademicYear(id, requestDTO);
        log.info("Academic year updated successfully with id: {}", response.getId());
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{id}/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> activateAcademicYear(@PathVariable Long id) {
        log.info("Received request to activate academic year with id: {}", id);
        academicYearFacade.makeAcademicYearCurrent(id);
        log.info("Academic year activated successfully with id: {}", id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteAcademicYear(@PathVariable Long id) {
        log.info("Received request to delete Academic Year with id: {}", id);
        academicYearFacade.deleteAcademicYear(id);
        log.info("Academic Year deleted successfully with id: {}", id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/lock")
    public ResponseEntity<?> lockAcademicYear(
            @PathVariable Long id,
            @RequestBody AcademicYearRequestDTO request) {

        academicYearFacade.lockAcademicYear(id, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/archive")
    public ResponseEntity<Void> archiveAcademicYear(
            @PathVariable Long id,
            @RequestBody AcademicYearRequestDTO request) {

        academicYearFacade.archiveAcademicYear(id, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/close")
    public ResponseEntity<?> closeAcademicYear(
            @PathVariable Long id,
            @RequestBody AcademicYearRequestDTO request) {

        academicYearFacade.closeAcademicYear(id, request);

        return ResponseEntity.ok(Map.of(
                "message", "Academic Year closed successfully",
                "academicYearId", id
        ));
    }

    @PutMapping("/default")
    public ResponseEntity<?> createDefaultAcademicYear() {
        log.info("Request received to create default academic year if none exists");

        AcademicYearResponseDTO response = academicYearFacade.createDefaultAcademicYear();

        if (response == null) {
            log.info("Academic year already exists, no default created");
            return ResponseEntity.ok(Map.of("message", "Academic Year(s) already exist"));
        }

        log.info("Default academic year created successfully with id: {}", response.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
