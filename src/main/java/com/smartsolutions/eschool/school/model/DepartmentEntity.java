package com.smartsolutions.eschool.school.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartsolutions.eschool.course.model.CourseEntity;
import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
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
@Table(name = "departments")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "cmp_id", nullable = false)
    private Long campusId;

    @Column(name = "department_name", nullable = false, unique = true, length = 100)
    private String departmentName;

    @Column(name = "dpt_head_id")
    private Long departmentHeadId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cmp_id", referencedColumnName = "campus_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private CampusEntity campus;

    @OneToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "dpt_head_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    @JsonIgnore
    private EmployeeEntity head;

    @OneToMany(mappedBy = "departmentEntity", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<EmployeeEntity> employees;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<StudentEntity> students;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CourseEntity> courses;

}
