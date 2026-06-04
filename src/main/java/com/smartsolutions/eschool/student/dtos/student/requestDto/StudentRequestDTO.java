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
@Schema(description = "Request object for creating or updating a student profile")
public class StudentRequestDTO {

    @NotNull(message = "Campus ID is required")
    @Schema(description = "ID of the campus", example = "1")
    private Long campusId;

    @NotNull(message = "Standard ID is required")
    @Schema(description = "ID of the academic standard (class)", example = "5")
    private Long standardId;

    @NotNull(message = "Section ID is required")
    @Schema(description = "ID of the section", example = "1")
    private Long sectionId;

    @NotNull(message = "Admission Type ID is required")
    @Schema(description = "ID of the admission type", example = "2")
    private Long admissionTypeId;

    @NotBlank(message = "First name is required")
    @Schema(description = "First name of the student", example = "Arslan")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Schema(description = "Last name of the student", example = "Ahmed")
    private String lastName;

    @Schema(description = "Middle name of the student", example = "Khan")
    private String middleName;

    @NotBlank(message = "Full name is required")
    @Schema(description = "Full name of the student", example = "Arslan Khan Ahmed")
    private String fullName;

    @Schema(description = "Unique admission code (auto-generated if empty)", example = "STU-2024-001")
    private String studentCode;

    @NotNull(message = "Date of birth is required")
    @Schema(description = "Date of birth", example = "2015-05-15")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Gender is required")
    @Schema(description = "Gender", example = "Male")
    private String gender;

    @Email(message = "Invalid email format")
    @Schema(description = "Student email address", example = "arslan.ahmed@example.com")
    private String email;

    @Schema(description = "Contact phone number", example = "+923001234567")
    private String phone;

    @Schema(description = "Residential address", example = "Street 10, Sector F-6, Islamabad")
    private String address;

    @Schema(description = "Status indicating if the student is active", example = "true")
    private Boolean isActive;

    @Schema(description = "Detailed enrollment status", example = "ADMITTED")
    private String status;

    @NotNull(message = "Enrollment date is required")
    @Schema(description = "Date of enrollment", example = "2024-01-10")
    private LocalDate enrollmentDate;

    @Schema(description = "ID of the academic year", example = "2024")
    private Long academicYearId;

    @Schema(description = "Name of the academic year", example = "2024-2025")
    private String academicYearName;

    @Schema(description = "National ID or B-Form number", example = "61101-1234567-1")
    private String cnic;

    @Schema(description = "Passport number (optional)", example = "PK1234567")
    private String passportNumber;

    @Schema(description = "Religion", example = "Islam")
    private String religion;

    @Schema(description = "Nationality", example = "Pakistani")
    private String nationality;

    @Schema(description = "Blood group", example = "O+")
    private String bloodGroup;
}

