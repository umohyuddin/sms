package com.smartsolutions.eschool.employee.controller;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.facade.EmployeeMasterFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/institute/employees")
@Slf4j
public class EmployeeMasterController {
    @Autowired
    private EmployeeMasterFacade employeeFacade;

    // -------------------------
    // Get all employees
    // -------------------------
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeMasterResponseDto>> getAllEmployees() {
        log.info("GET /api/institute/employees called");
        List<EmployeeMasterResponseDto> employees = employeeFacade.getAllEmployees();
        log.info("GET /api/institute/employees returned {} employees", employees.size());
        return ResponseEntity.ok(employees);
    }

    // -------------------------
    // Get employee by ID
    // -------------------------
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeMasterResponseDto> getEmployeeById(@PathVariable Long id) {
        log.info("GET /api/institute/employees/{} called", id);
        EmployeeMasterResponseDto employee = employeeFacade.getEmployeeById(id);
        log.info("Returning Employee: id={}", employee.getId());
        return ResponseEntity.ok(employee);
    }

    // -------------------------
    // Get employee by code
    // -------------------------
    @GetMapping(value = "/code/{employeeCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeMasterResponseDto> getEmployeeByCode(@PathVariable String employeeCode) {
        log.info("GET /api/institute/employees/code/{} called", employeeCode);
        EmployeeMasterResponseDto employee = employeeFacade.getEmployeeByCode(employeeCode);
        log.info("Returning Employee: code={}", employee.getEmployeeCode());
        return ResponseEntity.ok(employee);
    }

    // -------------------------
    // Search employees by name
    // -------------------------
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeMasterResponseDto>> searchEmployees(@RequestParam String name) {
        log.info("GET /api/institute/employees/search called with name={}", name);
        List<EmployeeMasterResponseDto> employees = employeeFacade.searchEmployeesByName(name);
        log.info("Returned {} employees matching name={}", employees.size(), name);
        return ResponseEntity.ok(employees);
    }

    // -------------------------
    // Filter employees by gender
    // -------------------------
    @GetMapping(value = "/gender/{gender}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeMasterResponseDto>> getEmployeesByGender(@PathVariable String gender) {
        log.info("GET /api/institute/employees/gender/{} called", gender);
        List<EmployeeMasterResponseDto> employees = employeeFacade.getEmployeesByGender(gender);
        log.info("Returned {} employees for gender={}", employees.size(), gender);
        return ResponseEntity.ok(employees);
    }

    // -------------------------
    // Filter employees by active status
    // -------------------------
    @GetMapping(value = "/active/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeMasterResponseDto>> getEmployeesByActiveStatus(@PathVariable Boolean status) {
        log.info("GET /api/institute/employees/active/{} called", status);
        List<EmployeeMasterResponseDto> employees = employeeFacade.getEmployeesByActiveStatus(status);
        log.info("Returned {} employees for active status={}", employees.size(), status);
        return ResponseEntity.ok(employees);
    }

    // -------------------------
    // Filter employees by probation end date
    // -------------------------
    @GetMapping(value = "/probation-before", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeMasterResponseDto>> getEmployeesWithProbationEndedBefore(@RequestParam Date date) {
        log.info("GET /api/institute/employees/probation-before called with date={}", date);
        List<EmployeeMasterResponseDto> employees = employeeFacade.getEmployeesWithProbationEndedBefore(date);
        log.info("Returned {} employees with probation ended before {}", employees.size(), date);
        return ResponseEntity.ok(employees);
    }

    // -------------------------
    // Create a new employee
    // -------------------------
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeMasterResponseDto> createEmployee(@RequestBody EmployeeMasterRequestDto requestDto) {
        log.info("POST /api/institute/employees called to create new employee: {}", requestDto);
        EmployeeMasterResponseDto createdEmployee = employeeFacade.createEmployee(requestDto);
        log.info("Employee created successfully with id: {}", createdEmployee.getId());
        return ResponseEntity.ok(createdEmployee);
    }

    // -------------------------
    // Metrics
    // -------------------------
    @GetMapping(value = "/count/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> getTotalEmployees() {
        log.info("GET /api/institute/employees/count/all called");
        return ResponseEntity.ok(employeeFacade.getTotalEmployees());
    }

    @GetMapping(value = "/count/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> getTotalActiveEmployees() {
        log.info("GET /api/institute/employees/count/active called");
        return ResponseEntity.ok(employeeFacade.getTotalActiveEmployees());
    }

    @GetMapping(value = "/count/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> getTotalInactiveEmployees() {
        log.info("GET /api/institute/employees/count/inactive called");
        return ResponseEntity.ok(employeeFacade.getTotalInactiveEmployees());
    }
}