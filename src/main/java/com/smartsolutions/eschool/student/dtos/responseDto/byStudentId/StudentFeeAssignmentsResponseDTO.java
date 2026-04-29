package com.smartsolutions.eschool.student.dtos.responseDto.byStudentId;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Student-centric response containing all assigned fee components")
public class StudentFeeAssignmentsResponseDTO {
    @Schema(description = "Unique identifier of the student", example = "5001")
    private Long studentId;

    @Schema(description = "Full name for display", example = "John Doe")
    private String fullName;

    @Schema(description = "First name", example = "John")
    private String firstName;

    @Schema(description = "Last name", example = "Doe")
    private String lastName;

    @Schema(description = "List of individual fee component assignments")
    private List<FeeAssignmentDTO> feeAssignments;

}
