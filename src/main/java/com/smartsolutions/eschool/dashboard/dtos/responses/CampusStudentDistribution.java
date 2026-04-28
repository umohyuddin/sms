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
@Schema(description = "Student distribution grouped by campus")
public class CampusStudentDistribution {
    @Schema(description = "Name of the campus", example = "Main Campus")
    private String campus;
    
    @Schema(description = "List of classes and their student distribution within this campus")
    private List<ClassStudentDistribution> classes;
}
