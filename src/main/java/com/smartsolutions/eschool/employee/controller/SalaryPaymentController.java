package com.smartsolutions.eschool.employee.controller;


import com.smartsolutions.eschool.employee.dtos.salaryPayment.request.SalaryPaymentRequestDTO;
import com.smartsolutions.eschool.employee.dtos.salaryPayment.response.SalaryPaymentResponseDTO;
import com.smartsolutions.eschool.employee.facade.SalaryPaymentFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/salary-payments")
@Slf4j
public class SalaryPaymentController {
    private final SalaryPaymentFacade paymentFacade;

    public SalaryPaymentController(SalaryPaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    // -------------------------
    // CREATE PAYMENT
    // -------------------------
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryPaymentResponseDTO> createPayment(@RequestBody SalaryPaymentRequestDTO requestDTO) {
        log.info("POST /api/institute/salary-payments called: {}", requestDTO);
        SalaryPaymentResponseDTO createdPayment = paymentFacade.createPayment(requestDTO);
        log.info("Salary payment created with id={}", createdPayment.getId());
        return ResponseEntity.ok(createdPayment);
    }

    // -------------------------
    // UPDATE PAYMENT
    // -------------------------
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryPaymentResponseDTO> updatePayment(@PathVariable Long id, @RequestBody SalaryPaymentRequestDTO requestDTO) {
        log.info("PUT /api/institute/salary-payments/{} called", id);
        SalaryPaymentResponseDTO updatedPayment = paymentFacade.updatePayment(id, requestDTO);
        log.info("Salary payment updated with id={}", updatedPayment.getId());
        return ResponseEntity.ok(updatedPayment);
    }

    // -------------------------
    // GET BY ID
    // -------------------------
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaryPaymentResponseDTO> getPaymentById(@PathVariable Long id) {
        log.info("GET /api/institute/salary-payments/{} called", id);
        return ResponseEntity.ok(paymentFacade.getPaymentById(id));
    }

    // -------------------------
    // GET ALL
    // -------------------------
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryPaymentResponseDTO>> getAllPayments() {
        log.info("GET /api/institute/salary-payments called");
        return ResponseEntity.ok(paymentFacade.getAllPayments());
    }

    // -------------------------
    // GET BY EMPLOYEE SALARY
    // -------------------------
    @GetMapping(value = "/employee-salary/{employeeSalaryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryPaymentResponseDTO>> getPaymentsByEmployeeSalary(@PathVariable Long employeeSalaryId) {
        log.info("GET /api/institute/salary-payments/employee-salary/{} called", employeeSalaryId);
        return ResponseEntity.ok(paymentFacade.getPaymentsByEmployeeSalary(employeeSalaryId));
    }

    // -------------------------
    // SOFT DELETE
    // -------------------------
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        log.info("DELETE /api/institute/salary-payments/{} called", id);
        paymentFacade.softDeletePayment(id);
        log.info("Salary payment soft deleted id={}", id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/employee/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaryPaymentResponseDTO>> getPaymentsByEmployeeId(@PathVariable Long employeeId) {
        log.info("GET /api/institute/salary-payments/employee/{} called", employeeId);
        List<SalaryPaymentResponseDTO> payments = paymentFacade.getPaymentsByEmployeeId(employeeId);
        return ResponseEntity.ok(payments);
    }
}

