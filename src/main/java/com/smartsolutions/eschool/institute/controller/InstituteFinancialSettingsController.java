package com.smartsolutions.eschool.institute.controller;

import com.smartsolutions.eschool.institute.dtos.financialSettings.requestDto.FinancialSettingsRequestDTO;
import com.smartsolutions.eschool.institute.dtos.financialSettings.responseDto.FinancialSettingsResponseDTO;
import com.smartsolutions.eschool.institute.facade.InstituteFinancialSettingsFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/institute/financial-settings")
@Slf4j
public class InstituteFinancialSettingsController {

    private final InstituteFinancialSettingsFacade facade;

    public InstituteFinancialSettingsController(InstituteFinancialSettingsFacade facade) {
        this.facade = facade;
    }

    @GetMapping(value = "/{instituteId}/{academicYearId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FinancialSettingsResponseDTO> getByInstituteAndAcademicYear(
            @PathVariable Long instituteId,
            @PathVariable Long academicYearId) {
        log.info("GET /api/institute/financial-settings/{}/{} called", instituteId, academicYearId);
        return ResponseEntity.ok(facade.getByInstituteAndAcademicYear(instituteId, academicYearId));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FinancialSettingsResponseDTO> create(@Valid @RequestBody FinancialSettingsRequestDTO dto) {
        log.info("POST /api/institute/financial-settings called");
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.create(dto));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FinancialSettingsResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody FinancialSettingsRequestDTO dto) {
        log.info("PUT /api/institute/financial-settings/{} called", id);
        return ResponseEntity.ok(facade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("DELETE /api/institute/financial-settings/{} called", id);
        facade.softDeleteById(id);
        return ResponseEntity.ok("Financial settings deleted successfully");
    }
}
