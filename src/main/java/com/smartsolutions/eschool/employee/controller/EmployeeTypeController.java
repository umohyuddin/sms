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
        log.info("POST /api/institute/employee-types called with: {}", requestDTO.getName());
        EmployeeTypeResponseDTO response = employeeTypeFacade.create(requestDTO);
        log.info("POST /api/institute/employee-types succeeded, created id={}", response.getId());
        return ResponseEntity.ok(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeTypeResponseDTO>> getAll() {
        log.info("GET /api/institute/employee-types called");
        List<EmployeeTypeResponseDTO> list = employeeTypeFacade.getAll();
        log.info("GET /api/institute/employee-types succeeded, returned {} resources", list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeTypeResponseDTO> getById(@PathVariable Long id) {
        log.info("GET /api/institute/employee-types/{} called", id);
        EmployeeTypeResponseDTO response = employeeTypeFacade.getById(id);
        log.info("GET /api/institute/employee-types/{} succeeded", id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeTypeResponseDTO>> getActive() {
        log.info("GET /api/institute/employee-types/active called");
        List<EmployeeTypeResponseDTO> list = employeeTypeFacade.getAllActive();
        log.info("GET /api/institute/employee-types/active succeeded, returned {} resources", list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeTypeResponseDTO>> getInactive() {
        log.info("GET /api/institute/employee-types/inactive called");
        List<EmployeeTypeResponseDTO> list = employeeTypeFacade.getAllInactive();
        log.info("GET /api/institute/employee-types/inactive succeeded, returned {} resources", list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeTypeResponseDTO>> search(@RequestParam String keyword) {
        log.info("GET /api/institute/employee-types/search called with keyword='{}'", keyword);
        List<EmployeeTypeResponseDTO> list = employeeTypeFacade.searchByKeyword(keyword);
        log.info("GET /api/institute/employee-types/search succeeded, returned {} resources", list.size());
        return ResponseEntity.ok(list);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeTypeResponseDTO> update(@PathVariable Long id, @RequestBody @Valid EmployeeTypeRequestDTO requestDTO) {
        log.info("PUT /api/institute/employee-types/{} called", id, requestDTO.getName());
        EmployeeTypeResponseDTO response = employeeTypeFacade.update(id, requestDTO);
        log.info("PUT /api/institute/employee-types/{} succeeded", id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("DELETE /api/institute/employee-types/{} called", id);
        employeeTypeFacade.delete(id);
        log.info("DELETE /api/institute/employee-types/{} succeeded", id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/count/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> countAll() {
        log.info("GET /api/institute/employee-types/count/all called");
        return ResponseEntity.ok(employeeTypeFacade.countAll());
    }

    @GetMapping(value = "/count/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> countActive() {
        log.info("GET /api/institute/employee-types/count/active called");
        return ResponseEntity.ok(employeeTypeFacade.countActive());
    }

    @GetMapping(value = "/count/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> countInactive() {
        log.info("GET /api/institute/employee-types/count/inactive called");
        return ResponseEntity.ok(employeeTypeFacade.countInactive());
    }
}
