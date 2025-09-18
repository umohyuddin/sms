package com.smartsolutions.eschool.student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long studentId;

    @Column(name = "cmp_id", nullable = false)
    private Long campusId;

    @Column(name = "dpt_id", nullable = false)
    private Integer departmentId;

    @Column(name = "grade", nullable = false)
    private Integer grade;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "dob", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "isactive")
    private Boolean isActive;

    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cmp_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private CampusEntity campus;


    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<StudentAttendanceEntity> attendances;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<FeeEntity> fees;



}
