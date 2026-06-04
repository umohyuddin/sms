package com.smartsolutions.eschool.dashboard.dtos.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Distribution of students for a specific class")
public class ClassStudentDistribution {
    @Schema(description = "ID of the class/standard", example = "10")
    private Long classId;

    @Schema(description = "Name of the class/standard", example = "Class 1")
    private String className;
    
    @Schema(description = "Total number of students in the class", example = "60")
    private Long total;
    
    @Schema(description = "Number of active students", example = "55")
    private Long active;
    
    @Schema(description = "Number of male students", example = "30")
    private Long male;
    
    @Schema(description = "Number of female students", example = "25")
    private Long female;
    
    @Schema(description = "Number of students with other or unassigned gender", example = "5")
    private Long other;

    @Schema(description = "Breakdown of students by section within this class")
    private List<SectionStudentDistribution> sections;
}
