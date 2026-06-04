package com.smartsolutions.eschool.student.dtos.attendance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Summary of attendance for a specific entity (e.g., a specific Campus or Standard)")
public class AttendanceSummaryDTO {

    @Schema(description = "ID of the entity (Campus/Standard/Section/Student)", example = "101")
    private Long id;

    @Schema(description = "Name of the entity", example = "Main Campus")
    private String name;

    @Schema(description = "Count of present marks", example = "100")
    private long presentCount;

    @Schema(description = "Count of absent marks", example = "5")
    private long absentCount;

    @Schema(description = "Count of leave marks", example = "2")
    private long leaveCount;

    @Schema(description = "Total number of students in this scope", example = "107")
    private long totalCount;

    @Schema(description = "Overall attendance percentage", example = "93.45")
    private double attendancePercentage;
}
