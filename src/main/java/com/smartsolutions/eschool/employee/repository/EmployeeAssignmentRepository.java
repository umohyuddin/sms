package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeAssignmentRepository extends JpaRepository<EmployeeAssignmentEntity, Long> {

    @Query("SELECT e FROM EmployeeAssignmentEntity e WHERE e.employee.id = :employeeId AND e.isPrimary = true AND e.deleted = false")
    Optional<EmployeeAssignmentEntity> findPrimaryAssignmentByEmployeeId(@Param("employeeId") Long employeeId);
}
