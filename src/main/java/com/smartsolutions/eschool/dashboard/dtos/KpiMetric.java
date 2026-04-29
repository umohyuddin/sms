package com.smartsolutions.eschool.dashboard.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KpiMetric {
    private Double currentValue;
    private Double previousValue;
    private Double percentageChange;
    private TrendDirection trendDirection;

    public enum TrendDirection {
        UP, DOWN, NEUTRAL
    }
}
