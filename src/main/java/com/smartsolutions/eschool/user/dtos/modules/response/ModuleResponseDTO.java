package com.smartsolutions.eschool.user.dtos.modules.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModuleResponseDTO {

    private Long id;
    private String code;
    private String name;
    private String description;
    private String icon;
    private String route;
    private Integer displayOrder;
    private Boolean systemModule;
    private Boolean active;
    private Boolean deleted;

    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
}
