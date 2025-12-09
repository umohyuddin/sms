package com.smartsolutions.eschool.student.dtos.student.requestDto;


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
public class StudentRequestDTO {

    @NotNull(message = "Campus ID is required")
    private Long campusId;

    @NotNull(message = "Standard ID is required")
    private Long standardId;

    @NotNull(message = "Section ID is required")
    private Long sectionId;

    @NotNull(message = "Admission Type ID is required")
    private Long admissionTypeId;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    private String middleName;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Student code is required")
    private String studentCode;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Gender is required")
    private String gender;

    @Email(message = "Invalid email format")
    private String email;

    private String phone;

    private String address;

    private Boolean isActive;

    private String status;

    @NotNull(message = "Enrollment date is required")
    private LocalDate enrollmentDate;

    private Long academicYearId;
    private String academicYearName;
    private String cnic;
    private String passportNumber;
    private String religion;
    private String nationality;
    private String bloodGroup;
}

