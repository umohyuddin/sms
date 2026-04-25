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
public class HrDashboardResponse {
    private KpiMetric employeeRetention;
    private Map<String, Long> staffByType;
    private Map<String, Double> attendanceSummary;
}
