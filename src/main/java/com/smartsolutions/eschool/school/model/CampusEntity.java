package com.smartsolutions.eschool.school.model;
import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "campuses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampusEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id")
    private InstituteEntity institute;

    @Column(name = "campus_name", nullable = false, length = 100)
    private String campusName;

    @Column(name = "campus_code")
    private String campusCode;

    @Column(name = "contact", nullable = true, length = 20)
    private String contactNumber;

    @Column(name = "email", nullable = true, length = 100)
    private String email;

    @Column(name = "website", nullable = true, length = 100)
    private String website;

    @Column(name = "address", length = 255)
    private String address;
    @Column(name = "active")
    private boolean active = true;
    @Lob
    @Column(name = "logo", nullable = true, columnDefinition = "LONGBLOB")
    private byte[] logo;


    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;


    @Column(name = "province_id")
    private Long provinceId;
    @Column(name = "city_id")
    private Long cityId;


    // ---- RELATIONSHIPS ---- //
    @OneToMany(mappedBy = "campus", cascade = CascadeType.ALL)
    private List<StandardEntity> standards;

    @OneToMany(mappedBy = "campus", fetch = FetchType.LAZY)
    private List<StudentEntity> students;
}
