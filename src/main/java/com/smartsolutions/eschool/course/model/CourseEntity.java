package com.smartsolutions.eschool.course.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
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
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dpt_id", referencedColumnName = "department_id", insertable = false, updatable = false)
    @JsonIgnore
    private DepartmentEntity department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    @JsonIgnore
    private EmployeeEntity teacher;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<StudentAttendanceEntity> attendances;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<SClassEntity> classes;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<EnrollmentEntity> enrollments;
}
