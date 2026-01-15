package com.smartsolutions.eschool.employee.controller;

import com.smartsolutions.eschool.employee.dtos.EmployeeDesignationHistory.request.EmployeeDesignationHistoryRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeDesignationHistory.response.EmployeeDesignationHistoryResponseDTO;
import com.smartsolutions.eschool.employee.facade.EmployeeDesignationHistoryFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}