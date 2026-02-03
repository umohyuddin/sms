package com.smartsolutions.eschool.user.dtos.roles.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponseDTO {

    private Long id;

    private Long organizationId;

    private String code;

    private String name;

    private String description;

    private Boolean systemRole;

    private Boolean active;

    private Boolean deleted;

    private LocalDateTime createdAt;

    private Long createdBy;

    private LocalDateTime updatedAt;

    private Long updatedBy;
}