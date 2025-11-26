package com.smartsolutions.eschool.student.dtos.responseDto.byStudentId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeeAssignmentDTO {
    private Long feeRateId;
    private Long componentId;
    private String componentName;
    private Double amount;
    private LocalDate assignedDate;
    private LocalDate dueDate;
}
