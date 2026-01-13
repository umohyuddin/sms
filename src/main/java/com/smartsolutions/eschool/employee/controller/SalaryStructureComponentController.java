package com.smartsolutions.eschool.employee.controller;

import com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.request.SalaryStructureComponentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.response.SalaryStructureComponentResponseDTO;
import com.smartsolutions.eschool.employee.facade.SalaryStructureComponentFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/institute/salary-structure/components")
@Slf4j
public class SalaryStructureComponentController {

    private final SalaryStructureComponentFacade componentFacade;

    public SalaryStructureComponentController(SalaryStructureComponentFacade componentFacade) {
        this.componentFacade = componentFacade;
    }

    // -------------------------
    // Create a new component
    // -------------------------
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createComponent(@Valid @RequestBody SalaryStructureComponentRequestDTO requestDTO) {
        log.info("POST /components called with data: {}", requestDTO);
        List<SalaryStructureComponentResponseDTO> created = componentFacade.createComponent(requestDTO);
        log.info("Component created");
        return ResponseEntity.ok(created);
    }

    // -------------------------
    // Get component by ID
    // -------------------------
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryStructureComponentResponseDTO> getComponentById(@PathVariable Long id) {
        log.info("GET /components/{} called", id);
        SalaryStructureComponentResponseDTO component = componentFacade.getComponentById(id);
        return ResponseEntity.ok(component);
    }

    // -------------------------
    // Get all active components
    // -------------------------
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryStructureComponentResponseDTO>> getAllActiveComponents() {
        log.info("GET /components called");
        List<SalaryStructureComponentResponseDTO> components = componentFacade.getAllActiveComponents();
        log.info("Returned {} components", components.size());
        return ResponseEntity.ok(components);
    }

    // -------------------------
    // Get components by salary structure
    // -------------------------
    @GetMapping(value = "/salary-structure/{salaryStructureId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryStructureComponentResponseDTO>> getComponentsBySalaryStructure(@PathVariable Long salaryStructureId) {
        log.info("GET /components/salary-structure/{} called", salaryStructureId);
        List<SalaryStructureComponentResponseDTO> components = componentFacade.getComponentsBySalaryStructure(salaryStructureId);
        log.info("Returned {} components for salaryStructureId={}", components.size(), salaryStructureId);
        return ResponseEntity.ok(components);
    }

    // -------------------------
    // Search components by name
    // -------------------------
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryStructureComponentResponseDTO>> searchComponents(@RequestParam Long salaryStructureId, @RequestParam String keyword) {
        log.info("GET /components/search called for salaryStructureId={} with keyword={}", salaryStructureId, keyword);
        List<SalaryStructureComponentResponseDTO> components = componentFacade.searchComponents(salaryStructureId, keyword);
        log.info("Returned {} components matching keyword={}", components.size(), keyword);
        return ResponseEntity.ok(components);
    }

    // -------------------------
    // Update component
    // -------------------------
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryStructureComponentResponseDTO> updateComponent(@PathVariable Long id, @Valid @RequestBody SalaryStructureComponentRequestDTO requestDTO) {
        log.info("PUT /components/{} called with data: {}", id, requestDTO);
        SalaryStructureComponentResponseDTO updated = componentFacade.updateComponent(id, requestDTO);
        log.info("Component updated with id={}", updated.getId());
        return ResponseEntity.ok(updated);
    }

    // -------------------------
    // Soft delete component
    // -------------------------
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> softDeleteComponent(@PathVariable Long id) {
        log.info("DELETE /components/{} called", id);
        componentFacade.softDeleteComponent(id);
        log.info("Component soft deleted with id={}", id);
        return ResponseEntity.ok(Map.of("message", "Component soft deleted successfully"));
    }

    // -------------------------
    // Count active components by salary structure
    // -------------------------
    @GetMapping(value = "/count/{salaryStructureId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> countActiveComponents(@PathVariable Long salaryStructureId) {
        log.info("GET /components/count/{} called", salaryStructureId);
        Long count = componentFacade.countActiveComponents(salaryStructureId);
        return ResponseEntity.ok(Map.of("count", count));
    }

    @PutMapping("/employee-type/{employeeTypeId}")
    public ResponseEntity<List<SalaryStructureComponentResponseDTO>> updateComponentsByEmployeeType(@PathVariable Long employeeTypeId, @Valid @RequestBody SalaryStructureComponentRequestDTO requestDTO) {
        List<SalaryStructureComponentResponseDTO> response = componentFacade.updateComponentsByEmployeeType(employeeTypeId, requestDTO);
        return ResponseEntity.ok(response);
    }
}