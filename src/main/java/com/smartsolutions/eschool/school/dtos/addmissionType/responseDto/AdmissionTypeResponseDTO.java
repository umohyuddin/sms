package com.smartsolutions.eschool.school.dtos.addmissionType.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Response object for admission type details")
public class AdmissionTypeResponseDTO {
    @Schema(description = "Unique ID", example = "1")
    private Long id;
    @Schema(description = "Admission type code", example = "NEW_ADMISSION")
    private String code;  // e.g., NEW_ADMISSION
    @Schema(description = "Display name", example = "New Admission")
    private String name;  // full display name
    @Schema(description = "Description", example = "Standard new student entry")
    private String description;
    @Builder.Default
    @Schema(description = "Active status", example = "true")
    private Boolean isActive = true;
    @Builder.Default
    @Schema(description = "Deletion flag", example = "false")
    private boolean deleted = false;
    @Schema(description = "System creation timestamp")
    private LocalDateTime createdAt;
    @Schema(description = "System update timestamp")
    private LocalDateTime updatedAt;
}
