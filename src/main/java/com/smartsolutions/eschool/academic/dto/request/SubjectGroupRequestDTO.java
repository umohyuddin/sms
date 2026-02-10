package com.smartsolutions.eschool.academic.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectGroupRequestDTO {
    private Long id;
    private String code;
    
    @NotBlank(message = "Name is mandatory")
    private String name;
    
    private boolean active = true;
}
