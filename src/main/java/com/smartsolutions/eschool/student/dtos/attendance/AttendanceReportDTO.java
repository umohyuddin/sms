package com.smartsolutions.eschool.student.dtos.attendance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Response object for aggregated attendance reports")
public class AttendanceReportDTO {
    @Schema(description = "Aggregation level (e.g., ORGANIZATION, CAMPUS, STANDARD, SECTION)", example = "SECTION")
    private String level; // ORGANIZATION, CAMPUS, STANDARD, SECTION

    @Schema(description = "ID of the specific level being reported", example = "1")
    private Long levelId;

    @Schema(description = "Name of the level being reported", example = "Section A")
    private String levelName;
    
    @Schema(description = "Total count of students marked as Present", example = "25")
    private long totalPresent;

    @Schema(description = "Total count of students marked as Absent", example = "2")
    private long totalAbsent;

    @Schema(description = "Total count of students on Leave", example = "1")
    private long totalLeave;

    @Schema(description = "Total number of students in the scope", example = "28")
    private long totalStudents;
    
    @Schema(description = "Percentage of students present", example = "89.28")
    private double presentPercentage;

    @Schema(description = "Percentage of students absent", example = "7.14")
    private double absentPercentage;

    @Schema(description = "Percentage of students on leave", example = "3.57")
    private double leavePercentage;
    
    @Schema(description = "Detailed breakdown at the next hierarchical level")
    private List<AttendanceSummaryDTO> details;
}
