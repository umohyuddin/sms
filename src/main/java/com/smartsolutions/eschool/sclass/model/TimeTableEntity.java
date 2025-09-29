package com.smartsolutions.eschool.sclass.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "timetable")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeTableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cls_id")
    private Integer classId;

    @Column(name = "duration", length = 100)
    private String duration;

    @Column(name = "mon", length = 100)
    private String mon;

    @Column(name = "tue", length = 100)
    private String tue;

    @Column(name = "wed", length = 100)
    private String wed;

    @Column(name = "thu", length = 100)
    private String thu;

    @Column(name = "fri", length = 100)
    private String fri;

    @Column(name = "sat", length = 100)
    private String sat;

    @Column(name = "sun", length = 100)
    private String sun;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
