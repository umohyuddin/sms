package com.smartsolutions.eschool.employee.controller;

import com.smartsolutions.eschool.employee.dtos.SalaryStructure.request.SalaryStructureRequestDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructure.response.SalaryStructureResponseDTO;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.request.SalaryComponentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.response.SalaryComponentResponseDTO;
import com.smartsolutions.eschool.employee.facade.SalaryComponentFacade;
import com.smartsolutions.eschool.employee.facade.SalaryStructureFacade;
import com.smartsolutions.eschool.global.enums.ComponentType;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/salary-components")
@Slf4j
public class SalaryComponentController {

    private final SalaryComponentFacade salaryComponentFacade;

    public SalaryComponentController(SalaryComponentFacade salaryComponentFacade) {
        this.salaryComponentFacade = salaryComponentFacade;
    }

    // -------------------------
    // Get all active components
    // -------------------------
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryComponentResponseDTO>> getAllActiveComponents() {
        log.info("GET /api/institute/salary-components called");
        List<SalaryComponentResponseDTO> components = salaryComponentFacade.getAllActive();
        log.info("Returned {} active components", components.size());
        return ResponseEntity.ok(components);
    }

    // -------------------------
    // Get component by ID
    // -------------------------
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryComponentResponseDTO> getComponentById(@PathVariable Long id) {
        log.info("GET /api/institute/salary-components/{} called", id);
        SalaryComponentResponseDTO component = salaryComponentFacade.getById(id);
        log.info("Returning component with id={}", id);
        return ResponseEntity.ok(component);
    }

    // -------------------------
    // Search by name
    // -------------------------
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryComponentResponseDTO>> searchComponents(@RequestParam String keyword) {
        log.info("GET /api/institute/salary-components/search called with keyword={}", keyword);
        List<SalaryComponentResponseDTO> components = salaryComponentFacade.searchByName(keyword);
        log.info("Returned {} components matching keyword={}", components.size(), keyword);
        return ResponseEntity.ok(components);
    }

    // -------------------------
    // Filter by type (EARNING / DEDUCTION)
    // -------------------------
//    @GetMapping(value = "/type/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<SalaryComponentResponseDTO>> getComponentsByType(@PathVariable ComponentType type) {
//        log.info("GET /api/institute/salary-components/type/{} called", type);
//        List<SalaryComponentResponseDTO> components = salaryComponentFacade.getByType(type);
//        log.info("Returned {} components for type={}", components.size(), type);
//        return ResponseEntity.ok(components);
//    }

    // -------------------------
    // Create a new component
    // -------------------------
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryComponentResponseDTO> createComponent(@Valid @RequestBody SalaryComponentRequestDTO requestDTO) {
        log.info("POST /api/institute/salary-components called to create component: {}", requestDTO);
        SalaryComponentResponseDTO created = salaryComponentFacade.createComponent(requestDTO);
        log.info("Salary Component created with id={}", created.getId());
        return ResponseEntity.ok(created);
    }

    // -------------------------
    // Update existing component
    // -------------------------
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryComponentResponseDTO> updateComponent(@PathVariable Long id, @Valid @RequestBody SalaryComponentRequestDTO requestDTO) {
        log.info("PUT /api/institute/salary-components/{} called to update component: {}", id, requestDTO);
        SalaryComponentResponseDTO updated = salaryComponentFacade.updateComponent(id, requestDTO);
        log.info("Salary Component updated with id={}", updated.getId());
        return ResponseEntity.ok(updated);
    }

    // -------------------------
    // Soft delete component
    // -------------------------
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Map<String, String>> softDeleteComponent(@PathVariable Long id) {
//        log.info("DELETE /api/institute/salary-components/{} called", id);
//        salaryComponentFacade.softDelete(id);
//        log.info("Salary Component soft deleted with id={}", id);
//        return ResponseEntity.ok(Map.of("message", "Salary Component deleted successfully"));
//    }

    // -------------------------
    // Metrics / counts
    // -------------------------
    @GetMapping(value = "/count/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> countActiveComponents() {
        log.info("GET /api/institute/salary-components/count/active called");
        return ResponseEntity.ok(salaryComponentFacade.countActive());
    }

    @GetMapping(value = "/count/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> countInactiveComponents() {
        log.info("GET /api/institute/salary-components/count/inactive called");
        return ResponseEntity.ok(salaryComponentFacade.countInactive());
    }
}