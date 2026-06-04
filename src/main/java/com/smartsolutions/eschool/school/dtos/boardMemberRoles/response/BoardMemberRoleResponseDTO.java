package com.smartsolutions.eschool.school.dtos.boardMemberRoles.response;

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
@Schema(description = "Response object for board member role details")
public class BoardMemberRoleResponseDTO {

    @Schema(description = "Unique identifier of the board member role", example = "1")
    private Long id;

    @Schema(description = "ID of the associated organization", example = "1")
    private Long organizationId;

    @Schema(description = "Name of the associated organization", example = "Smart Academy")
    private String organizationName;

    @Schema(description = "Unique code for the role", example = "CHAIRMAN")
    private String code;

    @Schema(description = "Name of the role", example = "Board Chairman")
    private String name;

    @Schema(description = "Flag to indicate if the role is active", example = "true")
    private boolean active;

    @Schema(description = "Timestamp when the record was created")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the record was last updated")
    private LocalDateTime updatedAt;
}
