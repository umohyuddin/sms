package com.smartsolutions.eschool.dashboard.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardFilter {
    private Long tenantId;
    private List<Long> campusIds;
    private Long academicYearId;
    @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
    private LocalDate fromDate;
    @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
    private LocalDate toDate;
    private Long standardId;
    private Long sectionId;
    private String academicYear;
    private com.smartsolutions.eschool.dashboard.dtos.enums.GroupBy groupBy;

    public void normalize() {
        if (campusIds != null && campusIds.isEmpty()) {
            campusIds = null;
        }
    }
}
