package com.smartsolutions.eschool.school.dtos.addmissionType.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdmissionTypeResponseDTO {
    private Long id;
    private String code;  // e.g., NEW_ADMISSION
    private String name;  // full display name
    private String description;
    private Boolean isActive = true;
    private boolean deleted = false;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
