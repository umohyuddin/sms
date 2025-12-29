package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.response.EmployeeSalaryFullResponseDTO;
import com.smartsolutions.eschool.employee.model.EmployeeMasterSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeMasterSalaryRepository extends JpaRepository<EmployeeMasterSalary, Long> {

    // -------------------------
    // Find by Employee ID
    // -------------------------
    @Query("SELECT e FROM EmployeeMasterSalary e WHERE e.employee.id = :employeeId AND e.deleted = false")
    List<EmployeeMasterSalary> findAllByEmployeeId(@Param("employeeId") Long employeeId);

    // -------------------------
    // Find by Employee ID and Status
    // -------------------------
//    @Query("SELECT e FROM EmployeeMasterSalary e WHERE e.empId = :employeeId AND e.status = :status AND e.deleted = false")
//    List<EmployeeMasterSalary> findByEmployeeIdAndStatus(@Param("employeeId") Long employeeId,
//                                                         @Param("status") EmployeeSalaryEntity.SalaryStatus status);

    // -------------------------
    // Find by Salary Status
    // -------------------------
//    @Query("SELECT e FROM EmployeeMasterSalary e WHERE e.status = :status AND e.deleted = false")
//    List<EmployeeMasterSalary> findByStatus(@Param("status") SalaryStatus status);

    // -------------------------
    // Find by Effective Date (Payroll month)
    // -------------------------
    @Query("SELECT e FROM EmployeeMasterSalary e WHERE e.effectiveDate = :effectiveDate AND e.deleted = false")
    List<EmployeeMasterSalary> findByEffectiveDate(@Param("effectiveDate") LocalDate effectiveDate);

    // -------------------------
    // Check if salary exists for employee in a month/year
    // -------------------------
//    @Query("SELECT e FROM EmployeeMasterSalary e  WHERE e.employee.id = :employeeId AND e.year = :year AND e.month = :month AND e.deleted = false")
//    Optional<EmployeeMasterSalary> findByEmployeeAndMonth(@Param("employeeId") Long employeeId,
//                                                          @Param("year") Integer year,
//                                                          @Param("month") Integer month);

    // -------------------------
    // Find all salaries for an employee within a date range
    // -------------------------
    @Query("SELECT e FROM EmployeeMasterSalary e  WHERE e.employee.id = :employeeId AND e.effectiveDate BETWEEN :from AND :to AND e.deleted = false")
    List<EmployeeMasterSalary> findSalariesByEmployeeAndDateRange(@Param("employeeId") Long employeeId,
                                                                  @Param("from") LocalDate from,
                                                                  @Param("to") LocalDate to);

    // -------------------------
    // Soft delete by ID
    // -------------------------
    @Query("UPDATE EmployeeMasterSalary e SET e.deleted = true WHERE e.id = :id")
    void softDeleteById(@Param("id") Long id);


    @Query("""
                SELECT s
                FROM EmployeeMasterSalary s
                JOIN FETCH s.employee e
                WHERE s.deleted = false
                ORDER BY s.effectiveDate DESC
            """)
    List<EmployeeMasterSalary> findEmployeeSalaryList();
}