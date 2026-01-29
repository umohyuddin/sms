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
public class AttendanceCheckDTO {
    private Long studentId;
    private LocalDate attendanceDate;
    private boolean exists;
}
