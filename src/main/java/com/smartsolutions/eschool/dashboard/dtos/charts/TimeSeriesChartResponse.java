package com.smartsolutions.eschool.dashboard.dtos.charts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeSeriesChartResponse {
    private List<String> labels;
    private List<BigDecimal> values;
}
