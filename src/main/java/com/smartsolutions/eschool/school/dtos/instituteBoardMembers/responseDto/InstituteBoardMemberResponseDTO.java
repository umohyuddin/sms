package com.smartsolutions.eschool.school.dtos.instituteBoardMembers.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteBoardMemberResponseDTO {

    private Long id;
    private Long instituteId;
    private String fullName;
    private String role;
    private String email;
    private String contactNumber;
    private LocalDate termStart;
    private LocalDate termEnd;
    private Boolean isActive;
}
