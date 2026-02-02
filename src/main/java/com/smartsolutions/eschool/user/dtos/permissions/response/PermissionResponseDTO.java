package com.smartsolutions.eschool.user.dtos.permissions.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermissionResponseDTO {
    private Long id;
    private String permissionName;
    private String code;
    private String module;
    private String description;
}
