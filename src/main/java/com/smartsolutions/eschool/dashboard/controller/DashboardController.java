package com.smartsolutions.eschool.dashboard.controller;

import com.smartsolutions.eschool.dashboard.dtos.DashboardFilter;
import com.smartsolutions.eschool.dashboard.dtos.responses.*;
import com.smartsolutions.eschool.dashboard.facade.Dashboard360Facade;
import com.smartsolutions.eschool.global.error.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@Slf4j
@Tag(name = "360 Dashboard", description = "Performance and analytical dashboard for management.")
public class DashboardController {

    private final Dashboard360Facade nDashboardFacade;

    public DashboardController(Dashboard360Facade nDashboardFacade) {
        this.nDashboardFacade = nDashboardFacade;
    }

    @InitBinder
    public void initBinder(org.springframework.web.bind.WebDataBinder binder) {
        binder.registerCustomEditor(Long.class, new org.springframework.beans.propertyeditors.CustomNumberEditor(Long.class, true) {
            @Override
            public void setAsText(String text) {
                if (text == null || text.trim().isEmpty() || "null".equalsIgnoreCase(text.trim())) {
                    setValue(null);
                } else {
                    super.setAsText(text);
                }
            }
        });
    }

    @Operation(summary = "Get high-level KPI summary")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved KPI summary",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DashboardKpiResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/kpi", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DashboardKpiResponse> getKpi(
            @Parameter(description = "Dashboard universal filters") @ModelAttribute DashboardFilter filter) {
        filter.normalize();
        Long orgId = com.smartsolutions.eschool.util.SecurityUtils.getCurrentOrganizationId();
        log.info("[Controller:DashboardController] getKpi() called - tenantId={}, filters: {}", orgId, filter);
        
        if (orgId == null) {
            log.warn("[Controller:DashboardController] WARNING: organizationId is NULL for this request! Check SecurityContext/JWT.");
        }

        DashboardKpiResponse response = nDashboardFacade.getKpiSummary(filter);
        log.info("[Controller:DashboardController] getKpi() succeeded");
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get student analytics")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved student stats",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentDashboardResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDashboardResponse> getStudents(
            @Parameter(description = "Dashboard universal filters") @ModelAttribute DashboardFilter filter) {
        filter.normalize();
        log.info("[Controller:DashboardController] getStudents() called - Fetching student analytics");
        StudentDashboardResponse response = nDashboardFacade.getStudentStats(filter);
        log.info("[Controller:DashboardController] getStudents() succeeded");
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get finance analytics")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved finance stats",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FinanceDashboardResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/finance", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FinanceDashboardResponse> getFinance(
            @Parameter(description = "Dashboard universal filters") @ModelAttribute DashboardFilter filter) {
        filter.normalize();
        log.info("[Controller:DashboardController] getFinance() called - Fetching finance analytics");
        FinanceDashboardResponse response = nDashboardFacade.getFinanceStats(filter);
        log.info("[Controller:DashboardController] getFinance() succeeded");
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get HR analytics")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved HR stats",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = HrDashboardResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/hr", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HrDashboardResponse> getHr(
            @Parameter(description = "Dashboard universal filters") @ModelAttribute DashboardFilter filter) {
        filter.normalize();
        log.info("[Controller:DashboardController] getHr() called - Fetching HR analytics");
        HrDashboardResponse response = nDashboardFacade.getHrStats(filter);
        log.info("[Controller:DashboardController] getHr() succeeded");
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get system alerts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved alerts"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/alerts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<AlertResponse>> getAlerts(
            @Parameter(description = "Dashboard universal filters") @ModelAttribute DashboardFilter filter,
            Pageable pageable) {
        filter.normalize();
        log.info("[Controller:DashboardController] getAlerts() called");
        Page<AlertResponse> response = nDashboardFacade.getAlerts(filter, pageable);
        log.info("[Controller:DashboardController] getAlerts() succeeded - Found {} alerts", response.getTotalElements());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get recent activities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved activities"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/activity", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<ActivityResponse>> getActivity(
            @Parameter(description = "Dashboard universal filters") @ModelAttribute DashboardFilter filter,
            Pageable pageable) {
        filter.normalize();
        log.info("[Controller:DashboardController] getActivity() called");
        Page<ActivityResponse> response = nDashboardFacade.getActivity(filter, pageable);
        log.info("[Controller:DashboardController] getActivity() succeeded - Found {} activities", response.getTotalElements());
        return ResponseEntity.ok(response);
    }
}
