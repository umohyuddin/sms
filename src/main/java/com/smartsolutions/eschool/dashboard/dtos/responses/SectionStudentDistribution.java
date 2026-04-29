package com.smartsolutions.eschool.dashboard.dtos.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Distribution of students for a specific section within a class")
public class SectionStudentDistribution {
    @Schema(description = "ID of the section", example = "101")
    private Long sectionId;

    @Schema(description = "Name of the section", example = "Section A")
    private String sectionName;

    @Schema(description = "Total number of students in the section", example = "30")
    private Long total;

    @Schema(description = "Number of active students", example = "28")
    private Long active;

    @Schema(description = "Number of male students", example = "15")
    private Long male;

    @Schema(description = "Number of female students", example = "13")
    private Long female;

    @Schema(description = "Number of students with other or unassigned gender", example = "2")
    private Long other;
}
