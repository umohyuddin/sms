package com.smartsolutions.eschool.student.dtos.requestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentFeeAssignmentRequestDTO {
    private Long id;
    private Long studentId;
    private Long campusId;
    private Long standardId;
    private Long academicYearId;
    private List<Long> componentIds;  // FeeComponent IDs
    private LocalDate dueDate;
    private LocalDate assignedDate;
}
