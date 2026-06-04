package com.smartsolutions.eschool.student.dtos.admissionType.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request object for maintaining admission types")
public class AdmissionTypeCreateRequestDTO {
    @Schema(description = "Unique ID for updates", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "Unique code for the admission type", example = "GEN_ADMISSION")
    private String code;

    @NotNull
    @Schema(description = "Display name", example = "General Admission")
    private String name;

    @Schema(description = "Detailed description", example = "Standard admission for regular students")
    private String description;

    @Schema(description = "Active status", example = "true")
    private Boolean isActive = true;
}
