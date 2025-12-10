package com.smartsolutions.eschool.student.dtos.student;

import java.util.Map;

public class StudentDashboardDTO {
    private Long totalStudents;
    private Long totalMaleStudents;
    private Long totalFemaleStudents;
    private Map<String, Long> studentsByCampus;
    private Map<String, Long> studentsByStandard;
    private Map<String, Long> studentsBySection;
}
