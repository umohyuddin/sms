package com.smartsolutions.eschool.employee.controller;

import com.smartsolutions.eschool.employee.dtos.EmployeeDepartmentHistory.response.EmployeeDepartmentHistoryResponseDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeDesignationHistory.request.EmployeeDesignationHistoryRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeDesignationHistory.response.EmployeeDesignationHistoryResponseDTO;
import com.smartsolutions.eschool.employee.facade.EmployeeDesignationHistoryFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employees/designations")
@Slf4j
@RequiredArgsConstructor
public class EmployeeDesignationHistoryController {

    private final EmployeeDesignationHistoryFacade facade;

    @PostMapping(value = "/assign", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDesignationHistoryResponseDTO> assignDesignation(
            @RequestBody EmployeeDesignationHistoryRequestDTO request) {

        log.info("Assigning designation ID {} to employee ID {}", request.getDesignationId(), request.getEmployeeId());
        EmployeeDesignationHistoryResponseDTO response = facade.assignDesignation(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(value = "/current/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCurrentDepartment(
            @PathVariable Long employeeId) {
        log.info("Fetching current department for Employee ID {}", employeeId);
        EmployeeDesignationHistoryResponseDTO response = facade.getCurrentDepartment(employeeId);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/history/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDepartmentHistory(
            @PathVariable Long employeeId) {
        log.info("Fetching department history for Employee ID {}", employeeId);
        List<EmployeeDesignationHistoryResponseDTO> history = facade.getDesignationHistory(employeeId);
        return ResponseEntity.ok(history);
    }
}
