package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.invoiceDto.StudentFeeInvoiceRequestDTO;
import com.smartsolutions.eschool.student.dtos.invoiceDto.StudentFeeInvoiceResponseDTO;
import com.smartsolutions.eschool.student.service.StudentFeeInvoiceService;
import com.smartsolutions.eschool.util.SecurityUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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
import org.springframework.web.bind.annotation.*;

import com.smartsolutions.eschool.global.error.ErrorResponse;

import java.util.List;

/**
 * CRITICAL CONTROLLER: Manages student fee invoices/vouchers.
 * This is the API for generating, retrieving, and managing invoices.
 */
@RestController
@RequestMapping("/api/invoices")
@Slf4j
@Tag(name = "Fee Management - Invoices/Vouchers", 
     description = "Endpoints for generating and managing student fee invoices and vouchers.")
public class StudentFeeInvoiceController {

    private final StudentFeeInvoiceService invoiceService;

    public StudentFeeInvoiceController(StudentFeeInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Operation(
            summary = "Generate Invoice/Voucher for Student",
            description = "Creates an invoice (voucher) for a student for a specific month and academic year. " +
                         "This consolidates all fee assignments into a single document."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Invoice generated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentFeeInvoiceResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Student or academic year not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentFeeInvoiceResponseDTO> generateInvoice(
            @Valid @RequestBody StudentFeeInvoiceRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Controller:StudentFeeInvoiceController] generateInvoice() called - studentId={}, month={}, year={}, org={}",
                requestDTO.getStudentId(), requestDTO.getMonth(), requestDTO.getYear(), organizationId);

        StudentFeeInvoiceResponseDTO response = invoiceService.generateInvoice(
                requestDTO.getStudentId(),
                requestDTO.getAcademicYearId(),
                requestDTO.getMonth(),
                requestDTO.getYear(),
                requestDTO.getDueDate()
        );

        log.info("[Controller:StudentFeeInvoiceController] generateInvoice() succeeded - invoiceNumber={}",
                response.getInvoiceNumber());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Get Invoice by ID",
            description = "Retrieves a specific invoice/voucher with all line items."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Invoice retrieved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentFeeInvoiceResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Invoice not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{invoiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentFeeInvoiceResponseDTO> getInvoiceById(
            @Parameter(description = "Unique invoice ID", example = "1001")
            @PathVariable Long invoiceId) {
        log.info("[Controller:StudentFeeInvoiceController] getInvoiceById() called - invoiceId={}", invoiceId);

        StudentFeeInvoiceResponseDTO response = invoiceService.getInvoiceById(invoiceId);

        log.info("[Controller:StudentFeeInvoiceController] getInvoiceById() succeeded");
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Get Outstanding Invoices for Student",
            description = "Retrieves all unpaid and partial invoices for a student in an academic year. " +
                         "These are the vouchers awaiting payment."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Outstanding invoices retrieved successfully",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentFeeInvoiceResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/student/{studentId}/outstanding")
    public ResponseEntity<List<StudentFeeInvoiceResponseDTO>> getOutstandingInvoices(
            @Parameter(description = "Student ID", example = "5001") @PathVariable Long studentId,
            @Parameter(description = "Academic Year ID", example = "1") @RequestParam Long academicYearId) {
        log.info("[Controller:StudentFeeInvoiceController] getOutstandingInvoices() called - studentId={}, academicYearId={}",
                studentId, academicYearId);

        List<StudentFeeInvoiceResponseDTO> response = invoiceService.getOutstandingInvoices(studentId, academicYearId);

        log.info("[Controller:StudentFeeInvoiceController] getOutstandingInvoices() succeeded - Found {} invoices",
                response.size());
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Get All Invoices for Student",
            description = "Retrieves all invoices (paid, unpaid, partial, cancelled) for a student in an academic year."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student invoices retrieved successfully",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentFeeInvoiceResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/student/{studentId}")
    public ResponseEntity<List<StudentFeeInvoiceResponseDTO>> getStudentInvoices(
            @Parameter(description = "Student ID", example = "5001") @PathVariable Long studentId,
            @Parameter(description = "Academic Year ID", example = "1") @RequestParam Long academicYearId) {
        log.info("[Controller:StudentFeeInvoiceController] getStudentInvoices() called - studentId={}, academicYearId={}",
                studentId, academicYearId);

        List<StudentFeeInvoiceResponseDTO> response = invoiceService.getStudentInvoices(studentId, academicYearId);

        log.info("[Controller:StudentFeeInvoiceController] getStudentInvoices() succeeded - Found {} invoices",
                response.size());
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Mark Invoice as Paid",
            description = "Updates invoice status to PAID and sets balance to zero."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Invoice marked as paid successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentFeeInvoiceResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Invoice not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{invoiceId}/mark-paid", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentFeeInvoiceResponseDTO> markInvoiceAsPaid(
            @Parameter(description = "Invoice ID", example = "1001") @PathVariable Long invoiceId) {
        log.info("[Controller:StudentFeeInvoiceController] markInvoiceAsPaid() called - invoiceId={}", invoiceId);

        StudentFeeInvoiceResponseDTO response = invoiceService.markInvoiceAsPaid(invoiceId);

        log.info("[Controller:StudentFeeInvoiceController] markInvoiceAsPaid() succeeded");
        return ResponseEntity.ok(response);
    }
}
