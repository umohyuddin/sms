package com.smartsolutions.eschool.school.model;

import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class DepartmentEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_code", nullable = false, unique = true, length = 50)
    private String departmentCode;

    @Column(name = "department_name", nullable = false, length = 150)
    private String departmentName;

    @Column(length = 255)
    private String description;

    // Hierarchy - self reference
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private DepartmentEntity parentDepartment;

    // Head of Department
    @ManyToOne
    @JoinColumn(name = "head_employee_id")
    private EmployeeMasterEntity headEmployee;

    @Column(name = "active", nullable = false)
    private Boolean active = true;

    @Column(name = "deleted")
    private Boolean deleted = false;
}
