package com.smartsolutions.eschool.employee.controller;

import com.smartsolutions.eschool.employee.dtos.EmployeeType.request.EmployeeTypeRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeType.response.EmployeeTypeResponseDTO;
import com.smartsolutions.eschool.employee.facade.EmployeeTypeFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employee/employee-types/v1")
@Slf4j
public class EmployeeTypeController {

    private final EmployeeTypeFacade employeeTypeFacade;

    public EmployeeTypeController(EmployeeTypeFacade employeeTypeFacade) {
        this.employeeTypeFacade = employeeTypeFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeTypeResponseDTO>> getAll() {
        log.info("[Controller:EmployeeTypeController] getAll() called - Request to get all employee types");
        List<EmployeeTypeResponseDTO> resources = employeeTypeFacade.getAll();
        log.info("[Controller:EmployeeTypeController] getAll() succeeded - Found {} employee types", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeTypeResponseDTO>> getAllActive() {
        log.info("[Controller:EmployeeTypeController] getAllActive() called - Request to get all active employee types");
        List<EmployeeTypeResponseDTO> resources = employeeTypeFacade.getAllActive();
        log.info("[Controller:EmployeeTypeController] getAllActive() succeeded - Found {} active employee types", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeTypeResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:EmployeeTypeController] getById() called - Request to fetch employee type with id: {}", id);
        EmployeeTypeResponseDTO employeeType = employeeTypeFacade.getById(id);
        log.info("[Controller:EmployeeTypeController] getById() succeeded - Found employee type: {}", id);
        return ResponseEntity.ok(employeeType);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeTypeResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:EmployeeTypeController] search() called - Request to search employee types with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<EmployeeTypeResponseDTO> responseDTOs = employeeTypeFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:EmployeeTypeController] search() succeeded - Found {} employee types matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:EmployeeTypeController] delete() called - Request to delete employee type: {}", id);
        employeeTypeFacade.softDeleteById(id);
        log.info("[Controller:EmployeeTypeController] delete() succeeded - Employee type: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Employee Type deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeTypeResponseDTO> create(@Valid @RequestBody EmployeeTypeRequestDTO requestDTO) {
        log.info("[Controller:EmployeeTypeController] create() called - Request to create employee type: {}", requestDTO.getName());
        EmployeeTypeResponseDTO responseDTO = employeeTypeFacade.create(requestDTO);
        log.info("[Controller:EmployeeTypeController] create() succeeded - Employee type created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeTypeResponseDTO> update(@PathVariable Long id, @Valid @RequestBody EmployeeTypeRequestDTO requestDTO) {
        log.info("[Controller:EmployeeTypeController] update() called - Request to update employee type: {}", id);
        EmployeeTypeResponseDTO responseDTO = employeeTypeFacade.update(id, requestDTO);
        log.info("[Controller:EmployeeTypeController] update() succeeded - Employee type: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:EmployeeTypeController] getStatistics() called");
        Map<String, Long> statistics = employeeTypeFacade.getStatistics();
        log.info("[Controller:EmployeeTypeController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
