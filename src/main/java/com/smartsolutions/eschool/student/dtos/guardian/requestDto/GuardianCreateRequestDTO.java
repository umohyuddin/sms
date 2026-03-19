package com.smartsolutions.eschool.student.dtos.guardian.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuardianCreateRequestDTO {
    private Long id;

    private Long campusId;

    @NotNull
    private String firstName;

    private String middleName;

    @NotNull
    private String lastName;

    @NotNull
    private String fullName;

    @NotNull
    private Long relationId;

    @NotNull
    private String cnic;

    @NotNull
    private String phone;

    private String alternatePhone;

    private String email;

    private String occupation;

    private String organization;

    private String address;

    private Boolean isActive = true;

    private String status;

    private Long studentId;
}
