package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeDepartmentHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeDepartmentHistoryRepository extends JpaRepository<EmployeeDepartmentHistoryEntity, Long> {

    @Query("""
        SELECT e FROM EmployeeDepartmentHistoryEntity e
        WHERE e.employee.id = :employeeId
        ORDER BY e.startDate DESC
    """)
    List<EmployeeDepartmentHistoryEntity> findByEmployeeId(@Param("employeeId") Long employeeId);

    @Query("""
        SELECT e FROM EmployeeDepartmentHistoryEntity e
        WHERE e.employee.id = :employeeId
          AND e.isCurrent = true
    """)
    Optional<EmployeeDepartmentHistoryEntity> findCurrentByEmployeeId(@Param("employeeId") Long employeeId);
}
