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

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollPeriodResponseDTO> createPayrollPeriod(@RequestBody PayrollPeriodRequestDTO requestDTO) {
        log.info("POST /api/institute/payroll-periods/create called");
        PayrollPeriodResponseDTO result = payrollFacade.createPayrollPeriod(requestDTO);
        log.info("POST /api/institute/payroll-periods/create succeeded, created resource with id={}", result.getId());
        return ResponseEntity.status(org.springframework.http.HttpStatus.CREATED).body(result);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollPeriodResponseDTO> updatePayrollPeriod(@PathVariable Long id, @RequestBody PayrollPeriodRequestDTO requestDTO) {
        log.info("PUT /api/institute/payroll-periods/{} called", id);
        PayrollPeriodResponseDTO result = payrollFacade.updatePayrollPeriod(id, requestDTO);
        log.info("PUT /api/institute/payroll-periods/{} succeeded", id);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PayrollPeriodResponseDTO>> getAllPayrollPeriods() {
        log.info("GET /api/institute/payroll-periods/list called");
        List<PayrollPeriodResponseDTO> list = payrollFacade.getAllPayrollPeriods();
        log.info("GET /api/institute/payroll-periods/list succeeded, returned {} resources", list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollPeriodResponseDTO> getPayrollPeriodById(@PathVariable Long id) {
        log.info("GET /api/institute/payroll-periods/{} called", id);
        PayrollPeriodResponseDTO result = payrollFacade.getPayrollPeriodById(id);
        log.info("GET /api/institute/payroll-periods/{} succeeded", id);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/status/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PayrollPeriodResponseDTO>> getPayrollPeriodsByStatus(@PathVariable String status) {
        log.info("GET /api/institute/payroll-periods/status/{} called", status);
        PayrollPeriodEntity.PayrollStatus payrollStatus = PayrollPeriodEntity.PayrollStatus.valueOf(status.toUpperCase());
        List<PayrollPeriodResponseDTO> list = payrollFacade.getPayrollPeriodsByStatus(payrollStatus);
        log.info("GET /api/institute/payroll-periods/status/{} succeeded, returned {} resources", status, list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PayrollPeriodResponseDTO>> search(@RequestParam String keyword) {
        log.info("GET /api/institute/payroll-periods/search called with keyword='{}'", keyword);
        List<PayrollPeriodResponseDTO> list = payrollFacade.searchByKeyword(keyword);
        log.info("GET /api/institute/payroll-periods/search succeeded, returned {} resources", list.size());
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("DELETE /api/institute/payroll-periods/{} called", id);
        payrollFacade.delete(id);
        log.info("DELETE /api/institute/payroll-periods/{} succeeded", id);
        return ResponseEntity.noContent().build();
    }
}
