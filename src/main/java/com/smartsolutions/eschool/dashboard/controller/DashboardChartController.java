package com.smartsolutions.eschool.dashboard.controller;

import com.smartsolutions.eschool.dashboard.dtos.DashboardFilter;
import com.smartsolutions.eschool.dashboard.dtos.charts.PieChartResponse;
import com.smartsolutions.eschool.dashboard.dtos.charts.TimeSeriesChartResponse;
import com.smartsolutions.eschool.dashboard.facade.DashboardChartFacade;
import com.smartsolutions.eschool.global.error.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard/charts")
@Slf4j
@Tag(name = "Dashboard Chart Analytics", description = "Endpoints for fetching chart-ready aggregated data.")
public class DashboardChartController {

    private final DashboardChartFacade nChartFacade;

    public DashboardChartController(DashboardChartFacade nChartFacade) {
        this.nChartFacade = nChartFacade;
    }

    @Operation(summary = "Get admissions trend data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved admissions trend",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TimeSeriesChartResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/admissions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TimeSeriesChartResponse> getAdmissions(
            @Parameter(description = "Dashboard filters") @ModelAttribute DashboardFilter filter) {
        log.info("[Controller:DashboardChartController] getAdmissions() called");
        TimeSeriesChartResponse response = nChartFacade.getAdmissionsTrend(filter);
        log.info("[Controller:DashboardChartController] getAdmissions() succeeded");
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get revenue trend data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved revenue trend",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TimeSeriesChartResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/revenue", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TimeSeriesChartResponse> getRevenue(
            @Parameter(description = "Dashboard filters") @ModelAttribute DashboardFilter filter) {
        log.info("[Controller:DashboardChartController] getRevenue() called");
        TimeSeriesChartResponse response = nChartFacade.getRevenueTrend(filter);
        log.info("[Controller:DashboardChartController] getRevenue() succeeded");
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get gender distribution data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved gender distribution",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PieChartResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/gender-distribution", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PieChartResponse> getGenderDistribution(
            @Parameter(description = "Dashboard filters") @ModelAttribute DashboardFilter filter) {
        log.info("[Controller:DashboardChartController] getGenderDistribution() called");
        PieChartResponse response = nChartFacade.getGenderDistribution(filter);
        log.info("[Controller:DashboardChartController] getGenderDistribution() succeeded");
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get fee status distribution data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved fee status distribution",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PieChartResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/fee-status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PieChartResponse> getFeeStatus(
            @Parameter(description = "Dashboard filters") @ModelAttribute DashboardFilter filter) {
        log.info("[Controller:DashboardChartController] getFeeStatus() called");
        PieChartResponse response = nChartFacade.getFeeStatusDistribution(filter);
        log.info("[Controller:DashboardChartController] getFeeStatus() succeeded");
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get class strength data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved class strength",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TimeSeriesChartResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/class-strength", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TimeSeriesChartResponse> getClassStrength(
            @Parameter(description = "Dashboard filters") @ModelAttribute DashboardFilter filter) {
        log.info("[Controller:DashboardChartController] getClassStrength() called");
        TimeSeriesChartResponse response = nChartFacade.getClassStrength(filter);
        log.info("[Controller:DashboardChartController] getClassStrength() succeeded");
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get campus collection data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved campus collection",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PieChartResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/campus-collection", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PieChartResponse> getCampusCollection(
            @Parameter(description = "Dashboard filters") @ModelAttribute DashboardFilter filter) {
        log.info("[Controller:DashboardChartController] getCampusCollection() called");
        PieChartResponse response = nChartFacade.getCampusCollection(filter);
        log.info("[Controller:DashboardChartController] getCampusCollection() succeeded");
        return ResponseEntity.ok(response);
    }
}
