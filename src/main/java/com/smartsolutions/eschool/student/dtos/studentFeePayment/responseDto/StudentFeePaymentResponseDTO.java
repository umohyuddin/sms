package com.smartsolutions.eschool.student.dtos.studentFeePayment.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Response object for a student fee payment confirmation")
public class StudentFeePaymentResponseDTO {
    @Schema(description = "Unique ID of the payment record", example = "1001")
    private Long id;

    @Schema(description = "ID of the student", example = "5001")
    private Long studentId;

    @Schema(description = "Full name of the student", example = "John Doe")
    private String studentFullName;

    @Schema(description = "Date of payment", example = "2024-04-01")
    private LocalDate paymentDate;

    @Schema(description = "Amount paid", example = "5000.00")
    private BigDecimal amountPaid;

    @Schema(description = "Month for which fee was paid", example = "April")
    private String paymentMonth;

    @Schema(description = "Year of the payment month", example = "2024")
    private Integer paymentYear;

    @Schema(description = "Mode of payment", example = "CASH")
    private String paymentMode;

    @Schema(description = "System recording timestamp", example = "2024-04-01T10:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "ID of the academic year", example = "1")
    private Long academicYearId;

    @Schema(description = "Name of the academic year", example = "2024-2025")
    private String academicYearName;

    // -------------------------------------------
    // 2. Partial Payment DTO
    // -------------------------------------------
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Schema(description = "Nested DTO for partial payment detail")
    public static class PartialPaymentDTO {
        @Schema(description = "ID of the partial payment", example = "1001")
        private Long id;
        @Schema(description = "Date of payment", example = "2024-04-01")
        private LocalDate paymentDate;
        @Schema(description = "Amount paid", example = "2500.00")
        private BigDecimal amountPaid;
        @Schema(description = "Mode of payment", example = "CASH")
        private String paymentMode;

        // Constructor from original DTO
        public PartialPaymentDTO(StudentFeePaymentResponseDTO p) {
            this.id = p.getId();
            this.paymentDate = p.getPaymentDate();
            this.amountPaid = p.getAmountPaid();
            this.paymentMode = p.getPaymentMode();
        }
    }

    // -------------------------------------------
    // 3. Monthly Payment DTO
    // -------------------------------------------
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Schema(description = "Nested DTO for monthly payment summary")
    public static class MonthlyPaymentDTO {
        @Schema(description = "Month name", example = "April")
        private String month;
        @Schema(description = "Total paid in this month", example = "5000.00")
        private BigDecimal totalPaid = BigDecimal.ZERO;
        @Schema(description = "List of installments for this month")
        private List<PartialPaymentDTO> partialPayments = new ArrayList<>();

        public MonthlyPaymentDTO(String month) {
            this.month = month;
        }

        public void addPartialPayment(PartialPaymentDTO payment) {
            if (payment.getAmountPaid() != null) {
                this.totalPaid = this.totalPaid.add(payment.getAmountPaid());
            }
            this.partialPayments.add(payment);
        }
    }
}


