package com.smartsolutions.eschool.student.dtos.student.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentDashboardDTO {
    private Long totalStudents;
    private Long totalMaleStudents;
    private Long totalFemaleStudents;
    private Long totalOtherStudents;
    private Map<String, Long> studentsByCampus;
    private Map<String, Long> studentsByStandard;
    private Map<String, Long> studentsBySection;
    private Long studentsRegisteredThisMonth;
}
