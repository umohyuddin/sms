package com.smartsolutions.eschool.employee.controller;

import com.smartsolutions.eschool.employee.dtos.SalaryStructure.request.SalaryStructureRequestDTO;
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
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryStructureResponseDTO>> getAllActive() {
        log.info("GET /api/institute/salary-structures called");
        List<SalaryStructureResponseDTO> structures = salaryStructureFacade.getAllActive();
        log.info("Returned {} active salary structures", structures.size());
        return ResponseEntity.ok(structures);
    }

    // -------------------------
    // Get by ID
    // -------------------------
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryStructureResponseDTO> getById(@PathVariable Long id) {
        log.info("GET /api/institute/salary-structures/{} called", id);
        SalaryStructureResponseDTO structure = salaryStructureFacade.getById(id);
        log.info("Returning Salary Structure with id={}", structure.getId());
        return ResponseEntity.ok(structure);
    }

    // -------------------------
    // Create
    // -------------------------
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryStructureResponseDTO> createSalaryStructure(@Valid @RequestBody SalaryStructureRequestDTO requestDTO) {
        log.info("POST /api/institute/salary-structures called for EmployeeTypeId={}", requestDTO.getEmployeeTypeId());
        SalaryStructureResponseDTO created = salaryStructureFacade.createSalaryStructure(requestDTO);
        log.info("Salary Structure created successfully with id={}", created.getId());
        return ResponseEntity.ok(created);
    }

    // -------------------------
    // Update
    // -------------------------
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryStructureResponseDTO> updateSalaryStructure(@PathVariable Long id, @Valid @RequestBody SalaryStructureRequestDTO requestDTO) {
        log.info("PUT /api/institute/salary-structures/{} called", id);
        SalaryStructureResponseDTO updated = salaryStructureFacade.updateSalaryStructure(id, requestDTO);
        log.info("Salary Structure updated successfully with id={}", updated.getId());
        return ResponseEntity.ok(updated);
    }

    // -------------------------
    // Soft delete
    // -------------------------
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> softDelete(@PathVariable Long id) {
        log.info("DELETE /api/institute/salary-structures/{} called", id);
        salaryStructureFacade.softDelete(id);
        log.info("Salary Structure soft-deleted with id={}", id);
        return ResponseEntity.noContent().build();
    }

    // -------------------------
    // Get effective on a specific date
    // -------------------------
//    @GetMapping(value = "/effective", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<SalaryStructureResponseDTO>> getEffectiveOn(
//            @RequestParam("date") String dateStr) {
//        LocalDate date = LocalDate.parse(dateStr);
//        log.info("GET /api/institute/salary-structures/effective called with date={}", date);
//        List<SalaryStructureResponseDTO> structures = salaryStructureFacade.getEffectiveOn(date);
//        log.info("Returned {} salary structures effective on {}", structures.size(), date);
//        return ResponseEntity.ok(structures);
//    }

    // -------------------------
    // Get within a date range
    // -------------------------
//    @GetMapping(value = "/range", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<SalaryStructureResponseDTO>> getWithinDateRange(
//            @RequestParam("startDate") String startDateStr,
//            @RequestParam("endDate") String endDateStr) {
//        LocalDate startDate = LocalDate.parse(startDateStr);
//        LocalDate endDate = LocalDate.parse(endDateStr);
//        log.info("GET /api/institute/salary-structures/range called with {} - {}", startDate, endDate);
//        List<SalaryStructureResponseDTO> structures = salaryStructureFacade.getWithinDateRange(startDate, endDate);
//        log.info("Returned {} salary structures within date range", structures.size());
//        return ResponseEntity.ok(structures);
//    }


    @PutMapping("/{id}/close")
    public ResponseEntity<SalaryStructureResponseDTO> closeSalaryStructure(@PathVariable Long id) {
        return ResponseEntity.ok(salaryStructureFacade.closeSalaryStructure(id));
    }

    @GetMapping("/search")
    public List<SalaryStructureResponseDTO> searchSalaryStructures(@RequestParam(required = false) Long employeeTypeId, @RequestParam(required = false) String employeeTypeName, @RequestParam(required = false) BigDecimal minSalary, @RequestParam(required = false) BigDecimal maxSalary, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate, @RequestParam(required = false) Boolean isCurrent) {
        return salaryStructureFacade.searchSalaryStructures(employeeTypeId, employeeTypeName, minSalary, maxSalary, fromDate, toDate, isCurrent);
    }
}
