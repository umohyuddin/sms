package com.smartsolutions.eschool.student.dtos.invoiceDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentFeeInvoiceRequestDTO {

    @NotNull(message = "Student ID is required")
    private Long studentId;

    @NotNull(message = "Academic Year ID is required")
    private Long academicYearId;

    @NotNull(message = "Month is required")
    private String month;

    @NotNull(message = "Year is required")
    private Integer year;

    private LocalDate dueDate;

    private String remarks;
}
