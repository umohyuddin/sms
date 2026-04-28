package com.smartsolutions.eschool.user.dtos.permissions.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermissionRequestDTO {
    @NotNull
    private Long organizationId;

    @NotBlank
    private String name;

    private String code;

    @NotNull
    private Long moduleId;

    @NotNull
    private Long resourceId;

    @NotNull
    private Long actionId;

    private String description;

    private Boolean systemPermission = false;

    private Boolean active = true;
}
