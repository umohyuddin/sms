package com.smartsolutions.eschool.student.dtos.attendance;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request object for marking student attendance")
public class StudentAttendanceRequestDTO {
    @Schema(description = "Unique identifier of the attendance record (for updates)", example = "1001")
    private Long id;

    @Schema(description = "ID of the organization", example = "101")
    private Long organizationId;

    @NotNull(message = "Campus ID is required")
    @Schema(description = "ID of the campus", example = "1")
    private Long campusId;
    
    @NotNull(message = "Student ID is required")
    @Schema(description = "ID of the student", example = "500")
    private Long studentId;
    
    @NotNull(message = "Standard ID is required")
    @Schema(description = "ID of the academic standard", example = "5")
    private Long standardId;
    
    @NotNull(message = "Section ID is required")
    @Schema(description = "ID of the section", example = "1")
    private Long sectionId;
    
    @NotNull(message = "Attendance date is required")
    @Schema(description = "Date of attendance", example = "2024-04-19")
    private LocalDate attendanceDate;
    
    @NotNull(message = "Status is required")
    @Schema(description = "Attendance status", example = "PRESENT", allowableValues = {"PRESENT", "ABSENT", "LEAVE"})
    private String status; // PRESENT, ABSENT, LEAVE
    
    @Schema(description = "ID of the user marking the attendance", example = "10")
    private Long markedById;

    @Schema(description = "Optional remarks", example = "Came late due to medical reason")
    private String remarks;
}
