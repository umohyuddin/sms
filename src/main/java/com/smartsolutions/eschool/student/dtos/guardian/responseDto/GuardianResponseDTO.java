package com.smartsolutions.eschool.student.dtos.guardian.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuardianResponseDTO {
    private Long id;
    private Long campusId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    private Long relationId;
    private String cnic;
    private String phone;
    private String alternatePhone;
    private String email;
    private String occupation;
    private String organization;
    private String address;
    @Builder.Default
    private Boolean isActive = true;
    private String status;
    @Builder.Default
    private boolean deleted = false;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
