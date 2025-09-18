package com.smartsolutions.eschool.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartsolutions.eschool.school.model.CampusEntity;
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
    @Column(name = "id")
    private Long id;

    @Column(name = "emp_role_id", nullable = false)
    private Integer roleId;

    @Column(name = "cmp_id", nullable = false)
    private Long campusId;

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


    @Column(name = "isactive")
    private String isActive;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "emp_role_id", referencedColumnName = "id",insertable=false, updatable=false, nullable = true)
    @JsonIgnore
    private EmployeeRoleEntity role;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "cmp_id", referencedColumnName = "id",insertable=false, updatable=false, nullable = true)
    @JsonIgnore
    private CampusEntity campus;


    @OneToOne(mappedBy = "employee", fetch = FetchType.EAGER)
    @JsonIgnore
    private UserEntity user;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<EmployeeAttendanceEntity> attendance;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<EmployeeSalaryEntity> salary;
}
