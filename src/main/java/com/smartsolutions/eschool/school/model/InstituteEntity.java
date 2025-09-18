package com.smartsolutions.eschool.school.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "institutes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstituteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "contact_number", length = 20)
    private String contactNumber;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "website", nullable = true, length = 100)
    private String website;

    @Column(name = "tagline", length = 255)
    private String tagLine;

    @Column(name = "country", nullable = true, length = 100)
    private String country;

    @Lob
    @Column(name = "logo", nullable = true, columnDefinition = "LONGBLOB")
    private byte[] logo;

    @Column(name = "established_date")
    private LocalDate establishedDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "instituteId", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CampusEntity> campuses;
}
