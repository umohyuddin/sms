package com.smartsolutions.eschool.employee.controller;

import com.smartsolutions.eschool.employee.dtos.salaryComponent.request.SalaryComponentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.salaryComponent.response.SalaryComponentResponseDTO;
import com.smartsolutions.eschool.employee.facade.SalaryComponentFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employee/salary-components/v1")
@Slf4j
public class SalaryComponentController {

    private final SalaryComponentFacade salaryComponentFacade;

    public SalaryComponentController(SalaryComponentFacade salaryComponentFacade) {
        this.salaryComponentFacade = salaryComponentFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryComponentResponseDTO>> getAll() {
        log.info("[Controller:SalaryComponentController] getAll() called - Request to get all salary components");
        List<SalaryComponentResponseDTO> resources = salaryComponentFacade.getAll();
        log.info("[Controller:SalaryComponentController] getAll() succeeded - Found {} salary components", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/organization/{orgId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryComponentResponseDTO>> getByOrganizationId(@PathVariable Long orgId) {
        log.info("[Controller:SalaryComponentController] getByOrganizationId() called - Request to get all salary components for org: {}", orgId);
        List<SalaryComponentResponseDTO> resources = salaryComponentFacade.getByOrganizationId(orgId);
        log.info("[Controller:SalaryComponentController] getByOrganizationId() succeeded - Found {} salary components", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryComponentResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:SalaryComponentController] getById() called - Request to fetch salary component with id: {}", id);
        SalaryComponentResponseDTO component = salaryComponentFacade.getById(id);
        log.info("[Controller:SalaryComponentController] getById() succeeded - Found salary component: {}", id);
        return ResponseEntity.ok(component);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryComponentResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:SalaryComponentController] search() called - Request to search salary components with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<SalaryComponentResponseDTO> responseDTOs = salaryComponentFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:SalaryComponentController] search() succeeded - Found {} salary components matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:SalaryComponentController] delete() called - Request to delete salary component: {}", id);
        salaryComponentFacade.softDeleteById(id);
        log.info("[Controller:SalaryComponentController] delete() succeeded - Salary component: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Salary component deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryComponentResponseDTO> create(@Valid @RequestBody SalaryComponentRequestDTO requestDTO) {
        log.info("[Controller:SalaryComponentController] create() called - Request to create salary component: {}", requestDTO.getName());
        SalaryComponentResponseDTO responseDTO = salaryComponentFacade.create(requestDTO);
        log.info("[Controller:SalaryComponentController] create() succeeded - Salary component created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryComponentResponseDTO> update(@PathVariable Long id, @Valid @RequestBody SalaryComponentRequestDTO requestDTO) {
        log.info("[Controller:SalaryComponentController] update() called - Request to update salary component: {}", id);
        SalaryComponentResponseDTO responseDTO = salaryComponentFacade.update(id, requestDTO);
        log.info("[Controller:SalaryComponentController] update() succeeded - Salary component: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:SalaryComponentController] getStatistics() called");
        Map<String, Long> statistics = salaryComponentFacade.getStatistics();
        log.info("[Controller:SalaryComponentController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
