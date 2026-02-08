package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.schoolTypes.requestDto.SchoolTypeCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.schoolTypes.requestDto.SchoolTypeUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.schoolTypes.responseDto.SchoolTypeResponseDTO;
import com.smartsolutions.eschool.school.facade.SchoolTypeFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/school-types")
@Slf4j
public class SchoolTypeController {

    private final SchoolTypeFacade schoolTypeFacade;

    public SchoolTypeController(SchoolTypeFacade schoolTypeFacade) {
        this.schoolTypeFacade = schoolTypeFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolTypeResponseDTO> createSchoolType(@Valid @RequestBody SchoolTypeCreateRequestDTO requestDTO) {
        log.info("POST /api/institute/school-types called for: {}", requestDTO.getCode());
        SchoolTypeResponseDTO responseDTO = schoolTypeFacade.createSchoolType(requestDTO);
        log.info("POST /api/institute/school-types succeeded, created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SchoolTypeResponseDTO>> getAllSchoolTypes() {
        log.info("GET /api/institute/school-types called");
        List<SchoolTypeResponseDTO> result = schoolTypeFacade.getAll();
        log.info("GET /api/institute/school-types succeeded, returned {} resources", result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SchoolTypeResponseDTO>> getAllActiveSchoolTypes() {
        log.info("GET /api/institute/school-types/active called");
        List<SchoolTypeResponseDTO> result = schoolTypeFacade.getAllActive();
        log.info("GET /api/institute/school-types/active succeeded, returned {} resources", result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{schoolTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolTypeResponseDTO> getSchoolTypeById(@PathVariable Long schoolTypeId) {
        log.info("GET /api/institute/school-types/{} called", schoolTypeId);
        SchoolTypeResponseDTO result = schoolTypeFacade.getById(schoolTypeId);
        log.info("GET /api/institute/school-types/{} succeeded", schoolTypeId);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/{schoolTypeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolTypeResponseDTO> updateSchoolType(@PathVariable Long schoolTypeId, @Valid @RequestBody SchoolTypeUpdateRequestDTO requestDTO) {
        log.info("PUT /api/institute/school-types/{} called", schoolTypeId);
        SchoolTypeResponseDTO updated = schoolTypeFacade.updateSchoolType(schoolTypeId, requestDTO);
        log.info("PUT /api/institute/school-types/{} succeeded", schoolTypeId);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{schoolTypeId}")
    public ResponseEntity<String> deleteSchoolType(@PathVariable Long schoolTypeId) {
        log.info("DELETE /api/institute/school-types/{} called", schoolTypeId);
        schoolTypeFacade.deleteById(schoolTypeId);
        log.info("DELETE /api/institute/school-types/{} succeeded", schoolTypeId);
        return ResponseEntity.ok("SchoolType deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SchoolTypeResponseDTO>> searchSchoolTypes(@RequestParam(name = "keyword") String keyword) {
        log.info("GET /api/institute/school-types/search called with keyword: {}", keyword);
        List<SchoolTypeResponseDTO> results = schoolTypeFacade.searchByKeyword(keyword);
        log.info("GET /api/institute/school-types/search succeeded, returned {} resources", results.size());
        return ResponseEntity.ok(results);
    }

    @PutMapping(value = "/{schoolTypeId}/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolTypeResponseDTO> activate(@PathVariable Long schoolTypeId) {
        log.info("PUT /api/institute/school-types/{}/activate called", schoolTypeId);
        SchoolTypeResponseDTO response = schoolTypeFacade.activate(schoolTypeId);
        log.info("PUT /api/institute/school-types/{}/activate succeeded", schoolTypeId);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{schoolTypeId}/deactivate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolTypeResponseDTO> deactivate(@PathVariable Long schoolTypeId) {
        log.info("PUT /api/institute/school-types/{}/deactivate called", schoolTypeId);
        SchoolTypeResponseDTO response = schoolTypeFacade.deactivate(schoolTypeId);
        log.info("PUT /api/institute/school-types/{}/deactivate succeeded", schoolTypeId);
        return ResponseEntity.ok(response);
    }
}
