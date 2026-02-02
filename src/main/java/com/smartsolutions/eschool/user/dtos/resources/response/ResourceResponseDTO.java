package com.smartsolutions.eschool.user.dtos.resources.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceResponseDTO {
    private Long id;
    private String resourceName;
    private String resourceEndpoint;
    private String version;
    private Boolean isActive;
    private String methodType;
    private String description;
    private Boolean isAuthRequired;
    private Integer rateLimit;
    private Boolean isDeprecated;
    private String documentationUrl;
    private String owner;
}
