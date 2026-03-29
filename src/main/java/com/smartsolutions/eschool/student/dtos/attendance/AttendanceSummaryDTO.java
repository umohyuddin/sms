package com.smartsolutions.eschool.student.dtos.attendance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceSummaryDTO {
    private Long id;
    private String name;
    private long presentCount;
    private long absentCount;
    private long leaveCount;
    private long totalCount;
    private double attendancePercentage;
}
