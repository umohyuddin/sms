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
@Schema(description = "Resource permission mapping")
public class UserResourcePermissionResponseDTO {
    @Schema(description = "ID of the resource", example = "1")
    private Long resourceId;

    @Schema(description = "Name of the resource", example = "Users")
    private String resourceName;

    @Schema(description = "List of permitted actions on this resource", example = "[\"CREATE\", \"VIEW\"]")
    private List<String> actions;
}
