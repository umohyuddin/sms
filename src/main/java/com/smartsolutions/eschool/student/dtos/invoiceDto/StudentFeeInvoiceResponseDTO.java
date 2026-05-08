package com.smartsolutions.eschool.student.dtos.invoiceDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentFeeInvoiceResponseDTO {

    private Long id;
    private String invoiceNumber;
    private Long studentId;
    private String studentName;
    private Long academicYearId;
    private String academicYearName;
    private String month;
    private Integer year;
    private BigDecimal totalAmount;
    private BigDecimal lateFeeAmount;
    private BigDecimal discountAmount;
    private BigDecimal paidAmount;
    private BigDecimal balance;
    private LocalDate dueDate;
    private LocalDate invoiceDate;
    private String status;
    private List<InvoiceDetailDTO> details;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class InvoiceDetailDTO {
        private Long id;
        private Long feeAssignmentId;
        private String componentName;
        private BigDecimal amount;
    }
}
