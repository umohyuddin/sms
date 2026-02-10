package com.smartsolutions.eschool.academic.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRequestDTO {
    private Long id;
    
    @NotBlank(message = "Code is mandatory")
    private String code;
    
    @NotBlank(message = "Name is mandatory")
    private String name;
    
    private String description;
    private boolean core = true;
    private Long subjectGroupId;
    private boolean active = true;
}
