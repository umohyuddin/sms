package com.smartsolutions.eschool.student.dtos.student.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
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
@Schema(description = "Request object for updating basic profile information of a student")
public class StudentBasicInfoUpdateDTO {

    @NotBlank(message = "First name is required")
    @Schema(description = "First name of the student", example = "Arslan")
    private String firstName;

    @Schema(description = "Middle name of the student", example = "Khan")
    private String middleName;

    @NotBlank(message = "Last name is required")
    @Schema(description = "Last name of the student", example = "Ahmed")
    private String lastName;

    @NotBlank(message = "Full name is required")
    @Schema(description = "Full name of the student", example = "Arslan Khan Ahmed")
    private String fullName;

    @NotNull(message = "Date of birth is required")
    @Schema(description = "Date of birth", example = "2015-05-15")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Gender is required")
    @Schema(description = "Gender", example = "Male")
    private String gender;

    @Schema(description = "National ID or B-Form number", example = "61101-1234567-1")
    private String cnic;

    @Schema(description = "Passport number (optional)", example = "PK1234567")
    private String passportNumber;

    @NotBlank(message = "Phone is required")
    @Schema(description = "Contact phone number", example = "+923001234567")
    private String phone;

    @Email(message = "Invalid email format")
    @Schema(description = "Email address", example = "arslan.ahmed@example.com")
    private String email;

    @Schema(description = "Religion", example = "Islam")
    private String religion;

    @Schema(description = "Nationality", example = "Pakistani")
    private String nationality;

    @Schema(description = "Blood group", example = "O+")
    private String bloodGroup;
}