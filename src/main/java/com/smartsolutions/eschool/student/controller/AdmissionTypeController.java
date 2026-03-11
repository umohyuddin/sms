package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.school.dtos.addmissionType.responseDto.AdmissionTypeResponseDTO;
import com.smartsolutions.eschool.student.dtos.admissionType.requestDto.AdmissionTypeCreateRequestDTO;
import com.smartsolutions.eschool.student.facade.AdmissionTypeFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admission/types")
@Slf4j
public class AdmissionTypeController {

    private final AdmissionTypeFacade admissionTypeFacade;

    public AdmissionTypeController(AdmissionTypeFacade admissionTypeFacade) {
        this.admissionTypeFacade = admissionTypeFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdmissionTypeResponseDTO>> getAll() {
        log.info("[Controller:AdmissionTypeController] getAll() called - Request to get all admission types");
        List<AdmissionTypeResponseDTO> resources = admissionTypeFacade.getAll();
        log.info("[Controller:AdmissionTypeController] getAll() succeeded - Found {} admission types",
                resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdmissionTypeResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:AdmissionTypeController] getById() called - Request to fetch admission type with id: {}",
                id);
        AdmissionTypeResponseDTO admissionType = admissionTypeFacade.getById(id);
        log.info("[Controller:AdmissionTypeController] getById() succeeded - Found admission type: {}", id);
        return ResponseEntity.ok(admissionType);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdmissionTypeResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:AdmissionTypeController] search() called - Request to search admission types with keyword: {}",
                keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<AdmissionTypeResponseDTO> responseDTOs = admissionTypeFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:AdmissionTypeController] search() succeeded - Found {} admission types matching keyword: {}",
                responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:AdmissionTypeController] delete() called - Request to delete admission type: {}", id);
        admissionTypeFacade.softDeleteById(id);
        log.info("[Controller:AdmissionTypeController] delete() succeeded - Admission type: {} deleted successfully",
                id);
        return ResponseEntity.ok(Map.of("message", "Admission type deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdmissionTypeResponseDTO> create(
            @Valid @RequestBody AdmissionTypeCreateRequestDTO requestDTO) {
        log.info("[Controller:AdmissionTypeController] create() called - Request to create admission type: {}",
                requestDTO.getName());
        AdmissionTypeResponseDTO responseDTO = admissionTypeFacade.createAdmissionType(requestDTO);
        log.info("[Controller:AdmissionTypeController] create() succeeded - Admission type created with id: {}",
                responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdmissionTypeResponseDTO> update(@PathVariable Long id,
            @Valid @RequestBody AdmissionTypeCreateRequestDTO requestDTO) {
        log.info("[Controller:AdmissionTypeController] update() called - Request to update admission type: {}", id);
        AdmissionTypeResponseDTO responseDTO = admissionTypeFacade.updateAdmissionType(id, requestDTO);
        log.info("[Controller:AdmissionTypeController] update() succeeded - Admission type: {} updated successfully",
                id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:AdmissionTypeController] getStatistics() called");
        Map<String, Long> statistics = admissionTypeFacade.getStatistics();
        log.info("[Controller:AdmissionTypeController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
