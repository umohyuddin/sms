package com.smartsolutions.eschool.student.dtos.studentAttendance.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DailyAttendanceReportDTO {

    private Long studentId;
    private String studentName; // optional
    private LocalDate date;
    private String status; // PRESENT, ABSENT, LEAVE
    private String remarks;
}