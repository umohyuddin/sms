package com.smartsolutions.eschool.dashboard.dtos.charts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChartSlice {
    private String label;
    private BigDecimal value;
}
