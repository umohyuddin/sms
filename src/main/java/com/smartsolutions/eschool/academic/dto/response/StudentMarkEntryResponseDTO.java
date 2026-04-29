package com.smartsolutions.eschool.academic.dto.response;

import com.smartsolutions.eschool.academic.entity.mapping.StudentExamAttendanceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentMarkEntryResponseDTO {
    private Long studentId;
    private String studentName;
    private String studentCode;
    private StudentExamAttendanceEntity.AttendanceStatus attendanceStatus;
    private BigDecimal obtainedMarks;
    private BigDecimal graceMarks;
    private boolean locked;
    private String remarks;
    private Long markId; // Included if existing mark entity needs update
}
