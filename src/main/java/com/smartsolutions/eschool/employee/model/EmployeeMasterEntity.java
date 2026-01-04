package com.smartsolutions.eschool.employee.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(
        name = "employee_master",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "employee_code")
        },
        indexes = {
                @Index(name = "idx_employee_code", columnList = "employee_code"),
                @Index(name = "idx_employee_designation", columnList = "designation"),
                @Index(name = "idx_employee_department", columnList = "department"),
                @Index(name = "idx_employee_active", columnList = "is_active")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeMasterEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // Link to User (Login)
    // =========================
//    @Column(name = "user_id", nullable = false, unique = true)
//    private Long userId;   // FK → users.id

    // =========================
    // Employee Identification
    // =========================
    @Column(name = "employee_code", nullable = false, length = 50)
    private String employeeCode;

    // =========================
    // Personal Information
    // =========================
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "full_Name", nullable = false, length = 100)
    private String fullName;
    @Column(name = "middle_Name", length = 100)
    private String middleName;

    @Column(length = 10)
    private String gender;

    @Column(name = "email", nullable = false, length = 100)
    private  String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "marital_status", length = 20)
    private String maritalStatus;


    @Column(name = "cnic", length = 20)
    private String cnic;

    @Column(name = "passport_number", length = 20)
    private String passportNumber;

    @Column(length = 50)
    private String religion;

    @Column(length = 50)
    private String nationality;

    @Column(name = "blood_group", length = 10)
    private String bloodGroup;


    // =========================
    // Employment Details
    // =========================
//    @Column(name = "designation", length = 100)
//    private String designation;     // TEACHER, ADMIN, STAFF
//
//    @Column(name = "department", length = 100)
//    private String department;      // Academic, Finance, HR
//
//    @Column(name = "employment_type", length = 20)
//    private String employmentType;  // PERMANENT, CONTRACT, VISITING

    @Temporal(TemporalType.DATE)
    @Column(name = "joining_date")
    private Date joiningDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "probation_end_date")
    private Date probationEndDate;


    @Column(name = "primary_phone", length = 20)
    private String primaryPhone;

    @Column(name = "secondary_phone", length = 20)
    private String secondaryPhone;

    @Column(name = "work_phone", length = 20)
    private String workPhone;

//    // =========================
//    // Address
//    // =========================
//    @Column(name = "address_line1", length = 255)
//    private String addressLine1;
//
//    @Column(name = "address_line2", length = 255)
//    private String addressLine2;
//
//    @Column(length = 100)
//    private String city;
//
//    @Column(length = 100)
//    private String country;

    // =========================
    // Emergency Contact
    // =========================
//    @Column(name = "emergency_contact_name", length = 100)
//    private String emergencyContactName;
//
//    @Column(name = "emergency_contact_phone", length = 20)
//    private String emergencyContactPhone;

    // =========================
    // Profile
    // =========================
    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(columnDefinition = "TEXT")
    private String bio;

    // =========================
    // Status & Lifecycle
    // =========================
    @Column(name = "active", nullable = false)
    private Boolean active = true;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EmployeeDeductionEntity> deductions;

    // Employee Advances (if you have an EmployeeAdvanceEntity)
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EmployeeAdvanceEntity> advances;
    // Employee Salaries
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EmployeeMasterSalary> salaries;
}
