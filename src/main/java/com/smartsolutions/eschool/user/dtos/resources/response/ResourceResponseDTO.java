package com.smartsolutions.eschool.user.dtos.resources.response;

import com.smartsolutions.eschool.user.dtos.modules.response.ModuleResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceResponseDTO {
    private Long id;
    private String resourceName;
    private ModuleResponseDTO module;
    private String version;
    private Boolean isActive;
    private String description;
    private Boolean isAuthRequired;
    private Integer rateLimit;
    private Boolean isDeprecated;
    private String documentationUrl;
    private String owner;
    private Boolean deleted;

    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
}
