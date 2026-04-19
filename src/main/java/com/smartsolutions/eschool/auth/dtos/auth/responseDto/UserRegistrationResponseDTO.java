package com.smartsolutions.eschool.auth.dtos.auth.responseDto;

import com.smartsolutions.eschool.user.model.SystemUserEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response object containing registered user details")
public class UserRegistrationResponseDTO {
    @Schema(description = "Unique identifier of the newly created user", example = "1")
    private Long userId;

    @Schema(description = "Registered username", example = "j.doe")
    private String username;

    @Schema(description = "Registered email address", example = "j.doe@example.com")
    private String email;

    @Schema(description = "Contact phone number", example = "+923001234567")
    private String phone;

    @Schema(description = "Type of the user (e.g., ADMIN, TEACHER, STUDENT)")
    private SystemUserEntity.UserType userType;

    @Schema(description = "Employee ID if registered as an employee", example = "50")
    private Long employeeId;

    @Schema(description = "Student ID if registered as a student", example = "500")
    private Long studentId;

    @Schema(description = "Unique employee code", example = "EMP-001")
    private String employeeCode;

    @Schema(description = "Unique student code", example = "STU-001")
    private String studentCode;

    @Schema(description = "Account activation status", example = "true")
    private Boolean isActive;

    @Schema(description = "Email verification status", example = "false")
    private Boolean isVerified;

    @Schema(description = "Success or status message", example = "Student registered successfully")
    private String message;
}
