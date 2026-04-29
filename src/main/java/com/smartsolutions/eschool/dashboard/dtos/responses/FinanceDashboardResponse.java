package com.smartsolutions.eschool.dashboard.dtos.responses;

import com.smartsolutions.eschool.dashboard.dtos.KpiMetric;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinanceDashboardResponse {
    private KpiMetric revenueTrend;
    private Map<String, Double> collectionByFeeType;
    private Map<String, Double> pendingByStandard;
    private Double occupancyRate; // relevant for boarding/seat capacity
}
