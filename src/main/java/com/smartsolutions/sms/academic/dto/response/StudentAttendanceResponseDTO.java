package com.smartsolutions.sms.academic.dto.response;

import com.smartsolutions.sms.academic.entity.master.StudentAttendanceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentAttendanceResponseDTO {
    private Long id;
    private Long studentId;
    private String studentName;
    private Long standardId;
    private String standardName;
    private Long sectionId;
    private String sectionName;
    private LocalDate attendanceDate;
    private StudentAttendanceEntity.AttendanceStatus status;
    private String markedBy;
    private String remarks;
}
