package com.smartsolutions.eschool.user.dtos.rolepermissions.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolePermissionResponseDTO {
    private Long roleId;
    private Long permissionId;
    private String roleName;
    private String permissionName;

    private Long organizationId;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
}
