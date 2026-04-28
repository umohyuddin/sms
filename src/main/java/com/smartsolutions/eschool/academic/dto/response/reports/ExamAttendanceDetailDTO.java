package com.smartsolutions.eschool.academic.dto.response.reports;

import com.smartsolutions.eschool.academic.entity.mapping.StudentExamAttendanceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamAttendanceDetailDTO {
    private Long attendanceId;
    private Long studentId;
    private String studentName;
    private String studentCode;
    private String campusName;
    private String standardName;
    private String sectionName;
    private String subjectName;
    private LocalDate examDate;
    private StudentExamAttendanceEntity.AttendanceStatus status;
}
