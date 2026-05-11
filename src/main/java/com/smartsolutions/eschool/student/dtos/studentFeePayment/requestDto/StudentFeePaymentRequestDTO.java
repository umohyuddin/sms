package com.smartsolutions.eschool.student.dtos.studentFeePayment.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request object for recording a student fee payment")
public class StudentFeePaymentRequestDTO {
    @Schema(description = "Unique identifier of the payment record (for updates)", example = "1001")
    private Long id;

    @NotNull(message = "Student ID is required")
    @Schema(description = "ID of the student making the payment", example = "5001")
    private Long studentId;

    @NotNull(message = "Payment date is required")
    @Schema(description = "Date on which the payment was received", example = "2024-04-01")
    private LocalDate paymentDate;

    @NotNull(message = "Academic year is required")
    @Schema(description = "ID of the academic year for which parent fee is being paid", example = "1")
    private Long academicYearId;

    @NotNull(message = "Amount paid is required")
    @Positive(message = "Amount must be greater than zero")
    @Schema(description = "Monetary amount paid", example = "5000.00")
    private BigDecimal amountPaid;

    @Schema(description = "Late fee amount paid (if any)", example = "200.00")
    private BigDecimal lateFeePaid;

    @NotNull(message = "Payment month is required")
    @Size(min = 3, max = 20, message = "Payment month must be valid")
    @Schema(description = "The month for which the fee is paid", example = "April")
    private String paymentMonth;  // Example: "January", "Feb", "03"

    @NotNull(message = "Payment year is required")
    @Schema(description = "The year of the payment month", example = "2024")
    private Integer paymentYear;

    @Schema(description = "Method of payment", example = "CASH")
    private com.smartsolutions.eschool.student.enums.PaymentMode paymentMode;   // Cash, Bank, Online
}
