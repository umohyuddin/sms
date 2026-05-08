package com.smartsolutions.eschool.dashboard.dtos.responses;

import com.smartsolutions.eschool.dashboard.dtos.KpiMetric;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinanceDashboardResponse {
    private KpiMetric revenueTrend;
    private Map<String, BigDecimal> collectionByFeeType;
    private Map<String, BigDecimal> pendingByStandard;
    private BigDecimal occupancyRate; // relevant for boarding/seat capacity
}
