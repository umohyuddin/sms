package com.smartsolutions.eschool.student.dtos.studentFeeSummary.responseDto;

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
public class StudentFeeSummaryResponseDto {

    private Long id;

    private BigDecimal totalAssignedFee;
    private BigDecimal totalPaid;
    private BigDecimal balance;

    private Long studentId;
    private String studentFullName;   // optional (recommended)
    private Long academicYearId;
    private String academicYearName;

    private LocalDate academicStartDate;
    private LocalDate academicEndDate;
    private long academicTotalMonths;

    private BigDecimal monthlyFeeDecimal;

    private List<String> monthsNames;

    // Original payment list (optional, detailed list)
    private List<StudentFeePaymentResponseDTO> studentFeePaymentsList;

    // -----------------------------
    // New field: Monthly payments with partial payment details
    // -----------------------------
    private List<MonthlyPaymentDTO> monthlyPayments = new ArrayList<>();

    // -----------------------------
    // Nested DTOs for monthly summary
    // -----------------------------
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PartialPaymentDTO {
        private Long id;
        private LocalDate paymentDate;
        private BigDecimal amountPaid;
        private String paymentMode;

        public PartialPaymentDTO(StudentFeePaymentResponseDTO p) {
            this.id = p.getId();
            this.paymentDate = p.getPaymentDate();
            this.amountPaid = BigDecimal.valueOf(p.getAmountPaid());
            this.paymentMode = p.getPaymentMode();
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MonthlyPaymentDTO {
        private String month;
        private BigDecimal totalPaid = BigDecimal.ZERO;
        private BigDecimal totalPaidSoFar = BigDecimal.ZERO;
        private BigDecimal totalMonthlyFee = BigDecimal.ZERO;
        private String status; // Paid | Partial | Unpaid
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
