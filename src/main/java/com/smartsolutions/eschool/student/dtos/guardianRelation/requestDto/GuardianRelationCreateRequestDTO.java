package com.smartsolutions.eschool.student.dtos.guardianRelation.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuardianRelationCreateRequestDTO {
    private Long id;

    @NotNull
    private String code;

    @NotNull
    private String name;

    private String description;

    private Boolean isActive = true;

    private Boolean isDefault = false;

    private String status = "ACTIVE";
}
