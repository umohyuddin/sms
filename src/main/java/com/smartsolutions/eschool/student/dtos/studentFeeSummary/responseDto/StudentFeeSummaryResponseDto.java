package com.smartsolutions.eschool.student.dtos.studentFeeSummary.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import com.smartsolutions.eschool.student.dtos.studentFeePayment.responseDto.StudentFeePaymentResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Comprehensive response object for student fee summary across an academic session")
public class StudentFeeSummaryResponseDto {

    @Schema(description = "ID of the summary (student-based)", example = "5001")
    private Long id;

    @Schema(description = "Total fees assigned for the session", example = "60000.00")
    private BigDecimal totalAssignedFee;

    @Schema(description = "Total fees paid to date", example = "20000.00")
    private BigDecimal totalPaid;

    @Schema(description = "Total late fees applied to date", example = "500.00")
    private BigDecimal totalLateFee;

    @Schema(description = "Total tax applied to date", example = "250.00")
    private BigDecimal totalTax;

    @Schema(description = "Current outstanding balance", example = "40000.00")
    private BigDecimal balance;

    @Schema(description = "ID of the student", example = "5001")
    private Long studentId;

    @Schema(description = "Full name of the student", example = "John Doe")
    private String studentFullName;   // optional (recommended)

    @Schema(description = "ID of the academic year", example = "1")
    private Long academicYearId;

    @Schema(description = "Name of the academic year", example = "2024-2025")
    private String academicYearName;

    @Schema(description = "Start date of the session", example = "2024-04-01")
    private LocalDate academicStartDate;

    @Schema(description = "End date of the session", example = "2025-03-31")
    private LocalDate academicEndDate;

    @Schema(description = "Total months in the session", example = "12")
    private long academicTotalMonths;

    @Schema(description = "Monthly installment amount", example = "5000.00")
    private BigDecimal monthlyFeeDecimal;

    @Schema(description = "List of months in the session", example = "[\"April\", \"May\", \"June\"]")
    private List<String> monthsNames;

    // Original payment list (optional, detailed list)
    @Schema(description = "Detailed list of all raw payments")
    private List<StudentFeePaymentResponseDTO> studentFeePaymentsList;

    // -----------------------------
    // New field: Monthly payments with partial payment details
    // -----------------------------
    @Schema(description = "Grouped monthly payment status and details")
    private List<MonthlyPaymentDTO> monthlyPayments = new ArrayList<>();

    // -----------------------------
    // Nested DTOs for monthly summary
    // -----------------------------
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Schema(description = "Nested DTO for a single installment within a month")
    public static class PartialPaymentDTO {
        @Schema(description = "ID of the individual payment record", example = "1001")
        private Long id;
        @Schema(description = "Date of payment", example = "2024-04-05")
        private LocalDate paymentDate;
        @Schema(description = "Amount paid in this installment", example = "2500.00")
        private BigDecimal amountPaid;
        @Schema(description = "Mode of payment", example = "CASH")
        private com.smartsolutions.eschool.student.enums.PaymentMode paymentMode;

        public PartialPaymentDTO(StudentFeePaymentResponseDTO p) {
            this.id = p.getId();
            this.paymentDate = p.getPaymentDate();
            this.amountPaid = p.getAmountPaid();
            this.paymentMode = p.getPaymentMode();
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Schema(description = "Nested DTO summarizing payments for a specific month")
    public static class MonthlyPaymentDTO {
        @Schema(description = "The month name", example = "April")
        private String month;
        @Schema(description = "Total amount paid specifically in this month", example = "5000.00")
        private BigDecimal totalPaid = BigDecimal.ZERO;
        @Schema(description = "Cumulative amount paid up to this month", example = "5000.00")
        private BigDecimal totalPaidSoFar = BigDecimal.ZERO;
        @Schema(description = "Amount required for this month", example = "5000.00")
        private BigDecimal totalMonthlyFee = BigDecimal.ZERO;
        @Schema(description = "Payment status", example = "PAID")
        private String status; // Paid | Partial | Unpaid
        @Schema(description = "Detailed installments made for this month")
        private List<PartialPaymentDTO> partialPayments = new ArrayList<>();

        public MonthlyPaymentDTO(String month) {
            this.month = month;
        }

        public void addPartialPayment(PartialPaymentDTO payment) {
            this.totalPaid = this.totalPaid.add(payment.getAmountPaid());
            this.partialPayments.add(payment);
        }
    }

}
