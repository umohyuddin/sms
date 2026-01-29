package com.smartsolutions.eschool.school.dtos.subjects.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectRequest {

    @NotBlank(message = "Subject code is required")
    private String code;

    @NotBlank(message = "Subject name is required")
    private String name;

    private String description;
    private Boolean isCore;
    private Boolean active;
}
