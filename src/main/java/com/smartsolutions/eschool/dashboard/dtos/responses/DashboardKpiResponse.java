package com.smartsolutions.eschool.dashboard.dtos.responses;

import com.smartsolutions.eschool.dashboard.dtos.KpiMetric;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardKpiResponse {
    private KpiMetric totalStudents;
    private KpiMetric activeStudents;
    private KpiMetric newAdmissions;
    private KpiMetric totalCollection;
    private KpiMetric pendingDues;
    private KpiMetric totalEmployees;
}
