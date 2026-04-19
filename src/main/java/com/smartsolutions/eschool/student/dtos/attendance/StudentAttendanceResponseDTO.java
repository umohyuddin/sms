package com.smartsolutions.eschool.student.dtos.attendance;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Response object for student attendance details")
public class StudentAttendanceResponseDTO {
    @Schema(description = "Unique identifier of the attendance record", example = "1001")
    private Long id;

    @Schema(description = "ID of the organization", example = "101")
    private Long organizationId;

    @Schema(description = "ID of the campus", example = "1")
    private Long campusId;

    @Schema(description = "Name of the campus", example = "Main Campus")
    private String campusName;
    
    @Schema(description = "ID of the student", example = "500")
    private Long studentId;

    @Schema(description = "Full name of the student", example = "Arslan Khan Ahmed")
    private String studentName;

    @Schema(description = "Unique admission code of the student", example = "STU-2024-001")
    private String studentCode;
    
    @Schema(description = "ID of the academic standard", example = "5")
    private Long standardId;

    @Schema(description = "Name of the academic standard", example = "Class 5")
    private String standardName;
    
    @Schema(description = "ID of the section", example = "1")
    private Long sectionId;

    @Schema(description = "Name of the section", example = "Section A")
    private String sectionName;
    
    @Schema(description = "Date of attendance", example = "2024-04-19")
    private LocalDate attendanceDate;

    @Schema(description = "Attendance status", example = "PRESENT")
    private String status;
    
    @Schema(description = "ID of the user who marked the attendance", example = "10")
    private Long markedById;

    @Schema(description = "Name of the user who marked the attendance", example = "Ms. Sarah")
    private String markedByName;
    
    @Schema(description = "Optional remarks", example = "Medical leave")
    private String remarks;
    
    @Schema(description = "Timestamp when the record was created")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the record was last updated")
    private LocalDateTime updatedAt;

    @Schema(description = "Indicates if the record is soft-deleted", example = "false")
    private boolean deleted;
}
