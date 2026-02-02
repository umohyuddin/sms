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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        log.info("Received request to create SchoolType");
        SchoolTypeResponseDTO responseDTO = schoolTypeFacade.createSchoolType(requestDTO);
        log.info("SchoolType created successfully with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<SchoolTypeResponseDTO>> getAllSchoolTypes(Pageable pageable) {
        log.info("GET /api/institute/school-types called");
        Page<SchoolTypeResponseDTO> schoolTypes = schoolTypeFacade.getAll(pageable);
        log.info("Returned {} school types", schoolTypes.getTotalElements());
        return ResponseEntity.ok(schoolTypes);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SchoolTypeResponseDTO>> getAllActiveSchoolTypes() {
        log.info("GET /api/institute/school-types/active called");
        List<SchoolTypeResponseDTO> schoolTypes = schoolTypeFacade.getAllActive();
        log.info("Returned {} active school types", schoolTypes.size());
        return ResponseEntity.ok(schoolTypes);
    }

    @GetMapping(value = "/{schoolTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolTypeResponseDTO> getSchoolTypeById(@PathVariable Long schoolTypeId) {
        log.info("GET /api/institute/school-types/{} called", schoolTypeId);
        SchoolTypeResponseDTO schoolType = schoolTypeFacade.getById(schoolTypeId);
        return ResponseEntity.ok(schoolType);
    }

    @PutMapping(value = "/{schoolTypeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolTypeResponseDTO> updateSchoolType(@PathVariable Long schoolTypeId, @Valid @RequestBody SchoolTypeUpdateRequestDTO requestDTO) {
        log.info("Received request to update SchoolType with id: {}", schoolTypeId);
        SchoolTypeResponseDTO updated = schoolTypeFacade.updateSchoolType(schoolTypeId, requestDTO);
        log.info("SchoolType updated successfully with id: {}", updated.getId());
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{schoolTypeId}")
    public ResponseEntity<String> deleteSchoolType(@PathVariable Long schoolTypeId) {
        log.info("DELETE /api/institute/school-types/{} called", schoolTypeId);
        schoolTypeFacade.deleteById(schoolTypeId);
        log.info("SchoolType deleted successfully with id: {}", schoolTypeId);
        return ResponseEntity.ok("SchoolType deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SchoolTypeResponseDTO>> searchSchoolTypes(@RequestParam(name = "keyword") String keyword) {
        log.info("Searching SchoolTypes with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<SchoolTypeResponseDTO> results = schoolTypeFacade.searchByKeyword(keyword.trim());
        log.info("Found {} school types matching keyword '{}'", results.size(), keyword);
        return ResponseEntity.ok(results);
    }

    @PutMapping(value = "/{schoolTypeId}/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolTypeResponseDTO> activate(@PathVariable Long schoolTypeId) {
        SchoolTypeResponseDTO response = schoolTypeFacade.activate(schoolTypeId);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{schoolTypeId}/deactivate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolTypeResponseDTO> deactivate(@PathVariable Long schoolTypeId) {
        SchoolTypeResponseDTO response = schoolTypeFacade.deactivate(schoolTypeId);
        return ResponseEntity.ok(response);
    }
}
