package com.smartsolutions.eschool.student.dtos.student.responseDto;

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
public class StudentResponseDTO {
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    private String studentCode;
    private LocalDate dateOfBirth;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String cnic;
    private String passportNumber;
    private String religion;
    private String nationality;
    private String bloodGroup;
    private Boolean isActive;
    private String status;
    private LocalDate enrollmentDate;
    private boolean deleted;
    private LocalDateTime deletedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // --- Foreign key objects ---
    private Long campusId;
    private String campusName;

    private Long standardId;
    private String standardName;

    private Long sectionId;
    private String sectionName;

    private Long admissionTypeId;
    private String admissionTypeName;

    private Long academicYearId;
    private String academicYearName;
}
