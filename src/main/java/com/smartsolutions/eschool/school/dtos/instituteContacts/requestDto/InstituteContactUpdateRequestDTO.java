package com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteContactUpdateRequestDTO {
    private String contactPersonName;
    private Long roleId;
    private String phone;
    private String email;
    private Boolean isPrimary;
}
