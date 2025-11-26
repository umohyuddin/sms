package com.smartsolutions.eschool.student.dtos.requestDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentFeePaymentRequestDTO {
    private Long id;

    @NotNull(message = "Student ID is required")
    private Long studentId;

    @NotNull(message = "Assignment ID is required")
    private Long assignmentId;

    @NotNull(message = "Payment date is required")
    private LocalDate paymentDate;

    @NotNull(message = "Academic year is required")
    private Long academicYearId;

    @NotNull(message = "Amount paid is required")
    @Positive(message = "Amount must be greater than zero")
    private Double amountPaid;

    @NotNull(message = "Payment month is required")
    @Size(min = 3, max = 20, message = "Payment month must be valid")
    private String paymentMonth;  // Example: "January", "Feb", "03"

    @NotNull(message = "Payment year is required")
    private Integer paymentYear;

    private String paymentMode;   // Cash, Bank, Online
}
