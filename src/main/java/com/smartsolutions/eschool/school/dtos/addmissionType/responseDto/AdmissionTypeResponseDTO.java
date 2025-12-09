package com.smartsolutions.eschool.school.dtos.addmissionType.responseDto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionTypeResponseDTO {
    private Long id;
    private String code;  // e.g., NEW_ADMISSION
    private String name;  // full display name
    private String description;
    private Boolean isActive = true;
    private boolean deleted = false;
}
