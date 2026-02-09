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
    // Find by ID and organization where not deleted
    // -------------------------
    @Query("SELECT e FROM EmployeeDeductionEntity e WHERE e.id = :id AND e.organizationId = :organizationId AND e.deleted = false")
    Optional<EmployeeDeductionEntity> findByIdAndOrganizationIdActive(@Param("id") Long id, @Param("organizationId") Long organizationId);

    // -------------------------
    // Find all active deductions for an organization
    // -------------------------
    @Query("SELECT e FROM EmployeeDeductionEntity e WHERE e.organizationId = :organizationId AND e.deleted = false ORDER BY e.id DESC")
    List<EmployeeDeductionEntity> findAllActive(@Param("organizationId") Long organizationId);

    // -------------------------
    // Find all active deductions for an employee and organization
    // -------------------------
    @Query("SELECT e FROM EmployeeDeductionEntity e WHERE e.employee.id = :employeeId AND e.organizationId = :organizationId AND e.deleted = false ORDER BY e.month DESC")
    List<EmployeeDeductionEntity> findAllByEmployeeIdAndOrganizationIdActive(@Param("employeeId") Long employeeId, @Param("organizationId") Long organizationId);

    // -------------------------
    // Soft delete by ID and organization
    // -------------------------
    @Modifying
    @Query("UPDATE EmployeeDeductionEntity e SET e.deleted = true WHERE e.id = :id AND e.organizationId = :organizationId")
    void softDeleteByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @Query("""
                SELECT e 
                FROM EmployeeMasterEntity e
                LEFT JOIN FETCH e.deductions d
                WHERE e.id = :employeeId AND e.organizationId = :organizationId
                  AND (d.deleted = false OR d IS NULL)
            """)
    Optional<EmployeeMasterEntity> findEmployeeWithActiveDeductionsAndOrganizationId(@Param("employeeId") Long employeeId, @Param("organizationId") Long organizationId);

}

