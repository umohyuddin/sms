package com.smartsolutions.eschool.employee.controller;


import com.smartsolutions.eschool.employee.dtos.EmployeeType.request.EmployeeTypeRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeType.response.EmployeeTypeResponseDTO;
import com.smartsolutions.eschool.employee.facade.EmployeeTypeFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/employee-types")
@Slf4j
public class EmployeeTypeController {

    private final EmployeeTypeFacade employeeTypeFacade;

    public EmployeeTypeController(EmployeeTypeFacade employeeTypeFacade) {
        this.employeeTypeFacade = employeeTypeFacade;
    }

    // -------------------------
// Create Employee Type
// -------------------------
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeTypeResponseDTO> create(@RequestBody @Valid EmployeeTypeRequestDTO requestDTO) {

        log.info("POST /api/institute/employee-types called");
        EmployeeTypeResponseDTO response = employeeTypeFacade.create(requestDTO);
        log.info("EmployeeType created with id={}", response.getId());
        return ResponseEntity.ok(response);
    }

    // -------------------------
// Get all employee types
// -------------------------
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeTypeResponseDTO>> getAll() {

        log.info("GET /api/institute/employee-types called");
        List<EmployeeTypeResponseDTO> list = employeeTypeFacade.getAll();
        log.info("Returned {} employee types", list.size());
        return ResponseEntity.ok(list);
    }

    // -------------------------
// Get employee type by ID
// -------------------------
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeTypeResponseDTO> getById(@PathVariable Long id) {

        log.info("GET /api/institute/employee-types/{} called", id);
        EmployeeTypeResponseDTO response = employeeTypeFacade.getById(id);
        return ResponseEntity.ok(response);
    }

    // -------------------------
// Get active employee types
// -------------------------
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeTypeResponseDTO>> getActive() {

        log.info("GET /api/institute/employee-types/active called");
        return ResponseEntity.ok(employeeTypeFacade.getAllActive());
    }

    // -------------------------
// Get inactive employee types
// -------------------------
    @GetMapping(value = "/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeTypeResponseDTO>> getInactive() {

        log.info("GET /api/institute/employee-types/inactive called");
        return ResponseEntity.ok(employeeTypeFacade.getAllInactive());
    }

    // -------------------------
// Search employee types
// -------------------------
//    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<EmployeeTypeResponseDTO>> search(@RequestParam String keyword) {
//
//        log.info("GET /api/institute/employee-types/search?keyword={}", keyword);
//        return ResponseEntity.ok(employeeTypeFacade.searchByKeyword(keyword));
//    }

    // -------------------------
// Update employee type
// -------------------------
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeTypeResponseDTO> update(@PathVariable Long id, @RequestBody @Valid EmployeeTypeRequestDTO requestDTO) {

        log.info("PUT /api/institute/employee-types/{} called", id);
        EmployeeTypeResponseDTO response = employeeTypeFacade.update(id, requestDTO);
        return ResponseEntity.ok(response);
    }

    // -------------------------
// Soft delete employee type
// -------------------------
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> softDelete(@PathVariable Long id) {
//
//        log.info("DELETE /api/institute/employee-types/{} called", id);
//        int result = employeeTypeFacade.softDelete(id);
//
//        if (result == 0) {
//            log.warn("EmployeeType not found with id={}", id);
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.ok(Map.of("message", "Employee Type deleted successfully"));
//    }

    // -------------------------
// Metrics
// -------------------------
    @GetMapping(value = "/count/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> countAll() {
        return ResponseEntity.ok(employeeTypeFacade.countAll());
    }

    @GetMapping(value = "/count/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> countActive() {
        return ResponseEntity.ok(employeeTypeFacade.countActive());
    }

    @GetMapping(value = "/count/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> countInactive() {
        return ResponseEntity.ok(employeeTypeFacade.countInactive());
    }
}