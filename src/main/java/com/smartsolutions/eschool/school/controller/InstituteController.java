package com.smartsolutions.eschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.school.dtos.InstituteDTO;
import com.smartsolutions.eschool.school.dtos.institute.request.InstituteRequestDTO;
import com.smartsolutions.eschool.school.dtos.institute.response.InstituteResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteFacade;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.util.MultiResourceSuccessResponseObject;
import com.smartsolutions.eschool.util.ResourceObject;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@RestController
@RequestMapping("/api/institute")
@Slf4j
public class InstituteController {

    private final InstituteFacade instituteFacade;

    public InstituteController(InstituteFacade instituteFacade) {
        this.instituteFacade = instituteFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteResponseDTO> getInstitute() {
        log.info("GET /api/school/institute called");
        InstituteResponseDTO responseDTO = instituteFacade.getInstitute();
        if (responseDTO == null) {
            log.info("No institute record found");
            return ResponseEntity.noContent().build(); // HTTP 204
        }
        log.info("GET /api/school/institute succeeded");
        return ResponseEntity.ok(responseDTO);
    }

    // -------------------------------------------------------------------------
    // UPDATE INSTITUTE
    // -------------------------------------------------------------------------
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteResponseDTO> updateInstitute(@RequestBody @Valid InstituteRequestDTO requestDTO) {
        log.info("PUT /api/school/institute called");
        InstituteResponseDTO responseDTO = instituteFacade.updateInstitute(requestDTO);
        log.info("PUT /api/school/institute succeeded");
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}

