package com.smartsolutions.eschool.academic.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamTermRequestDTO {
    private Long id;
    
    @NotBlank(message = "Name is mandatory")
    private String name;
    
    @NotNull(message = "Sequence number is mandatory")
    private Integer sequenceNo;
    
    @NotNull(message = "Academic year is mandatory")
    private Long academicYearId;
    
    private boolean active = true;
}
