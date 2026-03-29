package com.smartsolutions.eschool.student.dtos.attendance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceReportDTO {
    private String level; // ORGANIZATION, CAMPUS, STANDARD, SECTION
    private Long levelId;
    private String levelName;
    
    private long totalPresent;
    private long totalAbsent;
    private long totalLeave;
    private long totalStudents;
    
    private double presentPercentage;
    private double absentPercentage;
    private double leavePercentage;
    
    private List<AttendanceSummaryDTO> details;
}
