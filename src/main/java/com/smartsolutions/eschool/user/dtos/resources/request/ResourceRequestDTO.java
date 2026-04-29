package com.smartsolutions.eschool.user.dtos.resources.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceRequestDTO {
    @NotBlank
    private String resourceName;

    @NotNull
    private Long moduleId;

    @NotBlank
    private String version;

    @NotNull
    private Boolean isActive;

    private String description;

    @NotNull
    private Boolean isAuthRequired;

    private Integer rateLimit;

    private Boolean isDeprecated;

    private String documentationUrl;

    private String owner;
}
