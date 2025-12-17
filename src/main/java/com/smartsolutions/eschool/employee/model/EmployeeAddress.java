package com.smartsolutions.eschool.employee.model;


import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeAddress  extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false, foreignKey = @ForeignKey(name = "fk_employee"))
    private EmployeeMasterEntity employee;

    @Column(name = "address_type", length = 50, nullable = false)
    private String addressType;

    @Column(name = "line1", length = 255, nullable = false)
    private String line1;

    @Column(name = "line2", length = 255)
    private String line2;

    @Column(name = "city", length = 100, nullable = false)
    private String city;

    @Column(name = "state", length = 100)
    private String state;

    @Column(name = "postal_code", length = 20)
    private String postalCode;

    @Column(name = "country", length = 100, nullable = false)
    private String country;
}
