package com.smartsolutions.eschool.auth.dtos.auth.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Module permission mapping")
public class UserModulePermissionResponseDTO {
    @Schema(description = "ID of the module", example = "1")
    private Long moduleId;

    @Schema(description = "Name of the module", example = "Administration")
    private String moduleName;

    @Schema(description = "List of resource permissions under this module")
    private List<UserResourcePermissionResponseDTO> resources;
}
