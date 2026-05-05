package com.smartsolutions.eschool.student.dtos.student.requestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentLoginDeactivationRequestDTO {

    @NotBlank(message = "Deactivation reason is required")
    private String reason;
}
