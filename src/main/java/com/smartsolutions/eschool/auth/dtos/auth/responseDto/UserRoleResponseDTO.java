package com.smartsolutions.eschool.auth.dtos.auth.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Role assigned to the user")
public class UserRoleResponseDTO {
    @Schema(description = "ID of the role", example = "1")
    private Long roleId;

    @Schema(description = "Name of the role", example = "Super Admin")
    private String roleName;
}
