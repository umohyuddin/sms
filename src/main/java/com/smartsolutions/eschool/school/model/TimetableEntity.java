package com.smartsolutions.eschool.school.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "timetable")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimetableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cls_id")
    private Integer classId;

    @Column(name = "duration")
    private String duration;

    @Column(name = "mon")
    private String mon;

    @Column(name = "tue")
    private String tue;

    @Column(name = "wed")
    private String wed;

    @Column(name = "thu")
    private String thu;

    @Column(name = "fri")
    private String fri;

    @Column(name = "sat")
    private String sat;

    @Column(name = "sun")
    private String sun;

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
