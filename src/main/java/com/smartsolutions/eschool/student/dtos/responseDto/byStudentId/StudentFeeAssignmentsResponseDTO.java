package com.smartsolutions.eschool.student.dtos.responseDto.byStudentId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentFeeAssignmentsResponseDTO {
    private Long studentId;
    private String fullName;
    private String firstName;
    private String lastName;
    private List<FeeAssignmentDTO> feeAssignments;

}
