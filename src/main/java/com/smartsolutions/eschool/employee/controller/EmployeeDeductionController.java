package com.smartsolutions.eschool.employee.controller;

import com.smartsolutions.eschool.employee.dtos.employeeDeduction.request.EmployeeDeductionRequestDTO;
import com.smartsolutions.eschool.employee.dtos.employeeDeduction.response.EmployeeDeductionResponseDTO;
import com.smartsolutions.eschool.employee.facade.EmployeeDeductionFacade;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/employees/deductions")
@Slf4j
public class EmployeeDeductionController {

    private final EmployeeDeductionFacade deductionFacade;

    public EmployeeDeductionController(EmployeeDeductionFacade deductionFacade) {
        this.deductionFacade = deductionFacade;
    }

    // -------------------------
    // Create a new deduction
    // -------------------------
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDeductionResponseDTO> createDeduction(@Valid @RequestBody EmployeeDeductionRequestDTO requestDTO) {
        log.info("POST /api/institute/employees/deductions called with {}", requestDTO);
        try {
            EmployeeDeductionResponseDTO response = deductionFacade.createDeduction(requestDTO);
            log.info("Deduction created successfully with id={}", response.getId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Failed to create deduction", e);
            return ResponseEntity.status(500).build();
        }
    }

    // -------------------------
    // Update an existing deduction
    // -------------------------
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDeductionResponseDTO> updateDeduction(@PathVariable Long id,
                                                                        @Valid @RequestBody EmployeeDeductionRequestDTO requestDTO) {
        log.info("PUT /api/institute/employees/deductions/{} called with {}", id, requestDTO);
        try {
            EmployeeDeductionResponseDTO response = deductionFacade.updateDeduction(id, requestDTO);
            log.info("Deduction updated successfully with id={}", id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Failed to update deduction with id={}", id, e);
            return ResponseEntity.status(500).build();
        }
    }

    // -------------------------
    // Get deduction by ID
    // -------------------------
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDeductionResponseDTO> getDeductionById(@PathVariable Long id) {
        log.info("GET /api/institute/employees/deductions/{} called", id);
        try {
            EmployeeDeductionResponseDTO response = deductionFacade.getDeductionById(id);
            log.info("Returning deduction with id={}", id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Failed to fetch deduction with id={}", id, e);
            return ResponseEntity.status(500).build();
        }
    }

    // -------------------------
    // Get all deductions
    // -------------------------
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeDeductionResponseDTO>> getAllDeductions() {
        log.info("GET /api/institute/employees/deductions called");
        try {
            List<EmployeeDeductionResponseDTO> deductions = deductionFacade.getAllDeductions();
            log.info("Returned {} deductions", deductions.size());
            return ResponseEntity.ok(deductions);
        } catch (Exception e) {
            log.error("Failed to fetch all deductions", e);
            return ResponseEntity.status(500).build();
        }
    }

    // -------------------------
    // Get deductions for a specific employee
    // -------------------------
    @GetMapping(value = "/employee/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeDeductionResponseDTO>> getDeductionsForEmployee(@PathVariable Long employeeId) {
        log.info("GET /api/institute/employees/deductions/employee/{} called", employeeId);
        try {
            List<EmployeeDeductionResponseDTO> deductions = deductionFacade.getDeductionsForEmployee(employeeId);
            log.info("Returned {} deductions for employeeId={}", deductions.size(), employeeId);
            return ResponseEntity.ok(deductions);
        } catch (Exception e) {
            log.error("Failed to fetch deductions for employeeId={}", employeeId, e);
            return ResponseEntity.status(500).build();
        }
    }

    // -------------------------
    // Soft delete deduction
    // -------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDeduction(@PathVariable Long id) {
        log.info("DELETE /api/institute/employees/deductions/{} called", id);
        try {
            deductionFacade.softDeleteDeduction(id);
            log.info("Deduction soft deleted successfully with id={}", id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Failed to delete deduction with id={}", id, e);
            return ResponseEntity.status(500).build();
        }
    }
}