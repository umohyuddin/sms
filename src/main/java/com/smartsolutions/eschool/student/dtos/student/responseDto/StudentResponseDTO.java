package com.smartsolutions.eschool.student.dtos.student.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response object containing detailed student profile information")
public class StudentResponseDTO {
    @Schema(description = "Unique identifier of the student", example = "1")
    private Long id;

    @Schema(description = "First name of the student", example = "Arslan")
    private String firstName;

    @Schema(description = "Middle name of the student", example = "Khan")
    private String middleName;

    @Schema(description = "Last name of the student", example = "Ahmed")
    private String lastName;

    @Schema(description = "Full name of the student", example = "Arslan Khan Ahmed")
    private String fullName;

    @Schema(description = "Unique admission code for the student", example = "STU-2024-001")
    private String studentCode;

    @Schema(description = "Date of birth", example = "2015-05-15")
    private LocalDate dateOfBirth;

    @Schema(description = "Gender", example = "Male")
    private String gender;

    @Schema(description = "Email address", example = "arslan.ahmed@example.com")
    private String email;

    @Schema(description = "Contact phone number", example = "+923001234567")
    private String phone;

    @Schema(description = "Residential address", example = "Street 10, Sector F-6, Islamabad")
    private String address;

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

    @Schema(description = "Status indicating if the student is active", example = "true")
    private Boolean isActive;

    @Schema(description = "Detailed enrollment status", example = "ADMITTED")
    private String status;

    @Schema(description = "Date of enrollment", example = "2024-01-10")
    private LocalDate enrollmentDate;

    @Schema(description = "Indicates if the record is soft-deleted", example = "false")
    private boolean deleted;

    @Schema(description = "Timestamp when the record was soft-deleted")
    private LocalDateTime deletedAt;

    @Schema(description = "Timestamp when the record was created")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the record was last updated")
    private LocalDateTime updatedAt;

    // --- Foreign key objects ---
    @Schema(description = "ID of the associated campus", example = "1")
    private Long campusId;

    @Schema(description = "Name of the associated campus", example = "Main Campus")
    private String campusName;

    @Schema(description = "ID of the academic standard", example = "5")
    private Long standardId;

    @Schema(description = "Name of the academic standard", example = "Class 5")
    private String standardName;

    @Schema(description = "ID of the section", example = "1")
    private Long sectionId;

    @Schema(description = "Name of the section", example = "Section A")
    private String sectionName;

    @Schema(description = "ID of the admission type", example = "2")
    private Long admissionTypeId;

    @Schema(description = "Name of the admission type", example = "New Admission")
    private String admissionTypeName;

    @Schema(description = "ID of the academic year", example = "2024")
    private Long academicYearId;

    @Schema(description = "Name of the academic year", example = "2024-2025")
    private String academicYearName;
}
