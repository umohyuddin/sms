package com.smartsolutions.eschool.employee.controller;

import com.smartsolutions.eschool.employee.dtos.SalaryStructure.request.SalaryStructureRequestDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructure.response.SalaryStructureDetailDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructure.response.SalaryStructureResponseDTO;
import com.smartsolutions.eschool.employee.facade.SalaryStructureFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/institute/salary-structures")
@Slf4j
public class SalaryStructureController {

    private final SalaryStructureFacade salaryStructureFacade;

    public SalaryStructureController(SalaryStructureFacade salaryStructureFacade) {
        this.salaryStructureFacade = salaryStructureFacade;
    }

    // -------------------------
    // Get all active salary structures
    // -------------------------
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryStructureResponseDTO>> getAll() {
        log.info("REST: Request to fetch all non-deleted SalaryStructures");
        List<SalaryStructureResponseDTO> result = salaryStructureFacade.getAllNonDeleted();
        log.info("REST: Returning {} SalaryStructures", result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/list/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryStructureDetailDTO>> getAllWithDetails() {
        log.info("REST: Request to fetch all SalaryStructures with details");
        List<SalaryStructureDetailDTO> result = salaryStructureFacade.getAllSalaryStructuresWithDetails();
        log.info("REST: Returning {} Detailed SalaryStructures", result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/by-employee-type/{employeeTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryStructureDetailDTO> getByEmployeeType(@PathVariable Long employeeTypeId) {
        log.info("REST: Request to fetch current SalaryStructure details for employeeTypeID: {}", employeeTypeId);
        SalaryStructureDetailDTO result = salaryStructureFacade.getSalaryStructureByEmployeeType(employeeTypeId);
        log.info("REST: Returning current SalaryStructure details for employeeTypeID: {}", employeeTypeId);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryStructureResponseDTO> getById(@PathVariable Long id) {
        log.info("REST: Request to fetch SalaryStructure by ID: {}", id);
        SalaryStructureResponseDTO result = salaryStructureFacade.getById(id);
        log.info("REST: Returning SalaryStructure with id={}", id);
        return ResponseEntity.ok(result);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryStructureResponseDTO> create(@Valid @RequestBody SalaryStructureRequestDTO requestDTO) {
        log.info("REST: Request to create SalaryStructure for employeeTypeID: {}", requestDTO.getEmployeeTypeId());
        SalaryStructureResponseDTO result = salaryStructureFacade.create(requestDTO);
        log.info("REST: SalaryStructure created successfully with id={}", result.getId());
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryStructureResponseDTO> update(@PathVariable Long id, @Valid @RequestBody SalaryStructureRequestDTO requestDTO) {
        log.info("REST: Request to update SalaryStructure ID: {}", id);
        SalaryStructureResponseDTO result = salaryStructureFacade.update(id, requestDTO);
        log.info("REST: SalaryStructure updated successfully with id={}", id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("REST: Request to delete SalaryStructure ID: {}", id);
        salaryStructureFacade.delete(id);
        log.info("REST: SalaryStructure deleted with id={}", id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/close", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryStructureResponseDTO> close(@PathVariable Long id) {
        log.info("REST: Request to close SalaryStructure ID: {}", id);
        SalaryStructureResponseDTO result = salaryStructureFacade.closeSalaryStructure(id);
        log.info("REST: SalaryStructure closed with id={}", id);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryStructureResponseDTO>> searchByKeyword(@RequestParam String keyword) {
        log.info("REST: Request to search SalaryStructures by keyword: '{}'", keyword);
        List<SalaryStructureResponseDTO> result = salaryStructureFacade.searchByKeyword(keyword);
        log.info("REST: Search completed, returning {} SalaryStructures", result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/search/complex", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryStructureResponseDTO>> searchComplex(
            @RequestParam(required = false) Long employeeTypeId,
            @RequestParam(required = false) String employeeTypeName,
            @RequestParam(required = false) BigDecimal minSalary,
            @RequestParam(required = false) BigDecimal maxSalary,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
            @RequestParam(required = false) Boolean isCurrent) {
        log.info("REST: Request for complex search for SalaryStructures");
        List<SalaryStructureResponseDTO> result = salaryStructureFacade.searchComplex(employeeTypeId, employeeTypeName, minSalary, maxSalary, fromDate, toDate, isCurrent);
        log.info("REST: Complex search completed, returning {} SalaryStructures", result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> getTotalCount() {
        log.info("REST: Request to fetch total count of SalaryStructures");
        return ResponseEntity.ok(salaryStructureFacade.getTotalCount());
    }
}

