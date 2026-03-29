package com.smartsolutions.eschool.student.dtos.attendance;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentAttendanceRequestDTO {
    private Long id;
    private Long organizationId;
    @NotNull(message = "Campus ID is required")
    private Long campusId;
    
    @NotNull(message = "Student ID is required")
    private Long studentId;
    
    @NotNull(message = "Standard ID is required")
    private Long standardId;
    
    @NotNull(message = "Section ID is required")
    private Long sectionId;
    
    @NotNull(message = "Attendance date is required")
    private LocalDate attendanceDate;
    
    @NotNull(message = "Status is required")
    private String status; // PRESENT, ABSENT, LEAVE
    
    private Long markedById;
    private String remarks;
}
