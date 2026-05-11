package com.smartsolutions.eschool.student.dtos.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Response object for a single student fee assignment record")
public class StudentFeeAssignmentDTO {
    @Schema(description = "Unique ID of the assignment", example = "100")
    private Long id;

    // Student info
    @Schema(description = "Student ID", example = "5001")
    private Long studentId;

    @Schema(description = "Full name of the student", example = "John Doe")
    private String fullName;

    @Schema(description = "First name", example = "John")
    private String firstName;

    @Schema(description = "Last name", example = "Doe")
    private String lastName;

    // Fee rate info
    @Schema(description = "ID of the applied fee rate", example = "50")
    private Long feeRateId;

    @Schema(description = "ID of the fee component", example = "10")
    private Long componentId;

    @Schema(description = "Name of the fee component", example = "Tuition Fee")
    private String componentName;

    @Schema(description = "Total assigned amount", example = "5000.00")
    private BigDecimal amount;

    // Dates
    @Schema(description = "Date the fee was assigned", example = "2024-04-01")
    private LocalDate assignedDate;

    @Schema(description = "Payment due date", example = "2024-05-15")
    private LocalDate dueDate;
}
