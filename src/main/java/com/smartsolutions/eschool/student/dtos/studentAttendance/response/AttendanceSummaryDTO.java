package com.smartsolutions.eschool.student.dtos.studentAttendance.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceSummaryDTO {

    private Long studentId;
    private String studentName; // optional, join with student table if needed
    private Long totalPresent;
    private Long totalAbsent;
    private Long totalLeave;
}
