package com.smartsolutions.eschool.school.model;

import com.smartsolutions.eschool.employee.model.EmployeeTypeEntity;
import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "designations")
@Getter
@Setter
public class DesignationEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "designation_code", nullable = false, unique = true, length = 50)
    private String designationCode;

    @Column(name = "designation_name", nullable = false, length = 150)
    private String designationName;

    @Column(length = 255)
    private String description;

    // Link to Employee Type (mandatory)
    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_type_id", nullable = false)
    private EmployeeTypeEntity employeeType;

    // Optional link to department
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

    @Column(name = "active", nullable = false)
    private Boolean active = true;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

}