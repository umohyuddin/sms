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
public class ClassAttendanceReportDTO {

    private Long standardId;
    private Long sectionId;
    private LocalDate date;
    private Long presentCount;
    private Long absentCount;
    private Long leaveCount;
}
