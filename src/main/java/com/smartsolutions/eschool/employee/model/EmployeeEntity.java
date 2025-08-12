package com.smartsolutions.eschool.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartsolutions.eschool.course.model.CourseEntity;
import com.smartsolutions.eschool.course.model.SClassEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
import com.smartsolutions.eschool.user.model.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "emp_role_id", nullable = false)
    private Long roleId;

    @Column(name = "cmp_id", nullable = false)
    private Long campusId;

    @Column(name = "dpt_id", nullable = true)
    private Long departmentId;

    @Column(name = "f_name", nullable = false)
    private String firstName;

    @Column(name = "l_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone")
    private String phoneNo;

    @Column(name = "hire_date", nullable = false)
    private Date hireDate;

    @Column(name = "department")
    private String department;

    @Column(name = "isactive")
    private String isActive;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "dpt_id", referencedColumnName = "department_id",insertable=false, updatable=false, nullable = true)
    @JsonIgnore
    private DepartmentEntity departmentEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "emp_role_id", referencedColumnName = "id",insertable=false, updatable=false, nullable = true)
    @JsonIgnore
    private EmployeeRoleEntity role;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "cmp_id", referencedColumnName = "campus_id",insertable=false, updatable=false, nullable = true)
    @JsonIgnore
    private CampusEntity campus;

    @OneToOne(mappedBy = "head", fetch = FetchType.LAZY)
    @JsonIgnore
    private DepartmentEntity head;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SClassEntity> classes;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CourseEntity> courses;

    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonIgnore
    private UserEntity user;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<EmployeeAttendanceEntity> attendance;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<EmployeeSalaryEntity> salary;
}
