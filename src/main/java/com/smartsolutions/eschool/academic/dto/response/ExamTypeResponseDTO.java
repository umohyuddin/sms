package com.smartsolutions.eschool.academic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamTypeResponseDTO {
    private Long id;
    private String code;
    private String name;
    private boolean active;
    private String description;
}
