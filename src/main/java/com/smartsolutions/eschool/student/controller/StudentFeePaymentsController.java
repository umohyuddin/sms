package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.requestDto.StudentDiscountAssignmentRequestDTO;
import com.smartsolutions.eschool.student.facade.StudentFeePaymentsFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
@RequestMapping("/api/students")
@Slf4j
public class StudentFeePaymentsController {

private final StudentFeePaymentsFacade studentFeePaymentsFacade;

    public StudentFeePaymentsController(StudentFeePaymentsFacade studentFeePaymentsFacade) {
        this.studentFeePaymentsFacade = studentFeePaymentsFacade;
    }

    @PostMapping( value = "/{studentId}/payments",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> studentFeePayment(@PathVariable Long studentId, @RequestBody @Valid StudentDiscountAssignmentRequestDTO requestDTO) {

        log.info("Received request to Student Fee payment for student Id: {}", studentId);
        StudentDiscountAssignmentRequestDTO studentFeePayment = studentFeePaymentsFacade.studentFeePayment(studentId,requestDTO);
        log.info("Student Fee Assignment created successfully with id: {}", studentFeePayment.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(studentFeePayment);
    }
//
//    @GetMapping(value = "/{studentId}/fees/{academicYearId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> getById(@PathVariable Long studentId, @PathVariable Long academicYearId) {
//        log.info("GET /api/student/fee/assignment by Student id called");
//        StudentFeeAssignmentsResponseDTO feeAssignmentByStudentId  = studentFeePaymentsFacade.getFeeAssignmentByStudentId(studentId,academicYearId);
//        log.info("GET /api/student/fee/assignment by Student id succeeded");
//        return ResponseEntity.ok().body(feeAssignmentByStudentId);
//    }
}
