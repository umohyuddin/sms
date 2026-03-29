package com.smartsolutions.eschool.student.dtos.attendance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentAttendanceResponseDTO {
    private Long id;
    private Long organizationId;
    private Long campusId;
    private String campusName;
    
    private Long studentId;
    private String studentName;
    private String studentCode;
    
    private Long standardId;
    private String standardName;
    
    private Long sectionId;
    private String sectionName;
    
    private LocalDate attendanceDate;
    private String status;
    
    private Long markedById;
    private String markedByName;
    
    private String remarks;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted;
}
