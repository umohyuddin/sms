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
public class StudentDashboardResponse {
    private KpiMetric enrollmentTrend;
    private Map<String, Long> genderDistribution;
    private Map<String, Long> admissionBySource;
    private Map<String, Long> studentsByStandard;
}
