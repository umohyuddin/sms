package com.smartsolutions.eschool.employee.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee_type_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeTypeHistoryEntity extends AuditableEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name = "employee_id", nullable = false)
private EmployeeMasterEntity employee;

@ManyToOne
@JoinColumn(name = "employee_type_id", nullable = false)
private EmployeeTypeEntity employeeType;

@Column(name = "start_date", nullable = false)
private LocalDateTime startDate;

@Column(name = "end_date")
private LocalDateTime endDate;

@Column(name = "is_current", nullable = false)
private Boolean isCurrent = true;
}
