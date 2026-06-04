package com.smartsolutions.eschool.student.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@SQLDelete(sql = "UPDATE guardians SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "guardians", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"organization_id", "cnic"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GuardianEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "campus_id")
    private Long campusId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "full_name", nullable = false, length = 120)
    private String fullName;

    @Column(name = "relation_id", nullable = false)
    private Long relationId;

    @Column(name = "cnic", nullable = false, length = 20)
    private String cnic;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Column(name = "alternate_phone", length = 15)
    private String alternatePhone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "occupation", length = 100)
    private String occupation;

    @Column(name = "organization", length = 150)
    private String organization;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "status", length = 20)
    private String status;
}
