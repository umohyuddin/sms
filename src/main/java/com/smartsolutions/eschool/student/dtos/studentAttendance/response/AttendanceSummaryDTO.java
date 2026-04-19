package com.smartsolutions.eschool.student.dtos.studentAttendance.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Student-specific attendance summary over a date range")
public class AttendanceSummaryDTO {

    @Schema(description = "ID of the student", example = "500")
    private Long studentId;

    @Schema(description = "Full name of the student", example = "Arslan Ahmed")
    private String studentName; // optional, join with student table if needed

    @Schema(description = "Total count of Present marks", example = "20")
    private Long totalPresent;

    @Schema(description = "Total count of Absent marks", example = "2")
    private Long totalAbsent;

    @Schema(description = "Total count of Leave marks", example = "1")
    private Long totalLeave;
}
