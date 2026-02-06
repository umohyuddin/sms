package com.smartsolutions.eschool.user.dtos.permissions.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermissionRequestDTO {
    @jakarta.validation.constraints.NotNull
    private Long organizationId;

    @NotBlank
    private String name;

    @NotBlank
    private String code;

    @jakarta.validation.constraints.NotNull
    private Long moduleId;

    private String description;

    private Boolean systemPermission = false;

    private Boolean active = true;
}
