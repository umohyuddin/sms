package com.smartsolutions.eschool.user.dtos.permissions.response;

import com.smartsolutions.eschool.user.dtos.modules.response.ModuleResponseDTO;
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
    private Long organizationId;
    private String name;
    private String code;
    private ModuleResponseDTO module;
    private String description;
    private Boolean systemPermission;
    private Boolean active;
    private Boolean deleted;

    private java.time.LocalDateTime createdAt;
    private Long createdBy;
    private java.time.LocalDateTime updatedAt;
    private Long updatedBy;
}
