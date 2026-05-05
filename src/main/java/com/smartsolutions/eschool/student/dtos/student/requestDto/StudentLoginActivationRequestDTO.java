package com.smartsolutions.eschool.student.dtos.student.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentLoginActivationRequestDTO {

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    private Boolean sendEmailNotification = true;
}
