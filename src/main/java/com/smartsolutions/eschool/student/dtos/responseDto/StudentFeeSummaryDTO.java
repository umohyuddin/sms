package com.smartsolutions.eschool.student.dtos.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Summarized view of all fees, payments, and balance for a specific student in an academic year")
public class StudentFeeSummaryDTO {
    @Schema(description = "Unique identifier (student ID based)", example = "5001")
    private Long id;

    @Schema(description = "Total cumulative fee amount assigned to the student", example = "60000.00")
    private BigDecimal totalAssignedFee;

    @Schema(description = "Total discount amount applied", example = "5000.00")
    private BigDecimal totalDiscount;

    @Schema(description = "Total amount paid to date", example = "20000.00")
    private BigDecimal totalPaid;

    @Schema(description = "Remaining outstanding balance", example = "35000.00")
    private BigDecimal balance;

    @Schema(description = "ID of the student", example = "5001")
    private Long studentId;

    @Schema(description = "Full name of the student", example = "John Doe")
    private String studentFullName;   // optional (recommended)

    @Schema(description = "ID of the academic year", example = "1")
    private Long academicYearId;

    @Schema(description = "Name of the academic year", example = "2024-2025")
    private String academicYearName;

    @Schema(description = "Start date of the academic session", example = "2024-04-01")
    private LocalDate startDate;

    @Schema(description = "End date of the academic session", example = "2025-03-31")
    private LocalDate endDate;

    @Schema(description = "Total duration of the session in months", example = "12")
    private long academicTotalMonths;

    @Schema(description = "Calculated monthly installments", example = "5000.00")
    private BigDecimal monthlyFeeDecimal;

    @Schema(description = "List of month names covered", example = "[\"April\", \"May\", \"June\"]")
    private List<String> monthsNames;

    @Schema(description = "Detailed list of payments made by the student")
    private List<StudentFeePaymentResponseDTO> studentFeePaymentsList;
}
