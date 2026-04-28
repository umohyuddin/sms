package com.smartsolutions.eschool.academic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamTermResponseDTO {
    private Long id;
    private String name;
    private Integer sequenceNo;
    private Long academicYearId;
    private String academicYearName;
    private boolean active;
}
