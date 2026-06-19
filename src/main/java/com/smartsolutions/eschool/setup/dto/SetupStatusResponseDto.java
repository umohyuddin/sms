package com.smartsolutions.eschool.setup.dto;

import java.util.List;

/**
 * DTO representing the overall setup status of the system.
 */
public class SetupStatusResponseDto {
    private int completionPercentage;
    private int completedSteps;
    private int totalSteps;
    private List<SetupStepDto> steps;

    public SetupStatusResponseDto() {}

    public SetupStatusResponseDto(int completionPercentage, int completedSteps, int totalSteps, List<SetupStepDto> steps) {
        this.completionPercentage = completionPercentage;
        this.completedSteps = completedSteps;
        this.totalSteps = totalSteps;
        this.steps = steps;
    }

    public int getCompletionPercentage() { return completionPercentage; }
    public void setCompletionPercentage(int completionPercentage) { this.completionPercentage = completionPercentage; }

    public int getCompletedSteps() { return completedSteps; }
    public void setCompletedSteps(int completedSteps) { this.completedSteps = completedSteps; }

    public int getTotalSteps() { return totalSteps; }
    public void setTotalSteps(int totalSteps) { this.totalSteps = totalSteps; }

    public List<SetupStepDto> getSteps() { return steps; }
    public void setSteps(List<SetupStepDto> steps) { this.steps = steps; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private int completionPercentage;
        private int completedSteps;
        private int totalSteps;
        private List<SetupStepDto> steps;

        public Builder completionPercentage(int completionPercentage) { this.completionPercentage = completionPercentage; return this; }
        public Builder completedSteps(int completedSteps) { this.completedSteps = completedSteps; return this; }
        public Builder totalSteps(int totalSteps) { this.totalSteps = totalSteps; return this; }
        public Builder steps(List<SetupStepDto> steps) { this.steps = steps; return this; }
        public SetupStatusResponseDto build() { return new SetupStatusResponseDto(completionPercentage, completedSteps, totalSteps, steps); }
    }
}
