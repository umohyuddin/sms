package com.smartsolutions.eschool.user.dtos.roles.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequestDTO {
    @NotNull
    private Long organizationId;

    @NotBlank
    @Size(max = 50)
    private String code;          // TEACHER, STUDENT

    @NotBlank
    @Size(max = 100)
    private String name;          // Teacher, Student

    @Size(max = 255)
    private String description;

    private Boolean systemRole = false;

    private Boolean active = true;
}
