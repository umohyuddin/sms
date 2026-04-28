package com.smartsolutions.eschool.student.dtos.studentAttendance.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "General Student Attendance DTO for reporting and marking")
public class StudentAttendanceDTO {
    @Schema(description = "Unique identifier of the attendance record", example = "1001")
    private Long id;

    @Schema(description = "ID of the student", example = "500")
    private Long studentId;

    @Schema(description = "ID of the academic standard", example = "5")
    private Long standardId;

    @Schema(description = "ID of the section", example = "1")
    private Long sectionId;

    @Schema(description = "Date of attendance", example = "2024-04-19")
    private LocalDate attendanceDate;

    @Schema(description = "Attendance status", example = "PRESENT")
    private String status; // PRESENT / ABSENT / LEAVE

    @Schema(description = "ID of the user who marked the attendance", example = "10")
    private Long markedBy;

    @Schema(description = "Optional remarks", example = "Medical leave")
    private String remarks;
}
