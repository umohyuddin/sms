package com.smartsolutions.eschool.employee.controller;

import com.smartsolutions.eschool.employee.dtos.PayRollPeriod.request.PayrollPeriodRequestDTO;
import com.smartsolutions.eschool.employee.dtos.PayRollPeriod.response.PayrollPeriodResponseDTO;
import com.smartsolutions.eschool.employee.facade.PayRollPeriodFacade;
import com.smartsolutions.eschool.employee.model.PayrollPeriodEntity;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/payroll-periods")
@Slf4j
public class PayrollPeriodController {
private final PayRollPeriodFacade payrollFacade;

public PayrollPeriodController(PayRollPeriodFacade payrollFacade) {
    this.payrollFacade = payrollFacade;
}

@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<PayrollPeriodResponseDTO> createPayrollPeriod(@RequestBody PayrollPeriodRequestDTO requestDTO) {
    log.info("POST /api/institute/payroll-periods called");
    return ResponseEntity.ok(payrollFacade.createPayrollPeriod(requestDTO));
}

@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<PayrollPeriodResponseDTO> updatePayrollPeriod(@PathVariable Long id, @RequestBody PayrollPeriodRequestDTO requestDTO) {
    log.info("PUT /api/institute/payroll-periods/{} called", id);
    return ResponseEntity.ok(payrollFacade.updatePayrollPeriod(id, requestDTO));
}

@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<PayrollPeriodResponseDTO>> getAllPayrollPeriods() {
    log.info("GET /api/institute/payroll-periods called");
    return ResponseEntity.ok(payrollFacade.getAllPayrollPeriods());
}

@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<PayrollPeriodResponseDTO> getPayrollPeriodById(@PathVariable Long id) {
    log.info("GET /api/institute/payroll-periods/{} called", id);
    return ResponseEntity.ok(payrollFacade.getPayrollPeriodById(id));
}

@GetMapping(value = "/status/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<PayrollPeriodResponseDTO>> getPayrollPeriodsByStatus(@PathVariable String status) {
    log.info("GET /api/institute/payroll-periods/status/{} called", status);
    PayrollPeriodEntity.PayrollStatus payrollStatus = PayrollPeriodEntity.PayrollStatus.valueOf(status.toUpperCase());
    return ResponseEntity.ok(payrollFacade.getPayrollPeriodsByStatus(payrollStatus));
}

@DeleteMapping(value = "/{id}")
public ResponseEntity<Void> softDeletePayrollPeriod(@PathVariable Long id) {
    log.info("DELETE /api/institute/payroll-periods/{} called", id);
    payrollFacade.softDeletePayrollPeriod(id);
    return ResponseEntity.ok().build();
}
}