package com.smartsolutions.eschool.school.dtos.boardMemberRoles.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request object for creating or updating a board member role")
public class BoardMemberRoleRequestDTO {
    
    @Schema(description = "Unique identifier of the board member role", example = "1")
    private Long id;

    @Schema(description = "ID of the associated organization", example = "1")
    private Long organizationId;

    @NotNull(message = "Code is required")
    @Size(max = 50, message = "Code must be at most 50 characters")
    @Schema(description = "Unique code for the role", example = "CHAIRMAN")
    private String code;

    @NotNull(message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    @Schema(description = "Name of the role", example = "Board Chairman")
    private String name;

    @Schema(description = "Flag to indicate if the role is active", example = "true")
    private boolean active = true;
}
