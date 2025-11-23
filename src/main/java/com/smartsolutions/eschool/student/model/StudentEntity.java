package com.smartsolutions.eschool.student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;


    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "student_code", nullable = false, length = 50)
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

    //uzair need to remove going to use status
    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "status")
    private String status;

    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // ---- RELATIONSHIPS ---- //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus_id")
    @JsonIgnore
    private CampusEntity campus;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "guardian_id")
//    private GuardianEntity guardian;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "standard_id")
    @JsonIgnore
    private StandardEntity standard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
    @JsonIgnore
    private SectionEntity section;

    // ---- BASIC FIELDS ---- //
}
