package com.smartsolutions.eschool.user.dtos.permissions.response;

import com.smartsolutions.eschool.user.dtos.modules.response.ModuleResponseDTO;
import com.smartsolutions.eschool.user.dtos.resources.response.ResourceResponseDTO;
import com.smartsolutions.eschool.user.dtos.actions.response.ActionResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

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
    private ResourceResponseDTO resource;
    private ActionResponseDTO action;
    private String description;
    private Boolean systemPermission;
    private Boolean active;
    private Boolean deleted;

    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
}
