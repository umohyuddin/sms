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
    public ResponseEntity<?> createDesignation(@RequestBody @Valid DesignationRequestDTO requestDTO) {
        log.info("Received request to create Designation");
        DesignationResponseDTO responseDTO = designationFacade.createDesignation(requestDTO);
        log.info("Designation created successfully with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    /* =========================
       GET ALL
       ========================= */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        log.info("GET /api/school/designations called");
        List<DesignationResponseDTO> resources = designationFacade.getAll();
        log.info("GET /api/school/designations succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllActive() {
        log.info("GET /api/school/designations/active called");
        List<DesignationResponseDTO> resources = designationFacade.getAllActive();
        log.info("GET /api/school/designations/active succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

//    @GetMapping(value = "/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> getAllInactive() {
//        log.info("GET /api/school/designations/inactive called");
//        List<DesignationResponseDTO> resources = designationFacade.getAllInactive();
//        log.info("GET /api/school/designations/inactive succeeded, returned {} resources", resources.size());
//        return ResponseEntity.ok().body(resources);
//    }

    /* =========================
       GET BY ID
       ========================= */
    @GetMapping(value = "/{designationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long designationId) {
        log.info("GET /api/school/designations by id called");
        DesignationResponseDTO resource = designationFacade.getById(designationId);
        log.info("GET /api/school/designations by id succeeded, returned resource id: {}", resource.getId());
        return ResponseEntity.ok().body(resource);
    }

    /* =========================
       SOFT DELETE
       ========================= */
//    @DeleteMapping("/{designationId}")
//    public ResponseEntity<?> softDeleteById(@PathVariable Long designationId) {
//        log.info("DELETE /api/school/designations by id called {}", designationId);
//        int result = designationFacade.softDeleteById(designationId);
//        if (result == 0) {
//            log.warn("Delete failed — Designation not found: {}", designationId);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body("Designation not found with id: " + designationId);
//        }
//        log.info("Designation deleted successfully: {}", designationId);
//        return ResponseEntity.ok("Designation deleted successfully");
//    }

    /* =========================
       SEARCH
       ========================= */
    @GetMapping(value = "/search/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBySearch(@PathVariable String keyword) {
        log.info("GET /api/school/designations/search by keyword called");
        List<DesignationResponseDTO> resources = designationFacade.searchByKeyword(keyword);
        log.info("GET /api/school/designations/search succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    /* =========================
       UPDATE
       ========================= */
    @PutMapping(value = "/{designationId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateDesignation(@PathVariable Long designationId,
                                               @RequestBody @Valid DesignationRequestDTO requestDTO) {
        log.info("Received request to update Designation with id: {}", designationId);
        DesignationResponseDTO updated = designationFacade.updateDesignation(designationId, requestDTO);

        if (updated == null) {
            log.warn("Designation not found for id: {}", designationId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Designation not found with id: " + designationId);
        }
        log.info("Designation updated successfully with id: {}", updated.getId());
        return ResponseEntity.ok(updated);
    }

    /* =========================
   GET BY DEPARTMENT
   ========================= */
    @GetMapping(value = "/by-department/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByDepartmentId(@PathVariable Long departmentId) {
        log.info("GET /api/institute/designations/by-department/{} called", departmentId);
        List<DesignationResponseDTO> resources = designationFacade.getByDepartmentId(departmentId);
        log.info("GET /api/institute/designations/by-department/{} succeeded, returned {} resources", departmentId, resources.size());
        return ResponseEntity.ok(resources);
    }

}