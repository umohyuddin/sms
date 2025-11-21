package com.smartsolutions.eschool.student.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class StudentDTO {
    private Long id;
    private Long campusId;
    private Integer classId;

    private String firstName;
    private String fullName;
    private String lastName;

    private LocalDate dateOfBirth;
    private String gender;
    private String email;
    private String phone;
    private String address;

    private Boolean isActive;
    private Boolean isDeleted;
    private String status;
    private LocalDate enrollmentDate;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Optional: if you want to send related campus info
    private String campusName;

}
