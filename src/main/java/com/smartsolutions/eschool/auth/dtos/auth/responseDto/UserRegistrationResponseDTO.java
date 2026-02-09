package com.smartsolutions.eschool.auth.dtos.auth.responseDto;

import com.smartsolutions.eschool.user.model.SystemUserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationResponseDTO {
    private Long userId;
    private String username;
    private String email;
    private String phone;
    private SystemUserEntity.UserType userType;
    private Long employeeId;
    private Long studentId;
    private String employeeCode;
    private String studentCode;
    private Boolean isActive;
    private Boolean isVerified;
    private String message;
}
