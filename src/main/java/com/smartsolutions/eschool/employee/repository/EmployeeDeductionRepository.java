package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeAdvanceEntity;
import com.smartsolutions.eschool.employee.model.EmployeeDeductionEntity;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeDeductionRepository extends JpaRepository<EmployeeDeductionEntity, Long> {

    // -------------------------
    // Find by ID where not deleted
    // -------------------------
    @Query("SELECT e FROM EmployeeDeductionEntity e WHERE e.id = :id AND e.deleted = false")
    Optional<EmployeeDeductionEntity> findByIdActive(Long id);

    // -------------------------
    // Find all active deductions
    // -------------------------
    @Query("SELECT e FROM EmployeeDeductionEntity e WHERE e.deleted = false ORDER BY e.id DESC")
    List<EmployeeDeductionEntity> findAllActive();

    // -------------------------
    // Find all active deductions for an employee
    // -------------------------
    @Query("SELECT e FROM EmployeeDeductionEntity e WHERE e.employee.id = :employeeId AND e.deleted = false ORDER BY e.month DESC")
    List<EmployeeDeductionEntity> findAllByEmployeeIdActive(Long employeeId);

    // -------------------------
    // Soft delete by ID
    // -------------------------
    @Modifying
    @Query("UPDATE EmployeeDeductionEntity e SET e.deleted = true WHERE e.id = :id")
    void softDeleteById(Long id);
}

