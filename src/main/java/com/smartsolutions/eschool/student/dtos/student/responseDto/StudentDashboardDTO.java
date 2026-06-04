package com.smartsolutions.eschool.student.dtos.student.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Data Transfer Object for Student Dashboard statistics")
public class StudentDashboardDTO {
    @Schema(description = "Total number of students", example = "1500")
    private Long totalStudents;

    @Schema(description = "Total number of male students", example = "800")
    private Long totalMaleStudents;

    @Schema(description = "Total number of female students", example = "690")
    private Long totalFemaleStudents;

    @Schema(description = "Total number of students with 'Other' gender identified", example = "10")
    private Long totalOtherStudents;

    @Schema(description = "Distribution of students across different campuses")
    private Map<String, Long> studentsByCampus;

    @Schema(description = "Distribution of students across different academic standards")
    private Map<String, Long> studentsByStandard;

    @Schema(description = "Distribution of students across different sections")
    private Map<String, Long> studentsBySection;

    @Schema(description = "Count of students enrolled in the current month", example = "25")
    private Long studentsRegisteredThisMonth;
}
