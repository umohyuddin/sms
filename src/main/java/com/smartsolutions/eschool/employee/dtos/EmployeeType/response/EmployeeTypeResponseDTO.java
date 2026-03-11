package com.smartsolutions.eschool.employee.dtos.EmployeeType.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeTypeResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Boolean active;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
