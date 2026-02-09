package com.smartsolutions.eschool.auth.dtos.auth.responseDto;


import com.smartsolutions.eschool.user.model.SystemUserEntity;
import jakarta.validation.constraints.NotBlank;
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
public class LoginResponseDTO {
    private Long organizationId;
    private String accessToken;
    private String tokenType = "Bearer";
    private Long expiresIn; // in seconds
    private String userId;
    private String email;
    private String username;
    private SystemUserEntity.UserType userType;
    private Long employeeId;
    private Long studentId;
    private String employeeCode;
    private String studentCode;
//    private List<String> roles;
}
