package com.smartsolutions.eschool.sclass.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartsolutions.eschool.student.model.StudentAttendanceEntity;
import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "subject")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "course_code", nullable = false, unique = true, length = 10)
    private String courseCode;

    @Column(name = "course_name", nullable = false, length = 100)
    private String courseName;

    @Column(name = "grade", nullable = false)
    private Integer grade;

    @Column(name = "dpt_id")
    private Integer departmentId;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "isactive")
    private Boolean isActive;

    @Column(name = "credits", nullable = false)
    private Integer credits;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

}
