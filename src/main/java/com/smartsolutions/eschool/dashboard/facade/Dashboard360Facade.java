package com.smartsolutions.eschool.dashboard.facade;

import com.smartsolutions.eschool.dashboard.dtos.DashboardFilter;
import com.smartsolutions.eschool.dashboard.dtos.KpiMetric;
import com.smartsolutions.eschool.dashboard.dtos.responses.*;
import com.smartsolutions.eschool.student.service.StudentService;
import com.smartsolutions.eschool.student.service.FeeService;
import com.smartsolutions.eschool.employee.service.EmployeeMasterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Component
@Scope("prototype")
@Slf4j
@RequiredArgsConstructor
public class Dashboard360Facade {

    private final StudentService nStudentService;
    private final FeeService nFeeService;
    private final EmployeeMasterService nEmployeeService;

    public DashboardKpiResponse getKpiSummary(DashboardFilter filter) {
        Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
        log.info("[Facade:DashboardFacade] getKpiSummary() called - orgId: {}", orgId);

        CompletableFuture<Long> totalStudentsFuture = CompletableFuture
                .supplyAsync(() -> nStudentService.countStudents(filter, orgId));
        CompletableFuture<Long> activeStudentsFuture = CompletableFuture
                .supplyAsync(() -> nStudentService.countActiveStudents(filter, orgId));
        CompletableFuture<Long> inactiveStudentsFuture = CompletableFuture
                .supplyAsync(() -> nStudentService.countInactiveStudents(filter, orgId));
        CompletableFuture<Long> newAdmissionsFuture = CompletableFuture
                .supplyAsync(() -> nStudentService.countNewAdmissions(filter, orgId));
        CompletableFuture<Long> withdrawalsFuture = CompletableFuture
                .supplyAsync(() -> nStudentService.countWithdrawals(filter, orgId));
        CompletableFuture<BigDecimal> totalCollectionFuture = CompletableFuture
                .supplyAsync(() -> nFeeService.getTotalCollection(filter, orgId));
        CompletableFuture<BigDecimal> pendingDuesFuture = CompletableFuture.supplyAsync(() -> nFeeService.getPendingDues(filter, orgId));
        CompletableFuture<Double> efficiencyFuture = CompletableFuture.supplyAsync(() -> nFeeService.getCollectionEfficiency(filter, orgId));
        CompletableFuture<Long> totalEmployeesFuture = CompletableFuture.supplyAsync(() -> nEmployeeService.countEmployees(filter, orgId));
        CompletableFuture<java.util.Map<String, Long>> genderFuture = CompletableFuture.supplyAsync(() -> nStudentService.getGenderDistribution(filter, orgId));
        CompletableFuture<java.util.Map<String, Long>> employeeGenderFuture = CompletableFuture.supplyAsync(() -> nEmployeeService.getEmployeeGenderDistribution(filter, orgId));

        CompletableFuture.allOf(
                totalStudentsFuture, activeStudentsFuture, inactiveStudentsFuture,
                newAdmissionsFuture, withdrawalsFuture,
                totalCollectionFuture, pendingDuesFuture, efficiencyFuture,
                totalEmployeesFuture, genderFuture, employeeGenderFuture
        ).join();

        try {
            return DashboardKpiResponse.builder()
                    .totalStudents(KpiMetric.builder()
                            .currentValue(BigDecimal.valueOf(totalStudentsFuture.join()))
                            .build())
                    .activeStudents(KpiMetric.builder()
                            .currentValue(BigDecimal.valueOf(activeStudentsFuture.join()))
                            .build())
                    .inactiveStudents(KpiMetric.builder()
                            .currentValue(BigDecimal.valueOf(inactiveStudentsFuture.join()))
                            .build())
                    .newAdmissions(KpiMetric.builder()
                            .currentValue(BigDecimal.valueOf(newAdmissionsFuture.join()))
                            .build())
                    .withdrawals(KpiMetric.builder()
                            .currentValue(BigDecimal.valueOf(withdrawalsFuture.join()))
                            .build())
                    .totalCollection(KpiMetric.builder()
                            .currentValue(totalCollectionFuture.join())
                            .build())
                    .pendingDues(KpiMetric.builder()
                            .currentValue(pendingDuesFuture.join())
                            .build())
                    .collectionEfficiency(KpiMetric.builder()
                            .currentValue(BigDecimal.valueOf(efficiencyFuture.join()))
                            .build())
                    .totalEmployees(KpiMetric.builder()
                            .currentValue(BigDecimal.valueOf(totalEmployeesFuture.join()))
                            .genderDistribution(employeeGenderFuture.join())
                            .build())
                    .genderDistribution(genderFuture.join())
                    .build();
        } catch (Exception e) {
            log.error("[Facade:DashboardFacade] Error aggregating KPIs", e);
            throw new RuntimeException("Error aggregating dashboard data", e);
        }
    }

    public StudentDashboardResponse getStudentStats(DashboardFilter filter) {
        Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
        log.info("[Facade:DashboardFacade] getStudentStats() called - orgId: {}", orgId);
        return StudentDashboardResponse.builder()
                .campuses(nStudentService.getCampusClassDistribution(filter, orgId))
                .build();
    }

    public FinanceDashboardResponse getFinanceStats(DashboardFilter filter) {
        Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
        log.info("[Facade:DashboardFacade] getFinanceStats() called - orgId: {}", orgId);
        return FinanceDashboardResponse.builder()
                .revenueTrend(KpiMetric.builder().currentValue(nFeeService.getTotalCollection(filter, orgId)).build())
                .collectionByFeeType(nFeeService.getCollectionByFeeType(filter, orgId))
                .pendingByStandard(nFeeService.getPendingByStandard(filter, orgId))
                .build();
    }

    public HrDashboardResponse getHrStats(DashboardFilter filter) {
        Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
        log.info("[Facade:DashboardFacade] getHrStats() called - orgId: {}", orgId);
        return HrDashboardResponse.builder()
                .staffByType(nEmployeeService.getStaffCountByType(filter, orgId))
                .build();
    }

    public Page<AlertResponse> getAlerts(DashboardFilter filter, Pageable pageable) {
        log.info("[Facade:DashboardFacade] getAlerts() called");
        return new PageImpl<>(new ArrayList<>(), pageable, 0);
    }

    public Page<ActivityResponse> getActivity(DashboardFilter filter, Pageable pageable) {
        log.info("[Facade:DashboardFacade] getActivity() called");
        return new PageImpl<>(new ArrayList<>(), pageable, 0);
    }
}
