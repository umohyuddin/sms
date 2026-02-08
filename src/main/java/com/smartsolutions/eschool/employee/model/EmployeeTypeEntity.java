package com.smartsolutions.eschool.employee.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "employee_type")
@Getter
@Setter
@SQLDelete(sql = "UPDATE employee_type SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class EmployeeTypeEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(length = 255)
    private String description;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(nullable = false)
    private Boolean deleted = false;



}