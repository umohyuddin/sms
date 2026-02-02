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
    @NotBlank
    private String permissionName;
    private String code;
    private String module;
    private String description;
}
