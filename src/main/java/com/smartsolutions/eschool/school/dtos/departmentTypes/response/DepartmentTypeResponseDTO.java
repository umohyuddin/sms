package com.smartsolutions.eschool.school.dtos.departmentTypes.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Response object containing department type information")
public class DepartmentTypeResponseDTO {
    @Schema(description = "Unique identifier of the department type", example = "1")
    private Long id;

    @Schema(description = "Organization ID", example = "1")
    private Long organizationId;

    @Schema(description = "Unique code for the department type", example = "ACADEMIC")
    private String code;

    @Schema(description = "Name of the department type", example = "Academic")
    private String name;

    @Schema(description = "Description of the department type", example = "Core teaching and subject-related departments")
    private String description;

    @Schema(description = "Status indicating if the department type is active", example = "true")
    private boolean active;

    @Schema(description = "Indicates if the record is soft-deleted", example = "false")
    private boolean deleted;

    @Schema(description = "Timestamp when the record was created")
    private java.time.LocalDateTime createdAt;

    @Schema(description = "Timestamp when the record was last updated")
    private java.time.LocalDateTime updatedAt;
}
