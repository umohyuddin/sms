package com.smartsolutions.eschool.employee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.request.EmployeeSalaryRequestDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.response.EmployeeSalaryFullResponseDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.response.EmployeeSalaryResponseDTO;
import com.smartsolutions.eschool.employee.facade.EmployeeMasterSalaryFacade;
import com.smartsolutions.eschool.employee.facade.EmployeeSalaryFaced;
import com.smartsolutions.eschool.employee.model.EmployeeSalaryEntity;
import com.smartsolutions.eschool.global.enums.SalaryStatus;
import com.smartsolutions.eschool.util.MultiResourceSuccessResponseObject;
import com.smartsolutions.eschool.util.ResourceObject;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/institute/employee-salaries")
@Slf4j
public class EmployeeSalaryController {

    private final EmployeeMasterSalaryFacade salaryFacade;

    public EmployeeSalaryController(EmployeeMasterSalaryFacade salaryFacade) {
        this.salaryFacade = salaryFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeSalaryFullResponseDTO>> getEmployeeSalaryList() {
        log.info("GET /api/institute/employee-salaries called");
        List<EmployeeSalaryFullResponseDTO> response = salaryFacade.getEmployeeSalaryList();
        return ResponseEntity.ok(response);
    }
    // -------------------------
    // CREATE
    // -------------------------
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeSalaryResponseDTO> createSalary(@Valid @RequestBody EmployeeSalaryRequestDTO requestDTO) {
        log.info("POST /api/institute/employee-salaries called with {}", requestDTO);
        EmployeeSalaryResponseDTO response = salaryFacade.createSalary(requestDTO);
        log.info("Salary created successfully with id={}", response.getId());
        return ResponseEntity.ok(response);
    }

    // -------------------------
    // UPDATE
    // -------------------------
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeSalaryResponseDTO> updateSalary(@PathVariable Long id, @Valid @RequestBody EmployeeSalaryRequestDTO requestDTO) {
        log.info("PUT /api/institute/employee-salaries/{} called with {}", id, requestDTO);
        EmployeeSalaryResponseDTO response = salaryFacade.updateSalary(id, requestDTO);
        log.info("Salary updated successfully with id={}", response.getId());
        return ResponseEntity.ok(response);
    }

    // -------------------------
    // GET BY ID
    // -------------------------
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeSalaryResponseDTO> getSalaryById(@PathVariable Long id) {
        log.info("GET /api/institute/employee-salaries/{} called", id);
        EmployeeSalaryResponseDTO response = salaryFacade.getSalaryById(id);
        return ResponseEntity.ok(response);
    }

    // -------------------------
    // GET ALL SALARIES FOR EMPLOYEE
    // -------------------------
    @GetMapping(value = "/employee/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeSalaryResponseDTO>> getAllSalariesForEmployee(@PathVariable Long employeeId) {
        log.info("GET /api/institute/employee-salaries/employee/{} called", employeeId);
        List<EmployeeSalaryResponseDTO> response = salaryFacade.getAllSalariesForEmployee(employeeId);
        return ResponseEntity.ok(response);
    }

    // -------------------------
    // GET SALARIES BY STATUS
    // -------------------------
//    @GetMapping(value = "/status/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<EmployeeSalaryResponseDTO>> getSalariesByStatus(@PathVariable SalaryStatus status) {
//        log.info("GET /api/institute/employee-salaries/status/{} called", status);
//        List<EmployeeSalaryResponseDTO> response = salaryFacade.getSalariesByStatus(status);
//        return ResponseEntity.ok(response);
//    }

    // -------------------------
    // GET SALARY BY EMPLOYEE & MONTH/YEAR
    // -------------------------
//    @GetMapping(value = "/employee/{employeeId}/month", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<EmployeeSalaryResponseDTO> getSalaryByEmployeeAndMonth(@PathVariable Long employeeId, @RequestParam Integer year, @RequestParam Integer month) {
//        log.info("GET /api/institute/employee-salaries/employee/{}/month called with year={}, month={}", employeeId, year, month);
//        Optional<EmployeeSalaryResponseDTO> response = salaryFacade.getSalaryByEmployeeAndMonth(employeeId, year, month);
//        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

    // -------------------------
    // SOFT DELETE
    // -------------------------
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> softDeleteSalary(@PathVariable Long id) {
        log.info("DELETE /api/institute/employee-salaries/{} called", id);
        salaryFacade.softDeleteSalary(id);
        return ResponseEntity.noContent().build();
    }
}