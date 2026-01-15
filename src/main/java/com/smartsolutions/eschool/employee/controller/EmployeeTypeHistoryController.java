package com.smartsolutions.eschool.employee.controller;

import com.smartsolutions.eschool.employee.dtos.EmployeeTypeHistory.request.EmployeeTypeHistoryRequestDTO;
import com.smartsolutions.eschool.employee.dtos.EmployeeTypeHistory.response.EmployeeTypeHistoryDTO;
import com.smartsolutions.eschool.employee.facade.EmployeeTypeHistoryFacade;
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
@RequestMapping("/api/employees/types")
@Slf4j
@RequiredArgsConstructor
public class EmployeeTypeHistoryController {

    private final EmployeeTypeHistoryFacade facade;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeTypeHistoryDTO> assignEmployeeType(@RequestBody EmployeeTypeHistoryRequestDTO request) {

        log.info("Assigning Employee Type {} to Employee {}", request.getEmployeeTypeId(), request.getEmployeeId());

        EmployeeTypeHistoryDTO response = facade.assignEmployeeType(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}