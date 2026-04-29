package com.smartsolutions.eschool.school.dtos.departments.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Response object containing department information")
public class DepartmentResponseDTO {

    @Schema(description = "Unique identifier of the department", example = "1")
    private Long id;

    @Schema(description = "Organization ID", example = "1")
    private Long organizationId;

    @Schema(description = "ID of the associated campus", example = "1")
    private Long campusId;

    @Schema(description = "Name of the associated campus", example = "Main Campus")
    private String campusName;

    @Schema(description = "ID of the department type", example = "1")
    private Long departmentTypeId;

    @Schema(description = "Name of the department type", example = "Academic")
    private String departmentTypeName;

    @Schema(description = "Unique code for the department", example = "HR-001")
    private String departmentCode;

    @Schema(description = "Name of the department", example = "Human Resources")
    private String departmentName;

    @Schema(description = "Description of the department", example = "Manages personnel and recruitment")
    private String description;

    @Schema(description = "ID of the parent department", example = "1")
    private Long parentId;

    @Schema(description = "Name of the parent department", example = "Administration")
    private String parentName;

    @Schema(description = "ID of the head employee", example = "101")
    private Long headEmployeeId;

    @Schema(description = "Name of the head employee", example = "John Doe")
    private String headEmployeeName;

    @Schema(description = "Status indicating if the department is active", example = "true")
    private Boolean active;

    @Schema(description = "Timestamp when the record was created")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the record was last updated")
    private LocalDateTime updatedAt;

    @Schema(description = "Indicates if the record is soft-deleted", example = "false")
    private Boolean deleted;
}
