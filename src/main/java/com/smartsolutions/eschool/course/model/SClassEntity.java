package com.smartsolutions.eschool.course.model;

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
@Table(name = "classes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", insertable = false, updatable = false)
    @JsonIgnore
    private CourseEntity course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    @JsonIgnore
    private EmployeeEntity teacher;

    public enum DayOfWeek {
        Mon, Tue, Wed, Thu, Fri, Sat, Sun
    }
}
