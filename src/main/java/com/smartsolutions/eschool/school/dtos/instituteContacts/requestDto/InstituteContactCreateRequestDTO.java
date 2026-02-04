package com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteContactCreateRequestDTO {
    @NotNull
    private Long instituteId;

    private String contactPersonName;
    private Long roleId;
    private String phone;
    private String email;
    private Boolean isPrimary;
}
