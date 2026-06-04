package com.smartsolutions.eschool.auth.dtos.auth.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request object for employee self-registration")
public class EmployeeRegistrationRequestDTO {
    
    @NotNull(message = "Employee ID is required")
    @Schema(description = "Existing employee ID associated with the user", example = "50")
    private Long employeeId;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Schema(description = "User's official email address", example = "employee@smartsolutions.com")
    private String email;
    
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Schema(description = "Desired login username", example = "j.doe")
    private String username;
    
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    @Schema(description = "Secure password for the account", example = "StrongPass@123")
    private String password;
    
    @Schema(description = "User's contact phone number", example = "+923001122334")
    private String phone;
}
