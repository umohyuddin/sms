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
    public ResponseEntity<List<SalaryStructureComponentResponseDTO>> create(@Valid @RequestBody SalaryStructureComponentRequestDTO requestDTO) {
        log.info("REST: Request to create SalaryStructureComponents for salaryStructureId: {}", requestDTO.getSalaryStructureId());
        List<SalaryStructureComponentResponseDTO> result = componentFacade.create(requestDTO);
        log.info("REST: Successfully created {} components", result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryStructureComponentResponseDTO> getById(@PathVariable Long id) {
        log.info("REST: Request to fetch SalaryStructureComponent by ID: {}", id);
        SalaryStructureComponentResponseDTO result = componentFacade.getById(id);
        log.info("REST: Returning SalaryStructureComponent: id={}", id);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryStructureComponentResponseDTO>> getAll() {
        log.info("REST: Request to fetch all non-deleted SalaryStructureComponents");
        List<SalaryStructureComponentResponseDTO> result = componentFacade.getAllNonDeleted();
        log.info("REST: Returning {} SalaryStructureComponents", result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/salary-structure/{salaryStructureId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryStructureComponentResponseDTO>> getBySalaryStructure(@PathVariable Long salaryStructureId) {
        log.info("REST: Request to fetch components for salaryStructureId: {}", salaryStructureId);
        List<SalaryStructureComponentResponseDTO> result = componentFacade.getBySalaryStructure(salaryStructureId);
        log.info("REST: Returning {} components for salaryStructureId={}", result.size(), salaryStructureId);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryStructureComponentResponseDTO>> searchByKeyword(@RequestParam Long salaryStructureId, @RequestParam String keyword) {
        log.info("REST: Request to search components in salaryStructureId: {} with keyword: '{}'", salaryStructureId, keyword);
        List<SalaryStructureComponentResponseDTO> result = componentFacade.searchByKeyword(salaryStructureId, keyword);
        log.info("REST: Search completed, returning {} components", result.size());
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("REST: Request to delete SalaryStructureComponent ID: {}", id);
        componentFacade.delete(id);
        log.info("REST: SalaryStructureComponent deleted with id={}", id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/count/{salaryStructureId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> countBySalaryStructureId(@PathVariable Long salaryStructureId) {
        log.info("REST: Request to count components for salaryStructureId: {}", salaryStructureId);
        return ResponseEntity.ok(componentFacade.countBySalaryStructureId(salaryStructureId));
    }

    @PutMapping("/employee-type/{employeeTypeId}")
    public ResponseEntity<List<SalaryStructureComponentResponseDTO>> updateByEmployeeType(@PathVariable Long employeeTypeId, @Valid @RequestBody SalaryStructureComponentRequestDTO requestDTO) {
        log.info("REST: Request to update components for employeeTypeId: {}", employeeTypeId);
        List<SalaryStructureComponentResponseDTO> result = componentFacade.updateComponentsByEmployeeType(employeeTypeId, requestDTO);
        log.info("REST: Successfully updated components for employeeTypeId: {}", employeeTypeId);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> getTotalCount() {
        log.info("REST: Request to fetch total SalaryStructureComponent count");
        return ResponseEntity.ok(componentFacade.getTotalCount());
    }
}
