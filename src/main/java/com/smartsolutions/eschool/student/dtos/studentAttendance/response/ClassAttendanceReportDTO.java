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
@Schema(description = "Daily attendance report for a specific class section")
public class ClassAttendanceReportDTO {

    @Schema(description = "ID of the academic standard", example = "5")
    private Long standardId;

    @Schema(description = "ID of the section", example = "1")
    private Long sectionId;

    @Schema(description = "Date of the report", example = "2024-04-19")
    private LocalDate date;

    @Schema(description = "Count of present students", example = "25")
    private Long presentCount;

    @Schema(description = "Count of absent students", example = "2")
    private Long absentCount;

    @Schema(description = "Count of students on leave", example = "1")
    private Long leaveCount;
}
