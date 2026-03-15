package com.smartsolutions.eschool.student.dtos.feeSlabGroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeeSlabGroupResponseDTO {
    private Long id;
    private Long feeComponentId;
    private String feeComponentName;
    private String code;
    private String name;
    private String description;
    private boolean active;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
