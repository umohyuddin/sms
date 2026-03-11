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
        log.info(
                "[Controller:InstituteFinancialSettingsController] getByInstituteAndAcademicYear() called - institute: {}, year: {}",
                instituteId, academicYearId);
        FinancialSettingsResponseDTO responseDTO = facade.getByInstituteAndAcademicYear(instituteId, academicYearId);
        log.info("[Controller:InstituteFinancialSettingsController] getByInstituteAndAcademicYear() succeeded");
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FinancialSettingsResponseDTO> create(@Valid @RequestBody FinancialSettingsRequestDTO dto) {
        log.info("[Controller:InstituteFinancialSettingsController] create() called");
        FinancialSettingsResponseDTO responseDTO = facade.create(dto);
        log.info("[Controller:InstituteFinancialSettingsController] create() succeeded - ID: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FinancialSettingsResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody FinancialSettingsRequestDTO dto) {
        log.info("[Controller:InstituteFinancialSettingsController] update() called - ID: {}", id);
        FinancialSettingsResponseDTO responseDTO = facade.update(id, dto);
        log.info("[Controller:InstituteFinancialSettingsController] update() succeeded - ID: {}", id);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        log.info("[Controller:InstituteFinancialSettingsController] delete() called - ID: {}", id);
        facade.softDeleteById(id);
        log.info("[Controller:InstituteFinancialSettingsController] delete() succeeded - ID: {}", id);
        return ResponseEntity.ok("Financial settings deleted successfully");
    }
}
