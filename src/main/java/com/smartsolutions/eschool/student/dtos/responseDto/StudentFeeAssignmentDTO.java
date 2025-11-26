package com.smartsolutions.eschool.student.dtos.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentFeeAssignmentDTO {
    private Long id;

    // Student info
    private Long studentId;
    private String fullName;
    private  String firstName;
    private  String lastName;

    // Fee rate info
    private Long feeRateId;
    private Long componentId;
    private String componentName;
    private Double amount;

    // Dates
    private LocalDate assignedDate;
    private LocalDate dueDate;

}
