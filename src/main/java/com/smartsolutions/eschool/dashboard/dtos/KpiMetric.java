package com.smartsolutions.eschool.dashboard.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KpiMetric {
    private BigDecimal currentValue;
    private BigDecimal previousValue;
    private BigDecimal percentageChange;
    private TrendDirection trendDirection;

    public enum TrendDirection {
        UP, DOWN, NEUTRAL
    }
}
