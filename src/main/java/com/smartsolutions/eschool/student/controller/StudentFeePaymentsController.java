package com.smartsolutions.eschool.student.controller;



import com.smartsolutions.eschool.student.dtos.studentFeePayment.requestDto.StudentFeePaymentRequestDTO;
import com.smartsolutions.eschool.student.facade.StudentFeePaymentsFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.smartsolutions.eschool.global.error.ErrorResponse;

@Transactional
@RestController
@RequestMapping("/api/students")
@Slf4j
@Tag(name = "Fee Management - Payments", description = "Endpoints for recording and managing student fee collections.")
public class StudentFeePaymentsController {

private final StudentFeePaymentsFacade studentFeePaymentsFacade;

    public StudentFeePaymentsController(StudentFeePaymentsFacade studentFeePaymentsFacade) {
        this.studentFeePaymentsFacade = studentFeePaymentsFacade;
    }

    @Operation(summary = "Process student fee payment", description = "Record a new fee payment from a student for a specific month and academic year.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully recorded payment",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentFeePaymentRequestDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid payment request",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping( value = "/fee/payments",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> studentFeePayment(@RequestBody @Valid StudentFeePaymentRequestDTO requestDTO) {

        log.info("Received request to Student Fee payment for student Id: {}", requestDTO.getStudentId());
        StudentFeePaymentRequestDTO studentFeePayment = studentFeePaymentsFacade.studentFeePayment(requestDTO.getStudentId(),requestDTO);
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
