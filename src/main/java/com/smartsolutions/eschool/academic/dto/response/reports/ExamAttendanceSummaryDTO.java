package com.smartsolutions.eschool.academic.dto.response.reports;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamAttendanceSummaryDTO {
    private Long groupId;
    private String groupName;

    private Long totalStudents;
    private Long presentCount;
    private Long absentCount;
    private Long ufmCount;
    private BigDecimal attendancePercentage;
}
