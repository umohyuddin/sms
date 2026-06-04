package com.smartsolutions.eschool.student.dtos.studentAttendance.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response object to check if attendance exists for a student on a specific date")
public class AttendanceCheckDTO {
    @Schema(description = "ID of the student", example = "500")
    private Long studentId;

    @Schema(description = "Date of attendance check", example = "2024-04-19")
    private LocalDate attendanceDate;

    @Schema(description = "Indicates if an attendance record already exists", example = "true")
    private boolean exists;
}
