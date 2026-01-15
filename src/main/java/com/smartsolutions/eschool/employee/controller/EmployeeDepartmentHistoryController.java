package com.smartsolutions.eschool.employee.controller;



import com.smartsolutions.eschool.employee.dtos.EmployeeDepartmentHistory.request.EmployeeDepartmentHistoryRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeDepartmentHistory.response.EmployeeDepartmentHistoryResponseDTO;
import com.smartsolutions.eschool.employee.facade.EmployeeDepartmentHistoryFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees/departments")
@Slf4j
@RequiredArgsConstructor
public class EmployeeDepartmentHistoryController {

    private final EmployeeDepartmentHistoryFacade departmentFacade;

    /**
     * Assign a department to an employee
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDepartmentHistoryResponseDTO> assignDepartment(
            @RequestBody EmployeeDepartmentHistoryRequestDTO request) {
        log.info("Assigning Department ID {} to Employee ID {}",
                request.getDepartmentId(), request.getEmployeeId());
        EmployeeDepartmentHistoryResponseDTO response = departmentFacade.assignDepartment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


//    @PostMapping(
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public ResponseEntity<?> assignDepartment(
//            @RequestBody String rawJson) {
//
//        log.info("RAW JSON: {}", rawJson);
//        return ResponseEntity.ok().build();
//    }

    /**
     * Get current department of an employee
     */
    @GetMapping(value = "/current/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDepartmentHistoryResponseDTO> getCurrentDepartment(
            @PathVariable Long employeeId) {
        log.info("Fetching current department for Employee ID {}", employeeId);
        EmployeeDepartmentHistoryResponseDTO response = departmentFacade.getCurrentDepartment(employeeId);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(response);
    }

    /**
     * Get full department history of an employee
     */
    @GetMapping(value = "/history/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeDepartmentHistoryResponseDTO>> getDepartmentHistory(
            @PathVariable Long employeeId) {
        log.info("Fetching department history for Employee ID {}", employeeId);
        List<EmployeeDepartmentHistoryResponseDTO> history = departmentFacade.getDepartmentHistory(employeeId);
        return ResponseEntity.ok(history);
    }

    /**
     * Soft delete a department assignment
     */
    @DeleteMapping(value = "/{historyId}/{deletedBy}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long historyId, @PathVariable Long deletedBy) {
        log.info("Soft deleting department assignment ID {} by user ID {}", historyId, deletedBy);
        departmentFacade.deleteAssignment(historyId, deletedBy);
        return ResponseEntity.noContent().build();
    }
}
