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

    @NotBlank
    private String resourceEndpoint;

    @NotBlank
    private String version;

    @NotNull
    private Boolean isActive;

    @NotBlank
    private String methodType;

    private String description;

    @NotNull
    private Boolean isAuthRequired;

    private Integer rateLimit;

    @NotNull
    private Boolean isDeprecated;

    private String documentationUrl;

    private String owner;
}
