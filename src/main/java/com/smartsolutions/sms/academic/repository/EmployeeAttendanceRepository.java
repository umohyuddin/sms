package com.smartsolutions.sms.academic.repository;

import com.smartsolutions.sms.academic.entity.master.EmployeeAttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendanceEntity, Long> {

    @Query("SELECT ea FROM EmployeeAttendanceEntity ea WHERE ea.employee.id = :employeeId " +
           "AND ea.attendanceDate BETWEEN :startDate AND :endDate AND ea.deleted = false")
    List<EmployeeAttendanceEntity> findMonthlyView(@Param("employeeId") Long employeeId,
                                                 @Param("startDate") LocalDate startDate,
                                                 @Param("endDate") LocalDate endDate);

    @Modifying
    @Query("UPDATE EmployeeAttendanceEntity ea SET ea.deleted = true, ea.deletedAt = CURRENT_TIMESTAMP WHERE ea.id = :id")
    void softDeleteById(@Param("id") Long id);
}
