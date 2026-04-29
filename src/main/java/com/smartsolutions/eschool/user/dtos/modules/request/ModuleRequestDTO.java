package com.smartsolutions.eschool.user.dtos.modules.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModuleRequestDTO {
    @NotBlank(message = "Module code is required")
    @Size(max = 50, message = "Code must be at most 50 characters")
    private String code;

    @NotBlank(message = "Module name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @Size(max = 255, message = "Description must be at most 255 characters")
    private String description;

    @Size(max = 50, message = "Icon must be at most 50 characters")
    private String icon;

    @Size(max = 100, message = "Route must be at most 100 characters")
    private String route;

    private Integer displayOrder;

    private Boolean systemModule = true;

    private Boolean active = true;
}
