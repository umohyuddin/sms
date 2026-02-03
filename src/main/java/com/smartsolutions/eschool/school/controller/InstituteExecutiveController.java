package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.instituteExecutives.requestDto.InstituteExecutiveCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteExecutives.requestDto.InstituteExecutiveUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteExecutives.responseDto.InstituteExecutiveResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteExecutiveFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/executives")
@Slf4j
public class InstituteExecutiveController {

    private final InstituteExecutiveFacade instituteExecutiveFacade;

    public InstituteExecutiveController(InstituteExecutiveFacade instituteExecutiveFacade) {
        this.instituteExecutiveFacade = instituteExecutiveFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteExecutiveResponseDTO> createExecutive(@Valid @RequestBody InstituteExecutiveCreateRequestDTO requestDTO) {
        InstituteExecutiveResponseDTO responseDTO = instituteExecutiveFacade.createExecutive(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteExecutiveResponseDTO>> getAll() {
        return ResponseEntity.ok(instituteExecutiveFacade.getAll());
    }

    @GetMapping(value = "/institute/{instituteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteExecutiveResponseDTO>> getByInstituteId(@PathVariable Long instituteId) {
        return ResponseEntity.ok(instituteExecutiveFacade.getByInstituteId(instituteId));
    }

    @GetMapping(value = "/{executiveId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteExecutiveResponseDTO> getById(@PathVariable Long executiveId) {
        return ResponseEntity.ok(instituteExecutiveFacade.getById(executiveId));
    }

    @PutMapping(value = "/{executiveId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteExecutiveResponseDTO> updateExecutive(@PathVariable Long executiveId, @Valid @RequestBody InstituteExecutiveUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(instituteExecutiveFacade.updateExecutive(executiveId, requestDTO));
    }

    @DeleteMapping("/{executiveId}")
    public ResponseEntity<String> deleteExecutive(@PathVariable Long executiveId) {
        instituteExecutiveFacade.deleteById(executiveId);
        return ResponseEntity.ok("Institute executive deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteExecutiveResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(instituteExecutiveFacade.searchByKeyword(keyword.trim()));
    }
}
