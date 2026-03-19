package com.smartsolutions.eschool.student.dtos.guardianRelation.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuardianRelationResponseDTO {
    private Long id;
    private String code;
    private String name;
    private String description;
    private Boolean isActive = true;
    private Boolean isDefault = false;
    private String status;
    private boolean deleted = false;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
