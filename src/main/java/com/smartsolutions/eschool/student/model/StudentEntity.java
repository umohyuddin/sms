package com.smartsolutions.eschool.student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "student_code", nullable = false, length = 50,unique = true)
    private String studentCode;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "cnic", length = 20)
    private String cnic;

    @Column(name = "passport_number", length = 20)
    private String passportNumber;

    @Column(name = "religion", length = 50)
    private String religion;

    @Column(name = "nationality", length = 50)
    private String nationality;

    @Column(name = "blood_group", length = 10)
    private String bloodGroup;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // --- RELATIONSHIPS --- //

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus_id")
    @JsonIgnore
    private CampusEntity campus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "standard_id")
    @JsonIgnore
    private StandardEntity standard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
    @JsonIgnore
    private SectionEntity section;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admission_type_id")
    private AdmissionTypeEntity admissionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_year_id", nullable = false)
    private AcademicYearEntity academicYear;
    // Optional: bidirectional mapping to fees
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<StudentFeeAssignmentEntity> feeAssignments;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<StudentFeePaymentEntity> feePayments;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentFeeSummaryEntity> feeSummaries;
}
