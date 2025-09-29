package com.smartsolutions.eschool.school.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.user.model.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "campuses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "inst_id")
    private Integer instituteId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "contact", nullable = true, length = 20)
    private String contactNumber;

    @Column(name = "email", nullable = true, length = 100)
    private String email;

    @Column(name = "website", nullable = true, length = 100)
    private String website;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "province", nullable = true, length = 100)
    private String province;

    @Lob
    @Column(name = "logo", nullable = true, columnDefinition = "LONGBLOB")
    private byte[] logo;

    @Column(name = "city", length = 50)
    private String city;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    @PrePersist
    public  void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

}
