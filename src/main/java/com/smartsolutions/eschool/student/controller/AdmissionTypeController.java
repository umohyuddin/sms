package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.school.dtos.addmissionType.responseDto.AdmissionTypeResponseDTO;
import com.smartsolutions.eschool.student.facade.AdmissionTypeFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/admission/types")
@Slf4j
public class AdmissionTypeController {
private final AdmissionTypeFacade admissionTypeFacade;

    public AdmissionTypeController(AdmissionTypeFacade admissionTypeFacade) {
        this.admissionTypeFacade = admissionTypeFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/admission/types called");
        List<AdmissionTypeResponseDTO> resources = admissionTypeFacade.getAll();
        log.info("GET /api/admission/types succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

}
