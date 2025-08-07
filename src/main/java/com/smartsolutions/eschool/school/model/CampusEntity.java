package com.smartsolutions.eschool.school.model;
import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.user.model.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
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
    @Column(name = "campus_id")
    private Long campusId;

    @Column(name = "inst_id")
    private Integer instituteId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "city", length = 50)
    private String city;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inst_id", referencedColumnName = "institute_id", insertable = false, updatable = false)
    private InstituteEntity institute;

    @OneToMany(mappedBy = "campusId", fetch = FetchType.LAZY)
    private List<InventoryEntity> inventories;

    @OneToMany(mappedBy = "campusId", fetch = FetchType.LAZY)
    private List<DepartmentEntity> departments;

    @OneToMany(mappedBy = "campus", fetch = FetchType.LAZY)
    private List<StudentEntity> students;

    @OneToMany(mappedBy = "campus", fetch = FetchType.LAZY)
    private List<EmployeeEntity> employees;

    @OneToOne(mappedBy = "campus", fetch = FetchType.LAZY)
    private UserEntity user;
}
