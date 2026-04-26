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
        CompletableFuture<Double> totalCollectionFuture = CompletableFuture
                .supplyAsync(() -> nFeeService.getTotalCollection(filter, orgId));
        CompletableFuture<Double> pendingDuesFuture = CompletableFuture
                .supplyAsync(() -> nFeeService.getPendingDues(filter, orgId));
        CompletableFuture<Double> efficiencyFuture = CompletableFuture
                .supplyAsync(() -> nFeeService.getCollectionEfficiency(filter, orgId));
        CompletableFuture<Long> totalEmployeesFuture = CompletableFuture
                .supplyAsync(() -> nEmployeeService.countEmployees(filter, orgId));

        CompletableFuture.allOf(
                totalStudentsFuture, activeStudentsFuture, inactiveStudentsFuture,
                newAdmissionsFuture, withdrawalsFuture,
                totalCollectionFuture, pendingDuesFuture, efficiencyFuture,
                totalEmployeesFuture).join();

        try {
            return DashboardKpiResponse.builder()
                    .totalStudents(KpiMetric.builder().currentValue(totalStudentsFuture.get().doubleValue()).build())
                    .activeStudents(KpiMetric.builder().currentValue(activeStudentsFuture.get().doubleValue()).build())
                    .inactiveStudents(
                            KpiMetric.builder().currentValue(inactiveStudentsFuture.get().doubleValue()).build())
                    .newAdmissions(KpiMetric.builder().currentValue(newAdmissionsFuture.get().doubleValue()).build())
                    .withdrawals(KpiMetric.builder().currentValue(withdrawalsFuture.get().doubleValue()).build())
                    .totalCollection(KpiMetric.builder().currentValue(totalCollectionFuture.get()).build())
                    .pendingDues(KpiMetric.builder().currentValue(pendingDuesFuture.get()).build())
                    .collectionEfficiency(KpiMetric.builder().currentValue(efficiencyFuture.get()).build())
                    .totalEmployees(KpiMetric.builder().currentValue(totalEmployeesFuture.get().doubleValue()).build())
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
                .enrollmentTrend(
                        KpiMetric.builder().currentValue((double) nStudentService.countStudents(filter, orgId)).build())
                .genderDistribution(nStudentService.getGenderDistribution(filter, orgId))
                .studentsByStandard(nStudentService.getStudentsByStandardDistribution(filter, orgId))
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
