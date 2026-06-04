package com.smartsolutions.eschool.dashboard.facade;

import com.smartsolutions.eschool.dashboard.dtos.DashboardFilter;
import com.smartsolutions.eschool.dashboard.dtos.charts.ChartSlice;
import com.smartsolutions.eschool.dashboard.dtos.charts.PieChartResponse;
import com.smartsolutions.eschool.dashboard.dtos.charts.TimeSeriesChartResponse;
import com.smartsolutions.eschool.dashboard.dtos.enums.GroupBy;
import com.smartsolutions.eschool.student.service.StudentService;
import com.smartsolutions.eschool.student.service.FeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
@Slf4j
@RequiredArgsConstructor
public class DashboardChartFacade {

    private final StudentService nStudentService;
    private final FeeService nFeeService;

    public TimeSeriesChartResponse getAdmissionsTrend(DashboardFilter filter) {
        Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
        log.info("[Facade:DashboardChartFacade] getAdmissionsTrend() called - orgId: {}", orgId);
        List<Object[]> results = nStudentService.getAdmissionsTrend(filter, orgId);
        return transformToTimeSeries(results, filter.getGroupBy());
    }

    public TimeSeriesChartResponse getRevenueTrend(DashboardFilter filter) {
        Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
        log.info("[Facade:DashboardChartFacade] getRevenueTrend() called - orgId: {}", orgId);
        List<Object[]> results = nFeeService.getRevenueTrend(filter, orgId);
        return transformToTimeSeries(results, filter.getGroupBy());
    }

    public PieChartResponse getGenderDistribution(DashboardFilter filter) {
        Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
        log.info("[Facade:DashboardChartFacade] getGenderDistribution() called - orgId: {}", orgId);
        List<Object[]> results = nStudentService.getGenderDistributionChart(filter, orgId);
        return transformToPie(results);
    }

    public PieChartResponse getFeeStatusDistribution(DashboardFilter filter) {
        Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
        log.info("[Facade:DashboardChartFacade] getFeeStatusDistribution() called - orgId: {}", orgId);
        List<Object[]> results = nFeeService.getFeeStatusDistribution(filter, orgId);
        return transformToPie(results);
    }

    public TimeSeriesChartResponse getClassStrength(DashboardFilter filter) {
        Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
        log.info("[Facade:DashboardChartFacade] getClassStrength() called - orgId: {}", orgId);
        List<Object[]> results = nStudentService.getClassStrengthChart(filter, orgId);
        return transformToTimeSeries(results, GroupBy.CLASS);
    }

    public PieChartResponse getCampusCollection(DashboardFilter filter) {
        Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
        log.info("[Facade:DashboardChartFacade] getCampusCollection() called - orgId: {}", orgId);
        List<Object[]> results = nFeeService.getCampusCollectionChart(filter, orgId);
        return transformToPie(results);
    }

    private TimeSeriesChartResponse transformToTimeSeries(List<Object[]> results, GroupBy groupBy) {
        java.util.Map<String, BigDecimal> dataMap = new java.util.LinkedHashMap<>();

        for (Object[] row : results) {
            String label = formatLabel(row[0], groupBy);
            BigDecimal value = row[1] != null ? new BigDecimal(row[1].toString()) : BigDecimal.ZERO;
            dataMap.merge(label, value, BigDecimal::add);
        }

        return TimeSeriesChartResponse.builder()
                .labels(new ArrayList<>(dataMap.keySet()))
                .values(new ArrayList<>(dataMap.values()))
                .build();
    }

    private PieChartResponse transformToPie(List<Object[]> results) {
        List<ChartSlice> slices = results.stream()
                .map(row -> ChartSlice.builder()
                        .label(row[0] != null ? row[0].toString() : "Unknown")
                        .value(row[1] != null ? new BigDecimal(row[1].toString()) : BigDecimal.ZERO)
                        .build())
                .collect(Collectors.toList());

        return PieChartResponse.builder().data(slices).build();
    }

    private String formatLabel(Object rawLabel, GroupBy groupBy) {
        if (rawLabel == null) return "N/A";
        
        if (rawLabel instanceof LocalDate date) {
            if (groupBy == GroupBy.MONTH) {
                return date.format(DateTimeFormatter.ofPattern("MMM yyyy"));
            } else if (groupBy == GroupBy.DAY) {
                return date.format(DateTimeFormatter.ofPattern("dd MMM"));
            }
            return date.toString();
        }
        
        return rawLabel.toString();
    }
}
