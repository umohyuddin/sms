package com.smartsolutions.eschool.student.dtos.feeCatalogComponent.requestDto;

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
public class FeeCatalogComponentRequestDTO {
    private Long id;   // Optional (only for Update)

    private Long feeCatalogId;

    @NotBlank(message = "Name is required")
    private String componentName;

    @NotBlank(message = "Code is required")
    private String componentCode;

    private String description;

    @NotNull(message = "Active flag is required")
    private Boolean active;

}
