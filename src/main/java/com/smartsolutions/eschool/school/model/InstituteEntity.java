package com.smartsolutions.eschool.school.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.lookups.model.CityEntity;
import com.smartsolutions.eschool.lookups.model.CountryEntity;
import com.smartsolutions.eschool.lookups.model.ProvinceEntity;
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
@Table(name = "institutes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstituteEntity  extends AuditableEntity {

    @Id
    @Column(name = "id")
    private Long id;

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

    @Lob
    @Column(name = "logo_url", nullable = true, columnDefinition = "LONGBLOB")
    private byte[] logo;

    @Column(name = "established_date")
    private LocalDate establishedDate;


    @OneToMany(mappedBy = "institute", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CampusEntity> campuses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private CountryEntity country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id", nullable = false)
    private ProvinceEntity province;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private CityEntity city;

}
