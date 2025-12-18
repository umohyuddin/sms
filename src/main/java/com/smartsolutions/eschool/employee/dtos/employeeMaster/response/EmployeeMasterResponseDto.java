package com.smartsolutions.eschool.employee.dtos.employeeMaster.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeMasterResponseDto {

    private Long id;
    private String employeeCode;

    // Personal Information
    private String firstName;
    private String lastName;
    private String middleName;
    private String fullName;
    private String gender;
    private String email;
    private Date dateOfBirth;
    private String maritalStatus;
    private String religion;
    private String nationality;
    private String bloodGroup;

    // Employment Details
    private Date joiningDate;
    private Date probationEndDate;

    // Contact Information
    private String primaryPhone;
    private String secondaryPhone;
    private String workPhone;

    // Profile
    private String profilePicture;
    private String bio;

    // Status
    private Boolean active;
}
