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
public class StudentAttendanceDTO {
    private Long id;
    private Long studentId;
    private Long standardId;
    private Long sectionId;
    private LocalDate attendanceDate;
    private String status; // PRESENT / ABSENT / LEAVE
    private Long markedBy;
    private String remarks;
}
