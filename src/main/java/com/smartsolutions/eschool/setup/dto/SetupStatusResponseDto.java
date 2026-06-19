package com.smartsolutions.eschool.setup.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

/**
 * DTO representing the overall setup status of the system.
 */
@Data
@Builder
public class SetupStatusResponseDto {
    private int completionPercentage;
    private int completedSteps;
    private int totalSteps;
    private List<SetupStepDto> steps;
}
