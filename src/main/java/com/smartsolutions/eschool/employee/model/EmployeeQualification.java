package com.smartsolutions.eschool.employee.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_qualification")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeQualification extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeMasterEntity employee;

    @Column(name = "degree", nullable = false, length = 100)
    private String degree;

    @Column(name = "major_subject", length = 100)
    private String majorSubject;

    @Column(name = "institute", length = 150)
    private String institute;

    @Column(name = "year_of_passing")
    private Integer yearOfPassing;

    @Column(name = "grade", length = 20)
    private String grade;

    @Column(name = "certificate", length = 255)
    private String certificate;
}
