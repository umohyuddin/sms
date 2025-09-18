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
    private Integer classId;

    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "classroom", length = 50)
    private String classroom;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", nullable = false)
    private DayOfWeek dayOfWeek;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


    public enum DayOfWeek {
        Mon, Tue, Wed, Thu, Fri, Sat, Sun
    }
}
