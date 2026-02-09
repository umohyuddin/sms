package com.smartsolutions.sms.academic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResponseDTO {
    private Long id;
    private String code;
    private String name;
    private String description;
    private boolean core;
    private Long subjectGroupId;
    private String subjectGroupName;
    private boolean active;
}
