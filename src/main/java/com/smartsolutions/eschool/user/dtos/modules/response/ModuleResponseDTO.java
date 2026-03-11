package com.smartsolutions.eschool.user.dtos.modules.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
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
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
