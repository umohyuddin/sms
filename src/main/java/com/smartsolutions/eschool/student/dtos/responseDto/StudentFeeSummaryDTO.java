package com.smartsolutions.eschool.student.dtos.responseDto;

import com.smartsolutions.eschool.student.dtos.studentFeePayment.responseDto.StudentFeePaymentResponseDTO;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentFeeSummaryDTO {
    private Long id;

    private BigDecimal totalAssignedFee;
    private BigDecimal totalPaid;
    private BigDecimal balance;
    private Long studentId;
    private String studentFullName;   // optional (recommended)
    private Long academicYearId;
    private String academicYearName;
    private LocalDate startDate;
    private LocalDate endDate;
    private long academicTotalMonths;
    private BigDecimal monthlyFeeDecimal;
    private List<String> monthsNames;
    private List<StudentFeePaymentResponseDTO> studentFeePaymentsList;
}
