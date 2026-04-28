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
@Schema(description = "Response containing detailed student analytics breakdown")
public class StudentDashboardResponse {
    @Schema(description = "Hierarchical distribution of students by campus and class")
    private List<CampusStudentDistribution> campuses;
}
