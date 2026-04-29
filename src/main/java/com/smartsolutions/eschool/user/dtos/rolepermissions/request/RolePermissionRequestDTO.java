package com.smartsolutions.eschool.user.dtos.rolepermissions.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolePermissionRequestDTO {
    private Long roleId;
    private List<Long> permissionIds;
}
