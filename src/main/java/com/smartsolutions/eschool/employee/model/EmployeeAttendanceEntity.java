package com.smartsolutions.eschool.employee.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "emp_attendance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_atn_id")
    private Long id;

    @Column(name = "emp_id")
    private Long empId;

    @Column(name = "attendance_date", nullable = false)
    private LocalDate attendanceDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AttendanceStatus status;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    private EmployeeEntity employee;

    public enum AttendanceStatus {
        P, // Present
        A, // Absent
        L  // Leave
    }
}
