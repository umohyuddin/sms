package com.smartsolutions.eschool.school.dtos.instituteContacts.responseDto;

import com.smartsolutions.eschool.user.dtos.roles.response.RoleResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteContactResponseDTO {
    private Long id;
    private Long instituteId;
    private String contactPersonName;
    private RoleResponseDTO role;
    private String phone;
    private String email;
    private Boolean isPrimary;
}
