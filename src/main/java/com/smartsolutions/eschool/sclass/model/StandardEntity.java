package com.smartsolutions.eschool.sclass.model;

import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "standards")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "standard_name")
    private String standardName;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "standard", cascade = CascadeType.ALL)
    private List<SectionEntity> sections;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus_id", nullable = false)
    private CampusEntity campus;

    @OneToMany(mappedBy = "standard", fetch = FetchType.LAZY)
    private List<StudentEntity> students;

}
