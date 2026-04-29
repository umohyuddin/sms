package com.smartsolutions.eschool.auth.dtos.auth.responseDto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.smartsolutions.eschool.user.model.SystemUserEntity;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Response object containing authentication details and JWT token")
public class LoginResponseDTO {
    @Schema(description = "ID of the organization the user belongs to", example = "101")
    private Long organizationId;

    @JsonProperty("access_token")
    @Schema(description = "JWT Access Token for subsequent requests", example = "eyJhbGciOiJIUzI1NiJ9...")
    private String accessToken;

    @JsonProperty("token_type")
    @Schema(description = "Type of the token", example = "Bearer")
    private String tokenType = "Bearer";

    @Schema(description = "Token expiration time in seconds", example = "3600")
    private Long expiresIn; // in seconds

    @Schema(description = "Unique identifier of the user", example = "user-123")
    private String userId;

    @Schema(description = "Registered email address", example = "admin@smartsolutions.com")
    private String email;

    @Schema(description = "Username", example = "admin")
    private String username;

    @Schema(description = "Type of the user (e.g., ADMIN, TEACHER, STUDENT)")
    private SystemUserEntity.UserType userType;

    @Schema(description = "Employee ID if the user is an employee", example = "50")
    private Long employeeId;

    @Schema(description = "Student ID if the user is a student", example = "500")
    private Long studentId;

    @Schema(description = "Employee code", example = "EMP001")
    private String employeeCode;

    @Schema(description = "Student code", example = "STU001")
    private String studentCode;
}
