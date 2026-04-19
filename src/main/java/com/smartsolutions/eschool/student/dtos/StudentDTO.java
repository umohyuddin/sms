package com.smartsolutions.eschool.student.dtos;

import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentStandardDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Data Transfer Object for Student information")
public class StudentDTO {
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

    @Schema(description = "Indicates if the record is soft-deleted", example = "false")
    private boolean deleted;

    @Schema(description = "Timestamp when the record was soft-deleted")
    private LocalDateTime deletedAt;

    @Schema(description = "Current enrollment status (e.g., ADMITTED, WITHDRAWN)", example = "ADMITTED")
    private String status;

    @Schema(description = "Date of enrollment in the institute", example = "2024-01-10")
    private LocalDate enrollmentDate;

    @Schema(description = "Timestamp when the record was created")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the record was last updated")
    private LocalDateTime updatedAt;

    @Schema(description = "Indicates if fee has been assigned to the student", example = "true")
    private boolean feeAssigned;

    // Relationships
    @Schema(description = "Campus details")
    private CampusResponseDTO campus;

    @Schema(description = "Academic standard details")
    private StudentStandardDTO standard;

    @Schema(description = "ID of the associated campus", example = "1")
    private Long campusId;

    @Schema(description = "ID of the academic standard (class)", example = "5")
    private Long standardId;

    @Schema(description = "ID of the section", example = "1")
    private Long sectionId;

    @Schema(description = "ID of the active academic year", example = "2024")
    private Long academicYearId;
}
