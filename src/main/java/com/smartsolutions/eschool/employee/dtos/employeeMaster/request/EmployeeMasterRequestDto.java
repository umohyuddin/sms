package com.smartsolutions.eschool.employee.dtos.employeeMaster.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class EmployeeMasterRequestDto {

    // Employee Identification
    private String employeeCode = "SMS";
    // Personal Information
    private String firstName;
    private String lastName;
    private String fullName;
    private String middleName;
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
    private Boolean active = true;

    // Relationships (by IDs)
//    private Long departmentId;       // FK to Department
//    private List<Long> roleIds;      // List of role IDs
}
