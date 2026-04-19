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
@Schema(description = "Daily attendance record for an individual student")
public class DailyAttendanceReportDTO {

    @Schema(description = "ID of the student", example = "500")
    private Long studentId;

    @Schema(description = "Full name of the student", example = "Arslan Ahmed")
    private String studentName; // optional

    @Schema(description = "Date of attendance", example = "2024-04-19")
    private LocalDate date;

    @Schema(description = "Attendance status", example = "PRESENT")
    private String status; // PRESENT, ABSENT, LEAVE

    @Schema(description = "Optional remarks", example = "Late entry")
    private String remarks;
}
