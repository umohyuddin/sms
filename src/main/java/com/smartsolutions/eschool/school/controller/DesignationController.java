package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.designations.request.DesignationRequestDTO;
import com.smartsolutions.eschool.school.dtos.designations.response.DesignationResponseDTO;
import com.smartsolutions.eschool.school.dtos.discountType.requestDto.DiscountTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.facade.DesignationFacade;
import com.smartsolutions.eschool.school.facade.DiscountTypeFacade;
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
@RequestMapping("/api/institute/designations")
@Slf4j
public class DesignationController {

    private final DesignationFacade designationFacade;

    public DesignationController(DesignationFacade designationFacade) {
        this.designationFacade = designationFacade;
    }

    /* =========================
       CREATE
       ========================= */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DesignationResponseDTO> createDesignation(@RequestBody @Valid DesignationRequestDTO requestDTO) {
        log.info("POST /api/institute/designations called for designation: {}", requestDTO.getDesignationName());
        DesignationResponseDTO responseDTO = designationFacade.createDesignation(requestDTO);
        log.info("POST /api/institute/designations succeeded, created designation with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    /* =========================
       GET ALL
       ========================= */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DesignationResponseDTO>> getAll() {
        log.info("GET /api/institute/designations called");
        List<DesignationResponseDTO> resources = designationFacade.getAll();
        log.info("GET /api/institute/designations succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DesignationResponseDTO>> getAllActive() {
        log.info("GET /api/institute/designations/active called");
        List<DesignationResponseDTO> resources = designationFacade.getAllActive();
        log.info("GET /api/institute/designations/active succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    /* =========================
       GET BY ID
       ========================= */
    @GetMapping(value = "/{designationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DesignationResponseDTO> getById(@PathVariable Long designationId) {
        log.info("GET /api/institute/designations/{} called", designationId);
        DesignationResponseDTO resource = designationFacade.getById(designationId);
        log.info("GET /api/institute/designations/{} succeeded", designationId);
        return ResponseEntity.ok().body(resource);
    }

    /* =========================
       SEARCH
       ========================= */
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DesignationResponseDTO>> getBySearch(@RequestParam(name = "keyword") String keyword) {
        log.info("GET /api/institute/designations/search called with keyword: {}", keyword);
        List<DesignationResponseDTO> resources = designationFacade.searchByKeyword(keyword);
        log.info("GET /api/institute/designations/search succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    /* =========================
       UPDATE
       ========================= */
    @PutMapping(value = "/{designationId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DesignationResponseDTO> updateDesignation(@PathVariable Long designationId,
                                                                   @RequestBody @Valid DesignationRequestDTO requestDTO) {
        log.info("PUT /api/institute/designations/{} called", designationId);
        DesignationResponseDTO updated = designationFacade.updateDesignation(designationId, requestDTO);
        log.info("PUT /api/institute/designations/{} succeeded", designationId);
        return ResponseEntity.ok(updated);
    }

    /* =========================
   GET BY DEPARTMENT
   ========================= */
    @GetMapping(value = "/by-department/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DesignationResponseDTO>> getByDepartmentId(@PathVariable Long departmentId) {
        log.info("GET /api/institute/designations/by-department/{} called", departmentId);
        List<DesignationResponseDTO> resources = designationFacade.getByDepartmentId(departmentId);
        log.info("GET /api/institute/designations/by-department/{} succeeded, returned {} resources", departmentId, resources.size());
        return ResponseEntity.ok(resources);
    }

}