package com.smartsolutions.eschool.student.dtos;

import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;
    private String firstName;
    private String fullName;
    private String lastName;
    private String studentCode;
    private LocalDate dateOfBirth;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private Boolean isActive;
    private boolean deleted;
    private LocalDateTime deletedAt;
    private String status;
    private LocalDate enrollmentDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Relationships
    private CampusResponseDTO campus;
    private StandardDTO standard;
    private SectionDTO section;

    private Long campusId;
    private Long standardId;
    private Long sectionId;
}
