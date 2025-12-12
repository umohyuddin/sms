package com.smartsolutions.eschool.student.dtos.studentFeePayment.responseDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentFeePaymentResponseDTO {
    private Long id;

    private Long studentId;
    private String studentFullName;

    private LocalDate paymentDate;

    private Double amountPaid;

    private String paymentMonth;

    private Integer paymentYear;

    private String paymentMode;

    private LocalDateTime createdAt;

    private Long academicYearId;
    private String academicYearName;

    // -------------------------------------------
    // 2. Partial Payment DTO
    // -------------------------------------------
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PartialPaymentDTO {
        private Long id;
        private LocalDate paymentDate;
        private Double amountPaid;
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
    public static class MonthlyPaymentDTO {
        private String month;
        private Double totalPaid = 0.0;
        private List<PartialPaymentDTO> partialPayments = new ArrayList<>();

        public MonthlyPaymentDTO(String month) {
            this.month = month;
        }

        public void addPartialPayment(PartialPaymentDTO payment) {
            this.totalPaid += payment.getAmountPaid();
            this.partialPayments.add(payment);
        }
    }
}


