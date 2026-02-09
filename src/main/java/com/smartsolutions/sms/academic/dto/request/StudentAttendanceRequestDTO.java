package com.smartsolutions.sms.academic.dto.request;

import com.smartsolutions.sms.academic.entity.master.StudentAttendanceEntity;
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
    
    @NotNull
    private Long studentId;
    
    @NotNull
    private Long standardId;
    
    @NotNull
    private Long sectionId;
    
    @NotNull
    private LocalDate attendanceDate;
    
    @NotNull
    private StudentAttendanceEntity.AttendanceStatus status;
    
    private Long markedById;
    private String remarks;
}
