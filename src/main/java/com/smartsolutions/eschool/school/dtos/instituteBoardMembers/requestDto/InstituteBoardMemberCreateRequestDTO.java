package com.smartsolutions.eschool.school.dtos.instituteBoardMembers.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteBoardMemberCreateRequestDTO {
    private Long instituteId;
    private Long roleId;
    private String fullName;
    private String email;
    private String contactNumber;
    private LocalDate termStart;
    private LocalDate termEnd;
    private Boolean isActive;
}
