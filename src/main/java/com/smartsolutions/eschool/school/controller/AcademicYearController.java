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
        AcademicYearRequestDTO academicYearRequestDTO = academicYearFacade.createAcademicYear(requestDTO);
        log.info("Academic year created successfully with id: {}", academicYearRequestDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(academicYearRequestDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/school/academic called");
        List<AcademicYearResponseDTO> resources = academicYearFacade.getAll();
        log.info("GET /api/school/academic succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }
}
