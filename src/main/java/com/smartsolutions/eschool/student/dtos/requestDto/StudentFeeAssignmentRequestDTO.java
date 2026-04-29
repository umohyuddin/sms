package com.smartsolutions.eschool.student.dtos.requestDto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request object for assigning fee components to a student")
public class StudentFeeAssignmentRequestDTO {
    @Schema(description = "ID of the existing assignment (if updating)", example = "100")
    private Long id;

    @Schema(description = "ID of the student to whom fees are being assigned", example = "5001")
    private Long studentId;

    @Schema(description = "ID of the campus", example = "1")
    private Long campusId;

    @Schema(description = "ID of the academic standard (grade level)", example = "5")
    private Long standardId;

    @Schema(description = "ID of the academic year", example = "1")
    private Long academicYearId;

    @Schema(description = "Optional ID of a discount component to be applied", example = "15")
    private Long discountComponentId;

    @Schema(description = "List of IDs for the fee components to assign", example = "[1, 2, 3]")
    private List<Long> componentIds;  // FeeComponent IDs

    @Schema(description = "Final date by which the assigned fees should be paid", example = "2024-05-15")
    private LocalDate dueDate;

    @Schema(description = "The date on which the fee assignment takes effect", example = "2024-04-01")
    private LocalDate assignedDate;
}
